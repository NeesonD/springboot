package com.neeson.controller;

import com.neeson.annotation.ControllerLog;
import com.neeson.domain.City;
import com.neeson.service.CityService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daile on 2017/8/14.
 */
@RestController
@RequestMapping(value = "/city")
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "获取城市信息", notes = "根据ID获取城市消息")
    @ApiImplicitParam(name = "id", value = "城市ID", paramType = "path", required = true, dataType = "")
    @GetMapping(value = "/{id}")
    @ControllerLog(description = "通过id获取城市信息")
    public City getCityById(@PathVariable("id") int id) {
        City city = cityService.getCityById(id);
        log.info("city:" + city);
        return city;
    }

    @ApiOperation(value = "保存城市信息")
    @ApiImplicitParam(name = "city", value = "城市信息", required = true, dataType = "City")
    @PostMapping(value = "/")
    @ControllerLog(description = "保存城市信息")
    public String saveCity(@RequestBody City city) {
        cityService.saveCity(city);
        return "success";
    }

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "number", value = "每页数量", required = true, dataType = "int"),
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "int")
    })
    @GetMapping(value = "/{number}/{page}")
    public List<City> listCity(@PathVariable(value = "number") int number, @PathVariable("page") int page) {
        //TODO,分页查询
        List<City> cityList = new ArrayList<>(number);
        return cityList;
    }

    @ApiOperation(value = "批量插入城市信息")
    @ApiImplicitParam(name = "cities", value = "城市信息", required = true, dataType = "List")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String saveCityList(@RequestBody List<City> cities) {
        //TODO,批量插入
        return null;
    }

}
