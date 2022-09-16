package com.training.spring.demo.rest;

import com.training.spring.demo.db.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonManagementController {

    @Autowired
    private IPersonDao personDao;

    @PostMapping("/add")
    public String addPerson(@Validated @RequestBody Person person){
        if (person.getName() == null){
            throw new IllegalArgumentException("Name null olamaz");
        }
        personDao.save(person);
        return "" + person;
    }

    @GetMapping("/remove/{pid}")
    public String removePerson(@PathVariable("pid") Long personId){
        personDao.deleteById(personId);
        return "Person deleted.";
    }

    @GetMapping("/get/one/{pid}")
    public Person getPerson(@PathVariable("pid") Long personId){
        return personDao.findById(personId).orElse(null);
    }

    @PostMapping("/update")
    public String updatePerson(@Validated @RequestBody Person person){
        if (person.getPersonId() == null){
            throw new IllegalArgumentException("personId should be aval");
        }
        personDao.save(person);
        return "" + person;
    }

    @GetMapping("/get/by/name")
    public List<Person> getPersonByName(@RequestParam("name") String name){
        return personDao.findByName(name);
    }



    @GetMapping("/greet/{xyz}/{abc}")
    public String greet(@PathVariable("xyz") String name,
                        @PathVariable("abc") String surname) {
        return "Greetings " + name + " " + surname;
    }

    @GetMapping("/greet")
    public String greet2(@RequestParam("isim") String name,
                         @RequestParam("soy") String surname) {
        return "Greetings 2 " + name + " " + surname;
    }

    @GetMapping("/greet/{fgh}")
    public String greet3(@PathVariable("fgh") String name,
                         @RequestParam("soy") String surname) {
        return "Greetings 3 " + name + " " + surname;
    }

    @GetMapping("/hello")
    public String hello1() {
        return "Hello 1";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Hello 2 POST";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "Hello 3 PUT";
    }

}
