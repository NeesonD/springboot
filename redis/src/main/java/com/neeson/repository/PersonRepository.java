package com.neeson.repository;

import com.neeson.domain.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by daile on 2017/9/5.
 */
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);

    boolean savePerson(Person person);

}
