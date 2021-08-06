package com.fan.springbootStudy.controller;

import com.fan.springbootStudy.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "Hello, " + environment.getProperty("name");
    }

    @RequestMapping("/hello3")
    public void hello3() {
        System.out.println(person);
    }
}
