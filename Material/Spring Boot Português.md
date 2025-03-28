## 1. Introdução ao <strong>Spring Boot</strong>

---
#### <p style="text-align:center;">O que é Spring Boot?</p>

<div> O <strong>Spring Framework</strong> é um framework leve para o desenvolvimento de aplicações, sobre o qual muitos projetos Spring são baseados.

O <strong>Spring Boot</strong> é um acelerador de aplicações que combina vários projetos Spring em uma única base de código pré-configurada para os desenvolvedores construírem aplicações mais facilmente.

Foi desenvolvido por um australiano chamado <strong>Rod Johnson</strong> em 2004.

<div>&ensp; Ele simplifica o ciclo de vida dos componentes Java que possuem processos complexos e ajuda a externalizar a configuração de componentes com configurações complicadas.</div>

Por exemplo: <strong>conectores de banco de dados, filas de mensagens Kafka, gerenciamento de transações</strong>.

</div> <br>

#### <p style="text-align:center;">Vantagens sobre o Spring Framework tradicional</p>

1. **AutoConfiguração (Auto-Configuration)**
    
    - Dispensa a necessidade de arquivos XML extensos ou configurações manuais de beans.
        
    - Configura automaticamente os beans com base nas dependências.
        
2. **Servidores Embutidos**
    
    - Vem com **Tomcat, Jetty e Undertow** integrados.
        
    - Não há necessidade de implantar arquivos WAR manualmente.
        
3. **Código Boilerplate Reduzido**
    
    - Elimina configurações XML desnecessárias.
        
    - Usa anotações como `@SpringBootApplication` para configuração rápida.
        
4. **Recursos Prontos para Produção**
    
    - Suporte nativo a **verificações de saúde, métricas, logging e monitoramento**.
        
    - O `spring-boot-actuator` fornece insights em tempo real sobre a aplicação.
        
5. **Desenvolvimento e Implantação Rápidos**
    
    - Suporte nativo para **microservices** e APIs REST.
        
    - O conceito de **convention-over-configuration** acelera a configuração de projetos.
        
6. **Starter Dependencies do Spring Boot**
    
    - Dependências pré-configuradas (`spring-boot-starter-web`, `spring-boot-starter-data-jpa`, etc.).
        
    - Evita a necessidade de adicionar bibliotecas manualmente.
        
7. **Aplicações Independentes**
    
    - Pode ser empacotado como um **JAR** ao invés de WAR.
        
    - Executável diretamente com `java -jar seuapp.jar`.
        
8. **Suporte ao Spring CLI**
    
    - Permite prototipagem rápida com scripts Groovy.
        
9. **Configuração Externalizada**
    
    - Suporte a **YAML, `.properties` e variáveis de ambiente** para personalização facilitada.
        
10. **Integração Perfeita com Cloud & DevOps**
    
    <br>

### ❌ Quando **NÃO** Usar Spring Boot?

- Se você precisa de uma aplicação **leve**, com o mínimo de dependências.
    
- Se você prefere **configuração manual** e controle detalhado dos componentes Spring.
    
- Se seu projeto é **monolítico** e não precisa de servidores embutidos.
    

<br>

#### <p style="text-align:center;">Configurando um projeto Spring Boot</p>

###### _Mãos na massa: desenvolvimento na prática_

<br>

### 2. Recursos Principais do <strong>Spring Boot</strong>

- Starters & dependências do Spring Boot
    
- AutoConfiguração e anotações do Spring Boot
    
- `application.properties` vs. `application.yml`
    
- Perfis para diferentes ambientes
    

<br>

### 3. Construindo uma API REST com <strong>Spring Boot</strong>

- Criando controladores REST
    
- Mapeamento de requisições (GET, POST, PUT, DELETE)
    
- Manipulação de JSON com Jackson
    
- Tratamento de exceções
    

<br>

### 4. Persistência de Dados com <strong>Spring Boot</strong>

- Spring Data JPA
    
- Conexão com bancos de dados (H2, MySQL, PostgreSQL)
    
- Operações CRUD com Spring Repository
    
- Consultas com JPQL e Queries Nativas
    
- Uso do Flyway/Liquibase para migrações de banco de dados
    
- Cache com Spring Cache