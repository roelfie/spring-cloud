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
2. With the config-server starter project
3. Specify your Git repo

Typical use:
* different profile for each data center
* different instance of Config Server for each branch

## 2.4 - Consuming 
Consuming Config:
* Spring Cloud Config client starter project
* Point to the Config Server in a Bootstrap file
* Downloads Config at application startup
* Leverages Spring Lifecycle (Config loaded before bean post-processing) 