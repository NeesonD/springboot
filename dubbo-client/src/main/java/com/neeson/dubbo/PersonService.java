package com.neeson.dubbo;

import com.neeson.domain.Person;

/**
 * Created by daile on 2017/9/5.
 */
public interface PersonService {

    Person findById(int id);

}
