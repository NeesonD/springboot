package com.neeson.service.impl;

import com.neeson.domain.City;
import com.neeson.repository.CityMapper;
import com.neeson.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by daile on 2017/8/14.
 */
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getCityById(Integer id) {
       return cityMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
