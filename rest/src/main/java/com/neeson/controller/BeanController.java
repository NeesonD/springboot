package com.neeson.controller;

import com.neeson.domain.BeanCopy;
import com.neeson.dto.BeanCopyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daile on 2017/9/12.
 */
@RestController
@RequestMapping("/bean")
@Slf4j
public class BeanController {


    @PostMapping("/copy")
    public BeanCopyDto copyDto(@RequestBody BeanCopyDto beanCopyDto){
        BeanCopy b = new BeanCopy();
        BeanUtils.copyProperties(beanCopyDto,b);
        log.info(b.toString());
        BeanCopyDto bdto = new BeanCopyDto();
        BeanUtils.copyProperties(b,bdto);
        log.info(bdto.toString());
        return bdto;
    }

}
