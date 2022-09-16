package com.training.spring.demo;

import com.training.spring.demo.greetings.Greet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDemoApplication.class,
																   args);
		// Greet greet = new Greet();
		Greet bean = context.getBean(Greet.class);

	}

}
