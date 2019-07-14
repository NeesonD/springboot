package com.neeson.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daile on 2017/9/5.
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    @Qualifier("simpleCacheManager")
    private CacheManager simpleCacheManager;

    @PostMapping("/save")
    public Map<String,Object> save(@RequestParam String key,@RequestParam String value){

        Cache cache = simpleCacheManager.getCache("cache-1");
        cache.put(key,value);

        Map<String,Object> result = new HashMap<>(1);

        result.put(key,value);

        return result;

    }

}
