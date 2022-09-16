package com.training.spring.demo.greetings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Controller
//@Repository
//@Service
@Configuration
public class GreetConfig {

    @Bean("grt2")
    public Greet2 greet2Bean() {
        return new Greet2();
    }

    @Bean("grt3")
    public Greet2 greet3Bean() {
        return new Greet2();
    }

}
