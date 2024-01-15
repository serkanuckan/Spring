package com.example.demoweb;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GreetingService {

    public static void main(String[] args) {
        SpringApplication.run(GreetingService.class, args);
    }
}

@RestController
class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        logger.debug("Received a greeting request for {}", name);

        Greeting greeting = new Greeting();
        greeting.setId(1);
        greeting.setContent("Hello, " + name + "!");
        
        logger.info("Generated greeting: {}", greeting.getContent());

        return greeting;
    }
}

class Greeting {

    private int id;
    private String content;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

