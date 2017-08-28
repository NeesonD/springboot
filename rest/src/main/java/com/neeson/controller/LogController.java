package com.neeson.controller;

import com.neeson.domain.Log;
import com.neeson.dto.ResponseResult;
import com.neeson.service.LogService;
import com.neeson.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by daile on 2017/8/24.
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping(value = "/list")
    public ResponseResult<List<Log>> listLog(String clientIp){
        List<Log> logList = logService.listLog(clientIp);
        return RestResultGenerator.genResult(logList,"成功！");
    }

    @PostMapping(value = "saveUser")
    public ResponseResult saveUser(@Valid @RequestBody Log log) {
        logService.saveLog(log);
        return RestResultGenerator.genResult("保存成功!");
    }
}
