# Task Manager Application with Testcontainers

Ce projet est une application de gestion de tâches développée avec Spring Boot et testée avec Testcontainers.

## Prérequis

- Java 11 ou supérieur
- Maven
- Docker
- MySQL (pour le développement local)

## Structure du Projet

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── taskmanager/
│   │               ├── controller/
│   │               ├── model/
│   │               ├── repository/
│   │               ├── service/
│   │               └── TaskManagerApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── example/
                └── taskmanager/
                    └── TaskControllerIntegrationTest.java
```

## Fonctionnalités

- Création de tâches
- Lecture de tâches
- Mise à jour de tâches
- Suppression de tâches

## Tests d'Intégration

Les tests d'intégration utilisent Testcontainers pour créer un environnement de test isolé avec une base de données MySQL. Les tests couvrent :

- Création de tâches
- Lecture de tâches
- Mise à jour de tâches
- Suppression de tâches

## Installation et Exécution

1. Cloner le projet :
```bash
git clone <repository-url>
```

2. Compiler le projet :
```bash
mvn clean install
```

3. Exécuter l'application :
```bash
mvn spring-boot:run
```

4. Exécuter les tests :
```bash
mvn test
```

## API Endpoints

- `POST /api/tasks` - Créer une nouvelle tâche
- `GET /api/tasks` - Lister toutes les tâches
- `GET /api/tasks/{id}` - Obtenir une tâche spécifique
- `PUT /api/tasks/{id}` - Mettre à jour une tâche
- `DELETE /api/tasks/{id}` - Supprimer une tâche

## Configuration

Le fichier `application.properties` contient les configurations suivantes :

- Configuration de la base de données
- Configuration JPA
- Configuration du serveur

## Technologies Utilisées

- Spring Boot
- Spring Data JPA
- MySQL
- Testcontainers
- JUnit 5
- Maven 