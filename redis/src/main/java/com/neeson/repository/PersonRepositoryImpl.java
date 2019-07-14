package com.neeson.repository;

import com.neeson.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daile on 2017/9/5.
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String,Person> repository = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Person findPerson(String id) {
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(),person);

        return true;
    }
}
