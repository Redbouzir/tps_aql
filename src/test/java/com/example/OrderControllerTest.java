package com.example;

import com.example.controller.OrderController;
import com.example.model.Order;
import com.example.repository.OrderDao;
import com.example.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderController orderController;

    @Test
    void createOrder_ShouldCallServiceWithCorrectOrder() {
        // Given
        Order order = new Order(1L, "Test Product", 99.99, 2);
        OrderService orderService = new OrderService(orderDao);
        OrderController controller = new OrderController(orderService);

        // When
        controller.createOrder(order);

        // Then
        verify(orderDao, times(1)).saveOrder(order);
    }

    @Test
    void createOrder_ShouldPropagateOrderThroughAllLayers() {
        // Given
        Order order = new Order(1L, "Test Product", 99.99, 2);
        OrderService orderService = new OrderService(orderDao);
        OrderController controller = new OrderController(orderService);

        // When
        controller.createOrder(order);

        // Then
        verify(orderDao, times(1)).saveOrder(order);
    }
} 