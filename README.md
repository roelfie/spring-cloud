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

Suppose we have a microservice called appname. A typical setup in the Config Server would be:
* properties are defined in `appname.properties` in the root of the repository
* the properties are served under URL `https://<host>:<port>/appname/default`

More generally, Config Server serves property sources from `/{application}/{profile}/{label}` where
* {profile} is the active Spring profile (default `${spring.profiles.active}`)
* {label} can be a Git label, branch name or commit id (usually a branch name)

So the properties for the guest service for the different environments can be found here:
* http://localhost:9000/guestservices/default
* http://localhost:9000/guestservices/default/master
* http://localhost:9000/guestservices/default/dev
 
See the [spring-cloud-config documentation](https://cloud.spring.io/spring-cloud-config/reference/html/#_locating_remote_configuration_resources)
for more information.

## 2.4 - Consuming 
Consuming Config:
* Spring Cloud Config client starter project
* Point to the Config Server in a Bootstrap file
* Downloads Config at application startup
* Leverages Spring Lifecycle (Config loaded before bean post-processing) 