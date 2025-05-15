# FHNW Thrifting 

#### Contents:
- [Analysis](#analysis)
  - [Scenario](#scenario)
  - [User Stories](#user-stories)
  - [Use Case](#use-case)
- [Design](#design)
  - [Prototype Design](#prototype-design)
  - [Domain Design](#domain-design)
  - [Business Logic](#business-logic)
- [Implementation](#implementation)
  - [Backend Technology](#backend-technology)
  - [Frontend Technology](#frontend-technology)
- [Project Management](#project-management)
  - [Roles](#roles)
  - [Milestones](#milestones)

## Analysis

In today's academic curriculum, students are often faced with the dilemma of what to do with their accumulated school materials, such as textbooks, notebooks, related equipment, digital resources, and many more. These resources become obsolete and frequently go unused, which leads to unnecessary waste and a financial strain for new students looking into purchasing them at full price. Additionally, while aiming for a degree at a university, students often look for ways to earn and save money while being busy with homework, projects, exams and other extracurricular activities. Therefore, they are often seeking uncomplicated and fast ways to buy and sell items that are needed for their studies. Due to this fact, the FHNW Thrift project shall provide them with the necessary platform that will offer them this opportunity. 

Furthermore, lecturers, professors and even the dean of different courses will have the chance to utilize this platform similarly to how the students are allowed to. By sharing helpful resources, materials, other everyday needs or even other helpful items for the application's users, the FHNW Thrift also aims to encourage recycling, upcycling and in general, a more sustainable environment. Therefore, the aim of this project is to make the application available to an extensive audience as possible. 

### Scenario 

FHNW Thrift is an online marketplace primarily for students at the Fachhochschule Nordwestschweiz (FHNW) to resell study material and other items. Yet, in order to reach a broader audience, the platform will be made available for teachers and other individuals within the FHNW organization. Through the platform, the users are allowed to create offers and sell their items. Additionally, through the contact form, the application's users will be able to contact the sellers to express their interest in the offers that are made available through the platform. Users are also allowed to report malicious offerings to avoid fraud, which the administrators of the program will also be able to delete and alert the users about their suspicious profiles or activities. In this way, the platform remains with only legitimate offers and profiles of individuals within the FHNW organization. Furthermore, the users shall be able to filter the offers according to their location, the condition of the item that is being sold, and the category to which the items belong. Therefore, the overall aim of this application is to provide the users with an overall interactive, yet user-friendly experience. 

Within the application, the users are limited to creating offers with the aim of selling their items and contacting other sellers directly through the platform. In the meantime, only the administrators of the FHNW Thrift are provided with extensive access to the application. Through the defined "admin rights", admins can view the entire database that contains the orders, modify rows (or also seen as offers) and delete rows. Additionally, admins will be able to view the entire database in which the user data is stored and commit necessary changes. Furthermore, due to the "reporting function" that is made available to the users, the admins have the right to review these reports and decide on necessary actions accordingly. Therefore, for the initial launch of the FHNW Thrift application, there is a defined separation of what the admins and users are allowed to do within the program. 


### User Stories
1. As a user, I want to create offers for my fellow students, teachers and other individuals within the FHNW organization.
2. As a user, I want to view all the offers and the details to an offer and to filter offers by location, category or condition.
3. As a user, I want to report suspicious offers to avoid getting scammed.
4. As a user, I want to contact a seller when I am interested in a product.
5. As a user, I should be able to contact the admin to edit or delete an existing offer.
6. As an admin, I should be able to see all the existing offers in the database and I should be able to modify or delete existing offers.
7. As an admin, I should be able to see the entire user list and I should be able to modify user details or remove users from the user list. 

### Use Case

![](https://github.com/francESCOBAR99/InternetTechnology_project/blob/main/images/User%20Cases%20FHNW%20Thrift.jpg)

- UC-1 [Create an offer] User creates an object
- UC-2 [View offer details] User can view all the details to an offer 
- UC-3 [Applying a filter to the existing offers] User can sort the offers by school location, category and condition
- UC-4 [Report an existing offer] User can report an object as suspicious
- UC-5 [Contacting another user] User can contact another user through the FHNW Thrift application
- UC-6 [Contacting the admin] User can contact Admin to edit or delete own offers
- UC-7 [Viewing all the offers] Admin and User can view all the offers 
- UC-8 [Modify or delete an existing offer] Admin changes or deletes an existing object
- UC-9 [Viewing all the users] Admin can view all the users registered on FHNW Thrift
- UC-10 [Modify user details or remove user from user list] Admin changes user details or deletes user from the user list


## Design

The design has been sketched through drawio and has been created in Budibase. The design was done and discussed by the whole project team and is based on a simple application design to ensure a user-friendly program. Additionally the colors have been selected according to FHNW's color scheme to maintain the university's identity. 

### Wireframe

The wireframe was created through drawio in order to visualize how the prototype was planned to look like. 
Disclaimer: During the course of the creation of the program, the wireframe and the prototype design will differ from each other. The prototype will be highly based according to Budibase's functionalities. 
LInk: [https://drive.google.com/file/d/1aJUydp2JTiglDqXS5bhqTPHjDJ3wwXQq/view?usp=sharing ](https://app.diagrams.net/#G1EdAtBRFfmMlq_bZgUat0rvuNs8qZ22Bt#%7B%22pageId%22%3A%226ppb-k3glDpuP1GKOrRW%22%7D)

### Prototype

The prototype is currently being created through Budibase. 
Link: <iframe width="800" height="600" frameborder="0" allow="clipboard-write;camera;geolocation;fullscreen" src="https://internettechnologyprojectbitpt3b2025.budibase.app/embed/fhnw-thrift"></iframe>

### Domain Design (still to be done) 
> 🚧: Provide a picture and describe your domain model; you may use Entity-Relationship Model or UML class diagram. Both can be created in Visual Paradigm - we have an academic license for it.

(The `ch.fhnw.pizza.data.domain` package contains the following domain objects / entities including getters and setters:

![](images/domain-model.png)

<img width="449" alt="image" src="https://github.com/user-attachments/assets/73d5d084-9004-4542-bf6d-fa61a7fe53e6" />)


### Business Logic 

Based on the UC-4 and UC-5, there will be the opportunity that the user can report a post and the Admin to delete it and also take measures to act on this report. 

- If the offer on the platform looks suspicious, the user is allowed to report it through a "Report!" button to the Admin. 
- If the offer on the platform looks suspicious, the Admin is allowed to delete the post and either warn or ban the user from creating new posts. 

**Path**: (path for the business logic to be still attached)

**Param**: (parameter for the business logic to be still attached)

**Method:** `GET`

## Implementation (still to be done) 
> 🚧: Briefly describe your technology stack, which apps were used and for what.

### Backend Technology (still to be done) 
> 🚧: It is suggested to clone this repository, but you are free to start from fresh with a Spring Initializr. If so, describe if there are any changes to the PizzaRP e.g., different dependencies, versions & etc... Please, also describe how your database is set up. If you want a persistent or in-memory H2 database check [link](https://github.com/FHNW-INT/Pizzeria_Reference_Project/blob/main/pizza/src/main/resources/application.properties). If you have placeholder data to initialize at the app, you may use a variation of the method **initPlaceholderData()** available at [link](https://github.com/FHNW-INT/Pizzeria_Reference_Project/blob/main/pizza/src/main/java/ch/fhnw/pizza/PizzaApplication.java).

This Web application is relying on [Spring Boot](https://projects.spring.io/spring-boot) and the following dependencies:

- [Spring Boot](https://projects.spring.io/spring-boot)
- [Spring Data](https://projects.spring.io/spring-data)
- [Java Persistence API (JPA)](http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html)
- [H2 Database Engine](https://www.h2database.com)

To bootstrap the application, the [Spring Initializr](https://start.spring.io/) has been used.

Then, the following further dependencies have been added to the project `pom.xml`:

- DB:
```XML
<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
</dependency>
```

- SWAGGER:
```XML
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.3.0</version>
   </dependency>
```

### Frontend Technology (still to be done) 
> 🚧: Describe your views and what APIs is used on which view. If you don't have access to the Internet Technology class Budibase environment(https://inttech.budibase.app/), please write to Devid on MS teams.

This Web application was developed using Budibase and it is available for preview at https://inttech.budibase.app/app/pizzeria. 

## Execution (still to be done) 
> 🚧: Please describe how to execute your app and what configurations must be changed to run it. 

**The codespace URL of this Repo is subject to change.** Therefore, the Budibase PizzaRP webapp is not going to show any data in the view, when the URL is not updated or the codespace is offline. Follow these steps to start the webservice and reconnect the webapp to the new webservice url. 

1. Clone PizzaRP in a new repository.
2. Start your codespace (see video guide at: [link](https://www.youtube.com/watch?v=_W9B7qc9lVc&ab_channel=GitHub))
3. Run the PizzaRP main available at PizzaApplication.java on your own codespace.
4. Set your app with a public port, see the guide at [link](https://docs.github.com/en/codespaces/developing-in-a-codespace/forwarding-ports-in-your-codespace).
5. Create an own Budibase app, you can export/import the existing Pizzeria app. Guide available at [link](https://docs.budibase.com/docs/export-and-import-apps).
6. Update the pizzeria URL in the datasource and publish your app.

Project Team's procedure:
1. PizzaRP is cloned in a new repository.
2. Codespace started and copilot used to gather inspiration for the new code for "thrift" as shown in this repository.
3. 

### Deployment to a PaaS
> 🚧: Deployment to PaaS is optional but recommended as it will make your application (backend) accessible without server restart and through a unique, constantly available link.  

Alternatively, you can deploy your application to a free PaaS like [Render](https://dashboard.render.com/register).
1. Refer to the Dockerfile inside the application root (FHNW-INT/Pizzeria_Reference_Project/pizza).
2. Adapt line 13 to the name of your jar file. The jar name should be derived from the details in the pom.xml as follows:<br>
`{artifactId}-{version}.jar` 
2. Login to Render using your GitHub credentials.
3. Create a new Web Service and choose Build and deploy from a Git repository.
4. Enter the link to your (public) GitHub repository and click Continue.
5. Enter the Root Directory (name of the folder where pom.xml resides).
6. Choose the Instance Type as Free/Hobby. All other details are default.
7. Click on Create Web Service. Your app will undergo automatic build and deployment. Monitor the logs to view the progress or error messages. The entire process of Build+Deploy might take several minutes.
8. After successful deployment, you can access your backend using the generated unique URL (visible on top left under the name of your web service).
9. This unique URL will remain unchanged as long as your web service is deployed on Render. You can now integrate it in Budibase to make API calls to your custom endpoints.

## Project Management

### Roles
- Back-end developer (creation of code, maintenance and testing): Francesco Leone, Michelle Liva, Sidal Oezbey
- Front-end developer (creation of code, maintenance and testing): Francesco Leone, Michelle Liva, Sidal Oezbey
- Scenario Analysis (Analysis of the business case, segregation of tasks and compiling ideas): Francesco Leone, Michelle Liva, Sidal Oezbey
- Prototype Design (Designing the prototype on paper and implementation on Budibase): Francesco Leone, Michelle Liva, Sidal Oezbey
- README file maintenance (Maintaining the GitHub README file throughout the project): Francesco Leone, Michelle Liva, Sidal Oezbey 
- Budibase maintenance (Maintaining the Budibase prototype throughout the project): Francesco Leone, Michelle Liva, Sidal Oezbey 

### Milestones
1. **Analysis**: Scenario ideation, use case analysis and user story writing.
2. **Prototype Design**: Creation of wireframe and prototype.
3. **Domain Design**: Definition of domain model.
4. **Business Logic and API Design**: Definition of business logic and API.
5. **Data and API Implementation**: Implementation of data access and business logic layers, and API.
6. **Security and Frontend Implementation**: Integration of security framework and frontend realisation.
7. (optional) **Deployment**: Deployment of Web application on cloud infrastructure.

## Current Standing in the Milestone
(to create BPM) 

#### Maintainer
- Francesco Leone
- Michelle Liva
- Sidal Oezbey 

#### License
- [Apache License, Version 2.0](blob/master/LICENSE)
