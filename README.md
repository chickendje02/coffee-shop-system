## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Workflow](#workflow)
* [Database Design](#database-design)
* [System Design](#system-design)
* [Security Solution](#security-solution)
* [API Endpoint](#api-endpoint)
* [Testing Solution](#testing-solution)
* [Part2](#part2)
* [Setup](#setup)
* [Handling Error](#handling-error)
* [Deploying AWS](#deploying-aws)
* [New function that may be useful](#new-function-that-may-be-useful)
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
* Internal Application: Token Authentication (JWT)
* 3rd Party: Generate an API-Key for each third party
## API Endpoint
For now, I will focus on these endpoint only. For more information, you can start process-order-service and view http://localhost:8083/swagger-ui/index.html
|Endpoint|Method|Description|
|---|---|---|
|/v1/queue|PUT|Handle edit the queue such as cancel, update status of order|
|/v1/order|POST|Create new Order by customer|

## Testing Solution
I haven't finished the Testing yet. But I plan to use these
* Unit Test - To make sure function work right
* Integration Test - To test for 3rd Party calling API
* Load Test - Using JMeter for Load Testing
-------------------------------------------------------------------
## Part2
## Setup
* Run sql.script file in /coffee-shop-system-management or you can find the specific [here](https://github.com/chickendje02/coffee-shop-system/blob/main/coffee-shop-system-management/sql.script) to create database and schema in PostgreSQL
* Run command "mvn clean install" at folder/coffee-shop-system-management
* You can view [here](https://github.com/chickendje02/coffee-shop-system/blob/main/coffee-shop-system-management/sample_request_payload.txt) for example API calling

## Handling Error
* For API Failed: Each Request will have requestId and it will be logged during the process and once it's failed, we will return that requestId to the client so client can notify our customer support and provide it which make easier for us to trace the log ( I haven't finished yet)
* For Kafka: Retry ( I haven't finished it yet)

## Deploying AWS
I haven't finished this yet but my plan is using Github Action to create CI/CD to deploy automatically to AWS


## New function that may be useful
* For Business: 
   + Customer can apply voucher at specific coffee shop <br/>
   + Customer can save favorite shop/drinks so next time they buy, it will be easier for them to view <br/>
   + There's a shopping cart so they can add any drink item at specific coffee shop they like and it will be expired for configuration time  <br/>
* For System:
   + Apply Cache such as Redis
   + Apply API Gateway
   + Apply Promethus, Grafana to monitor system
 
