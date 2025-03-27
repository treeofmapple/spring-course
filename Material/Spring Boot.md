## 1. Introduction to <strong>Spring Boot</strong>
---

 #### <p style="text-align:center;">What is Spring Boot? </p>
<div>
Spring framework is a small lightweight application development framework, upon many spring projects are based.

Spring boot is application accelerator and it seamless combines multiples spring projects together into a single pre configured code base for developes build upon.

Developed by an Australian named Rod Johnson in 2004.
<div>&ensp; Simplifiying the lifecycle of java components that have complex lifecycles, and help to externalize the configuration of the components that have complex configurations.</div>

For example database connectors, kafka message queue, transaction management.
</div>
<br>

#### <p style="text-align:center;">Advantages over traditional Spring Framework? </p>

1. **Auto-Configuration** 
    - No need for extensive XML or manual bean configuration.
    - Automatically configures beans based on dependencies.
2. **Embedded Servers** 
    - Comes with **Tomcat, Jetty, and Undertow** embedded.
    - No need to deploy WAR files manually.
3. **Reduced Boilerplate Code** 
    - Removes excessive XML configurations.
    - Uses annotations like `@SpringBootApplication` for quick setup.
4. **Production-Ready Features** 
    - Built-in health checks, metrics, logging, and monitoring.
    - `spring-boot-actuator` for real-time application insights.
5. **Faster Development & Deployment** 
    - Supports **microservices** & REST API development out-of-the-box.
    - Convention-over-configuration speeds up project setup.
6. **Spring Boot Starter Dependencies** 
    - Pre-configured dependencies (`spring-boot-starter-web`, `spring-boot-starter-data-jpa`, etc.).
    - No need to manually add each library.
7. **Standalone Applications** 
    - Can be packaged as **JAR** instead of WAR.
    - Run directly with `java -jar yourapp.jar`.
8. **Spring CLI Support** 
    - Enables rapid prototyping with Groovy scripts.
9. **Externalized Configuration** 
    - Supports YAML, `.properties`, and environment variables for easy customization.
10. **Seamless Integration with Cloud & DevOps**
<br>

### ❌ When NOT to Use Spring Boot?

- If you need a **lightweight** application with minimal dependencies.
- If you prefer **manual configuration** and fine-tuned control over Spring components.
- If your project is **monolithic** and does not require embedded servers.

<br>

#### <p style="text-align:center;">Setting up a Spring Boot project</p>

###### *Starts hands on Developing*

<br>

### 2. Core Features on <strong>Spring Boot</strong>

- Spring Boot starters & dependencies
- Auto-configuration & Spring Boot annotations
- Application.properties vs. application.yml
- Profiles for different environments

<br>

### 3. Building a REST API with <strong>Spring Boot</strong>

- Creating REST controllers
- Request mapping (GET, POST, PUT, DELETE)
- Handling JSON with Jackson
- Exception handling

<br>

### 4. Data Persistence with <strong>Spring Boot</strong>

- Spring Data JPA
- Connecting to databases (H2, MySQL, PostgreSQL)
- CRUD operations with Spring Repository
- Querying with JPQL and Native Queries
- Using Flyway/Liquibase for database migrations
- Caching with Spring Cache

---