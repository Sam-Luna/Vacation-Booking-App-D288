## Backend Programming Project

The following Document is a log of the work I have done for each task required for the project.
This documents the backend implementation of the Spring Boot REST API supporting vacation package checkout.

TASK C:
- I created four packages: controllers, entities,dao, and services.

Path: src/main/java/com/example/backendproject <--- All four packages are under <b>com.example.backendproject</b>
- I then imported each package in RestDataConfig.java.

Path: src/main/java/com/example/backendproject/config/RestDataConfig.java

TASK D:
I wrote the logic for the entities packages that match the UML diagram provided for this project. This was done with two
big goals in mind:
- Matching each entity to the correct database table, and ensuring tables and columns are both properly linked to the
  MySQL database. 
I also ensured that the relationships between the entities properly reflected their relationships in the database.

- Ensuring each entity is also properly linked to its front-end counterpart.

TASK E:

I wrote the logic for the dao package. This includes 7 repository interfaces that extend the Jpa Repository.
I also added cross-origin support to ensure a successful connection to the front-end.

TASK F:

I wrote the logic for the services package that includes:

- a Purchase data class with a customer cart and a set of cart items.

- a PurchaseResponse data class that contains an order tracking number.

- a CheckoutService interface.

- a CheckoutServiceImplementation class.


TASK G:

I wrote the logic to include validation to enforce the inputs needed by the angular front end.
The inputs that needed validation are based on the Database's NOTNULL constraint.

TASK H:

I wrote the logic for the Controllers package that included a REST controller. This checkout controller class uses
@RequestMapping and @PostMapping to place orders.

TASK I:

I programmatically added five sample customers in BootStrapData.java
This was done while ensuring the customers are only added as sample customers when/if the database is empty.
And while ensuring the customer information is not overwritten each time the application is deployed.

TASK J: For this task, I verified the app worked as intended with no issues or bugs.

- Ran the integrated application and submitted a customer order for a vacation package with two excursions
  using the unmodified Angular front-end.
- Confirmed the request completed without generating a network error, verified via the browser's inspection console.
- Verified the order data was successfully written by inspecting the corresponding tables in MySQL Workbench.