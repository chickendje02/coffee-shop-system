## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Workflow](#workflow)
* [Database Design](#database-design)
* [System Design](#system-design)
* [Security Solution](#security-solution)

## General info 
**Coffee Shop System**

A system for management the Coffee shop and Customer. System aims to provide simple step-by-step for customers to register/login and then they can find the closest available coffee shop so they can place order online. The system also provides the customer the current position's customer in the queue and expected waiting time.
## Technologies
* Java 11
* Springboot 2.7.15
* PostgreSQL
* Kafka
* Liquibase
* Spring Data
* Swagger
* Spring Security
## Workflow
![Workflow](https://github.com/chickendje02/coffee-shop-system/blob/main/workflow.png)

# Database Design
![Workflow](https://github.com/chickendje02/coffee-shop-system/blob/main/design_db_coffee_shop.drawio.png)

## System Design
![System Design](https://github.com/chickendje02/coffee-shop-system/blob/main/design_backend.drawio.png)
## Security Solution
* Internal app: Token Authentication (JWT)
* 3rd Party: Generate an API-Key for each third party

