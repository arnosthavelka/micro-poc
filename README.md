# micro-poc
Prototype of microservice approach/architecture based on Spring Boot & Spring Cloud.

Links:
* http://projects.spring.io/spring-cloud/spring-cloud.html
* http://stackoverflow.com/questions/27131143/spring-cloud-configuration-server-not-working-with-local-properties-file/27159030#27159030
* https://github.com/spencergibb/communityanswers/tree/so27131143

## Principles
*   configuration server is not from GIT (but from embedded files)
*   whole POC uses Eureka first approach (everything is read with discovery client)
*   location applications (district & canton) use JPA persistency where DB is handled by Liquibase (H2 database)

## Deployment diagram

![Alt text](/_resources/deployment-diagram.png?raw=true "Deployment diagram")
