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

## 2.4 - Creating a Config Server client 

1. In your existing Spring Boot application, include a dependency on `spring-cloud-config-client`
2. Add a `src/main/resources/bootstrap.properties` with properties:
   - `spring.application.name=<appname>` (should match the file name in the git repo)
   - `spring.cloud.config.uri=http://localhost:9000` (the Config Server uri)

Your application will now download the configuration at application startup. 
It leverages the Spring Lifecycle (the config will be loaded before bean post-processing).

# 3 - Service Discovery

## Eureka

Eureka is the service discovery platform created by Netflix. 

Spring Boot offers an out of the box Server and Client for Eureka (very similar to Config Server/Client). 

Spring Cloud's Eureka Client even leverages the same property `spring.application.name` (Config Client uses 
the property to tell Config Server: give me my configuration; Eureka Client uses the property 
to register itself with the Eureka Server).

#### Eureka Server
To create a Eureka Server:
* Create a Spring Boot application with `spring-cloud-starter-netflix-eureka-server`
* Annotate the @SpringBootApplication with `@EnableEurekaServer`
* Optional configuration:
```properties
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

#### Eureka Client
To add a Eureka Client to your Spring Boot project:
* Add the `spring-cloud-starter-netflix-eureka-client` dependency
* Annotate the @SpringBootApplication with `@EnableEurekaClient`
* By default it will look for a Eureka Server on localhost:8761 (if it's somewhere else, you'll have to specify that in
a property)

#### Using Service Discovery
To actually use the Eureka Client, ...