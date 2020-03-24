package com.xu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableCaching
public class SwaggerApplication extends SpringBootServletInitializer {

    /**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
        log.info("============= SpringBoot Start Success =============");
    }
}