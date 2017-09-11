package com.neeson.Controller;

import com.neeson.domain.Person;
import com.neeson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daile on 2017/9/5.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        personRepository.savePerson(person);
        return person;
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable String id){
        Person person = personRepository.findPerson(id);
        return person;
    }

}
