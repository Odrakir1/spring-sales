package com.odrakir1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@SpringBootApplication
@RestController
public class SalesApplication {

    @Value("${application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

    @GetMapping("/application")
    public String application(){
        return applicationName + " running on port: " + port;
    }
}
