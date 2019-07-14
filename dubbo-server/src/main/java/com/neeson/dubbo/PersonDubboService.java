package com.neeson.dubbo;

import com.neeson.domain.Person;

/**
 * Created by daile on 2017/9/6.
 */
public interface PersonDubboService {

    Person findById(int id);

}
