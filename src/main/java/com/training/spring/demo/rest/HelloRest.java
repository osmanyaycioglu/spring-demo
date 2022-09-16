package com.training.spring.demo.rest;

import com.training.spring.demo.greetings.Greet;
import com.training.spring.demo.greetings.Greet2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/hello")
// @RequestScope
public class HelloRest {

    @Autowired
    private Greet greet;

    @Autowired
    @Qualifier("grt3")
    private Greet2 gt2;

    @GetMapping("/hello")
    public String hello(){
        return greet.greet("osman");
    }
}
