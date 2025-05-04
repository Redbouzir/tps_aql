package com.example.taskmanager;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class TaskControllerIntegrationTest {

    @Container
    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0.30")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test")
            .withReuse(true);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TaskRepository taskRepository;

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.driver-class-name", mysql::getDriverClassName);
    }

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    public void testCreateTask() {
        // Given
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Test Description");

        // When
        ResponseEntity<Task> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/tasks",
                task,
                Task.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Test Task");
        assertThat(response.getBody().getDescription()).isEqualTo("Test Description");
    }

    @Test
    public void testGetTask() {
        // Given
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        Task savedTask = taskRepository.save(task);

        // When
        ResponseEntity<Task> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/tasks/" + savedTask.getId(),
                Task.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(savedTask.getId());
        assertThat(response.getBody().getTitle()).isEqualTo("Test Task");
    }

    @Test
    public void testUpdateTask() {
        // Given
        Task task = new Task();
        task.setTitle("Original Title");
        task.setDescription("Original Description");
        Task savedTask = taskRepository.save(task);

        Task updatedTask = new Task();
        updatedTask.setTitle("Updated Title");
        updatedTask.setDescription("Updated Description");

        // When
        ResponseEntity<Task> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/tasks/" + savedTask.getId(),
                HttpMethod.PUT,
                new HttpEntity<>(updatedTask),
                Task.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Updated Title");
        assertThat(response.getBody().getDescription()).isEqualTo("Updated Description");
    }

    @Test
    public void testDeleteTask() {
        // Given
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        Task savedTask = taskRepository.save(task);

        // When
        restTemplate.delete("http://localhost:" + port + "/api/tasks/" + savedTask.getId());

        // Then
        assertThat(taskRepository.findById(savedTask.getId())).isEmpty();
    }
} 