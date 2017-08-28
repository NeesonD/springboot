package com.neeson.controller;

import com.neeson.domain.Log;
import com.neeson.dto.ResponseResult;
import com.neeson.exception.MyException;
import com.neeson.service.LogService;
import com.neeson.util.RestResultGenerator;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by daile on 2017/8/24.
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping(value = "/list/{clientIp}")
    @ApiImplicitParam(name = "clientIp", paramType = "path", dataType = "String")
    public ResponseResult<List<Log>> listLog(@PathVariable String clientIp) throws Exception{
        if (clientIp.equals("1")){
         throw new MyException("参数为空");
        }
        List<Log> logList = logService.listLog(clientIp);
        return RestResultGenerator.genResult(logList, "成功！");
    }

    @PostMapping(value = "saveUser")
    public ResponseResult saveUser(@RequestBody Log log) {
        logService.saveLog(log);
        return RestResultGenerator.genResult("保存成功!");
    }
}
