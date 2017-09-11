package com.neeson.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.neeson.domain.Person;
import com.neeson.dubbo.PersonDubboService;

/**
 * Created by daile on 2017/9/6.
 */
@Service(version = "1.0.0")
public class PersonDubboServiceImpl implements PersonDubboService {
    @Override
    public Person findById(int id) {
        return new Person(1,"neeson",22);
    }
}
