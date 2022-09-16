package com.training.spring.demo.greetings;

import org.springframework.stereotype.Component;

@Component
public class GreetFormatter {

    public String format(String s){
        return "Dear " + s;
    }

}
