package com.training.spring.demo.greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("myGreet")
public class Greet {

    @Autowired
    private GreetFormatter greetFormatter;

    private ApplicationContext context;
    private String str;
    private Environment environment;

    @Autowired
    public Greet(ApplicationContext context,
                 @Value("${test.prop}") String str) {
        this.context = context;
        context.containsBean("osman");
    }

    @PostConstruct
    public void initXyz() {
        context.containsBean("osman");
    }

    public Greet() {
        System.out.println("Greet yaratıldı");
    }

    public String greet(String name) {
        String property = context.getEnvironment()
                                 .getProperty("my.xyz");
        return greetFormatter.format("Hello " + name + " " + property);
    }

    public Environment getEnvironment() {
        return environment;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
