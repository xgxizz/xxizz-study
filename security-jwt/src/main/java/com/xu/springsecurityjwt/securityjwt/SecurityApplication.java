package com.xu.springsecurityjwt.securityjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {

    /*@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
