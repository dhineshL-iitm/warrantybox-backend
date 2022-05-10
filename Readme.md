# Warranty-Box

manages warranty and tickets for product defects

## Description

* warranty-box maintains and manages warranties of a products for a user
* users can raise ticket for defects in the products
* brand can register themselves and provide warranty registeration service to their users using our platform
* brand can resolve the raise tickets using our platform

## Getting Started

### Dependencies

* Java 11
* maven 
* all further dependences are included in pom.xml

### Installing

1. git clone https://github.com/dhineshL-iitm/warrantybox-backend.git
2. git checkout main 
3. go to application.properties in src/main/java/resource folder
4. configure your database connection and smtp connection
5. mvn install
6. mvn spring-boot:run 
7. go to http://localhost:8080/
8. If the service is running you should see a login page


### Architecture
![Blank diagram](https://user-images.githubusercontent.com/105036966/167636239-1f6795de-f582-4068-ba7c-0d8dce9ababb.png)


## Features
1. User can register and sign in
2. User can register their product of different brands in to our application
3. User can raise ticket for their defects in the product
4. Brands can register their product and sign in
5. Brands manage their tickets in our application
6. Brands can add products to provide product registration service easier for the customer
7. Brands can resolve and update the ticket
8. Every feature mentioned above notifies the user/brand by mail.


### User Home Page
![homepageuser](https://user-images.githubusercontent.com/105036966/167638252-1a668c47-8c91-4c4a-9f97-2ba272d86419.PNG)


### User Dashboard 
![dashboardpageuser](https://user-images.githubusercontent.com/105036966/167638714-8a3605db-a749-4457-8494-5fbbd9f87aae.PNG)


### Brand product registration page
![registerpage](https://user-images.githubusercontent.com/105036966/167638785-6dcec6ac-2535-4089-ba1f-d68d1fe31b10.PNG)


### Brand product dashboard page 
![brandproductspage](https://user-images.githubusercontent.com/105036966/167638831-f36f00c5-474f-47d9-a7a3-23f91acf4b56.PNG)

### Brand ticket platform page
![ticketplatformpage](https://user-images.githubusercontent.com/105036966/167639394-b2fe8ea1-7146-4263-a3c9-e2c7039ae3de.PNG)


## Authors

Contributors names and contact info

Dhinesh L 
[LinkedIn](https://www.linkedin.com/in/dhineshbharathi/)


