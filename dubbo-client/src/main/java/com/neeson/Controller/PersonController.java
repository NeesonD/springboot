package com.neeson.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.neeson.domain.Person;
import com.neeson.dubbo.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daile on 2017/9/5.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Reference(version = "1.0.0")
    PersonService personService;

    @GetMapping("/get/{id}")
    public Person findById(@PathVariable int id){
        Person person = personService.findById(id);
        return person;
    }

}
