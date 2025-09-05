### **1. Core Spring Boot Annotations**

| Annotation               | Description                                                                                                                  |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------- |
| `@SpringBootApplication` | Main entry point for a Spring Boot application. Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. |
| `@Configuration`         | Marks a class as a source of bean definitions.                                                                               |
| `@ComponentScan`         | Automatically detects and registers beans from specified packages.                                                           |
| `@Bean`                  | Declares a Spring-managed bean.                                                                                              |
| `@Value("${property}")`  | Injects a value from application properties.                                                                                 |

---

### **2. Dependency Injection & Component Scanning**

| Annotation        | Description                                                                              |
| ----------------- | ---------------------------------------------------------------------------------------- |
| `@Component`      | Generic annotation for defining a Spring-managed bean.                                   |
| `@Service`        | Specialized `@Component` for service layer beans.                                        |
| `@Repository`     | Specialized `@Component` for repository layer beans, adds exception translation for JPA. |
| `@Controller`     | Specialized `@Component` for handling HTTP requests in MVC.                              |
| `@RestController` | Combination of `@Controller` and `@ResponseBody` for RESTful web services.               |
| `@Autowired`      | Injects dependencies automatically.                                                      |
| `@Qualifier`      | Specifies which bean to inject when multiple candidates exist.                           |


### **3. Spring MVC (Web)**

|Annotation|Description|
|---|---|
|`@RequestMapping`|Maps HTTP requests to handler methods.|
|`@GetMapping`|Handles HTTP GET requests.|
|`@PostMapping`|Handles HTTP POST requests.|
|`@PutMapping`|Handles HTTP PUT requests.|
|`@DeleteMapping`|Handles HTTP DELETE requests.|
|`@PatchMapping`|Handles HTTP PATCH requests.|
|`@ResponseBody`|Binds a method return value to the HTTP response body.|
|`@RequestBody`|Maps the HTTP request body to a Java object.|
|`@RequestParam`|Extracts request parameters from the URL.|
|`@PathVariable`|Extracts values from the URL path.|
|`@ModelAttribute`|Binds request parameters to a model object.|
|`@ExceptionHandler`|Handles exceptions at the controller level.|
|`@CrossOrigin`|Enables CORS (Cross-Origin Resource Sharing).|

---

### **4. Spring Data JPA & Transactions**

|Annotation|Description|
|---|---|
|`@Entity`|Marks a class as a JPA entity.|
|`@Table(name = "table_name")`|Specifies the database table for an entity.|
|`@Id`|Marks a field as the primary key.|
|`@GeneratedValue(strategy = GenerationType.IDENTITY)`|Specifies how the primary key should be generated.|
|`@Column(name = "column_name")`|Maps a field to a specific database column.|
|`@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`|Defines JPA relationships.|
|`@Transactional`|Marks a method or class as transactional.|
|`@EnableJpaRepositories`|Enables JPA repositories.|
|`@Query("SELECT u FROM User u WHERE u.email = :email")`|Defines a custom JPA query.|

---

### **5. Security & Authentication (Spring Security)**

|Annotation|Description|
|---|---|
|`@EnableWebSecurity`|Enables Spring Security configuration.|
|`@EnableGlobalMethodSecurity(prePostEnabled = true)`|Enables method-level security.|
|`@PreAuthorize("hasRole('ROLE_ADMIN')")`|Restricts method access based on roles.|
|`@PostAuthorize`|Evaluates security conditions after method execution.|
|`@Secured("ROLE_USER")`|Another way to restrict access based on roles.|
|`@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})`|Defines allowed roles for method access.|
|`@AuthenticationPrincipal`|Injects the authenticated user object into a method parameter.|

