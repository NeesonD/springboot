package com.neeson.service;

import com.neeson.domain.City;

/**
 * Created by daile on 2017/8/14.
 */
public interface CityService {

    City getCityById(Integer id);

    void saveCity(City city);

}
