package top.kerstholt.spring.cloud.guestservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GuestServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuestServicesApplication.class, args);
    }

}
