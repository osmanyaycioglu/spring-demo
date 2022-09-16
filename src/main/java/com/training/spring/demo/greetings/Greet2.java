package com.training.spring.demo.greetings;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class Greet2 {

    public Greet2() {
        System.out.println("Greet2 yaratıldı");
    }

    public String greet(String name) {
        return "Hello " + name;
    }

}
