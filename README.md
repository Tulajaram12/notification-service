# Notification Service

Notification microservice for the e-commerce application.

## Technology

- Java 21
- Spring Boot
- Maven
- PostgreSQL
- Docker
- Jenkins
- Kubernetes
- Amazon EKS

## Port

8086

## APIs

### Create Notification

POST

/api/notifications

Example request:

{
    "userId": 10,
    "orderId": 101,
    "type": "EMAIL",
    "message": "Your order has been created"
}

Example response:

{
    "id": 1,
    "userId": 10,
    "orderId": 101,
    "type": "EMAIL",
    "message": "Your order has been created",
    "status": "SENT"
}

### Get All Notifications

GET

/api/notifications

### Get Notification

GET

/api/notifications/{id}

Example:

/api/notifications/1

### Get Notifications By User

GET

/api/notifications/user/{userId}

Example:

/api/notifications/user/10

### Get Notifications By Order

GET

/api/notifications/order/{orderId}

Example:

/api/notifications/order/101

### Update Notification Status

PATCH

/api/notifications/{id}/status?status=FAILED

Possible statuses:

SENT
FAILED
PENDING

### Delete Notification

DELETE

/api/notifications/{id}

## Run Locally

Make sure PostgreSQL is running.

Database:

ecommerce

Username:

postgres

Password:

postgres

Then run:

mvn spring-boot:run

Application will start on:

http://localhost:8086
