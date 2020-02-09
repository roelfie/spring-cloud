# LinkedIn: Spring Cloud

Playground for the Spring Cloud course on LinkedIn Learning

# 2 - External configuration
 
## 2.1 - Spring Cloud Config Server

Spring Cloud Config Server can be used to externalize configuration from your application. It is

* A simple Spring Boot starter project
* Backed by a Git server (=> support for branches)
* Centralized management of (environment) variables
* Loads config on startup
* Serves config via REST
* Support for Spring profiles

## 2.2 - Creating a Config Server

1. Create a new Spring Boot project
2. Include dependency on `spring-cloud-config-server`
3. Specify the following properties / environment variables:
   - `spring.cloud.config.server.git.uri` (the backing Git repository)
   - `server.port`

### Usage

Properties for microservice `<app1>` are typically stored in `<app1>.properties` in the root of the repository.

The Config Server serves these properties under URL `https://<host>:<port>/my-application/default`.

For instance: http://localhost:9000/guestservices/default

## 2.4 - Consuming 
Consuming Config:
* Spring Cloud Config client starter project
* Point to the Config Server in a Bootstrap file
* Downloads Config at application startup
* Leverages Spring Lifecycle (Config loaded before bean post-processing) 