# A SpringBoot REST API backend for a vacation package booking and checkout system.

## Overview:

The Vacation Booking API is a backend REST service supporting an online vacation booking platform. A user can create a 
customer record. Once a customer is created, the user can browse and select a vacation destination, 
then optionally select an excursion to add to the order, which is exclusive to the vacation destination.<br>
Excursions are optional, but a vacation selection is required to check out. Completing the checkout processes the order 
as a single transaction and generates tracking information. 
The backend is build with Spring Boot and communicates with a pre-build Angular front-end and a MySQL relational database.


## Tech-Stack:  
- Java
- SpringBoot
- MySQL
- Git
- Hibernate/JPA

## Architecture:

The backend is organized in four main packages. <br>
Path: src/main/java/com/example/backendproject 

### entities package: Contains data models that match the UMl diagram provided.
> Each entity maps to its corresponding database table and its front-end counterpart.
Relationships between these entities properly reflect their relationships in the database.

### DAO package: 
> This includes 7 repository interfaces that extend the Jpa Repository 
that handle data access to each entity. Includes cross-origin support to ensure a successful connection to the front-end.

### services package: contains the business logic for checkout. 

 > Includes the cart handling (**Purchase**) and order confirmation (**PurchaseResponse**), 
 implemented via a **CheckoutService** interface and its implementation.

### Controllers Package:

> REST endpoints exposed to the frontend, including a checkout controller that uses @POST to process incoming orders.

The API is used by an Angular frontend with CORS configuration that supports cross-origin requests. 

## Key Features:

- checkout logic supporting multi-item orders as a single transaction.
- input validation tied to database constraints
- CORS support for the Angular frontend
- includes sample data, while ensuring the customer information is not overwritten each time the application is deployed.
- returns tracking number after a successful transaction

## Testing/Verification:

- Verified checkout end-to-end and confirmed the request completed without generating a network error, 
verified via the browser's inspection console.
- Verified the order data was successfully written by inspecting the corresponding tables in MySQL Workbench.
- implemented and tested input validation for required fields.