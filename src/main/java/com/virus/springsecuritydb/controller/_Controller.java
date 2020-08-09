package com.virus.springsecuritydb.controller;

import com.virus.springsecuritydb.entity.Person;
import com.virus.springsecuritydb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class _Controller {

    @Autowired
    private PersonRepository personRepository;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping
    public Person fill(@RequestBody Person person){
        return personRepository.save(person);
    }
}
