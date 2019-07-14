package com.neeson.code.controller;

import com.neeson.code.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : neeson
 * Date: 2019/7/14
 * Time: 22:48
 * Description:
 */
@RestController
public class PersonController implements EnvironmentAware {

    @Autowired
    private Person person;

    @Value("${person.id}")
    private Long id;

    @Value("${person.name:小马哥}")
    private String name;

    private Integer age;


    @GetMapping("/person/xiaomage")
    public Person xiaomage() {
        return person;
    }

    @GetMapping("/person/xiaomage/data")
    public Map<String, Object> xiaomageData() {

        Map<String, Object> data = new LinkedHashMap<>();

        data.put("id", id);
        data.put("name", name);
        data.put("age", age);

        return data;
    }

    @Override
    public void setEnvironment(Environment environment) {

        this.age = environment.getProperty("person.age", Integer.class);

    }

}
