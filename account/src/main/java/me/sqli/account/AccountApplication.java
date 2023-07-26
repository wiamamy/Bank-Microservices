package me.sqli.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableFeignClients(
    basePackages = "me.sqli.clients"
)
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
        //System.out.println("Hello world!");
    }
}
