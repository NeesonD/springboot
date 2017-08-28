package com.neeson.service.impl;

import com.neeson.domain.Log;
import com.neeson.repository.LogMapper;
import com.neeson.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daile on 2017/8/17.
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void saveLog(Log log) {
        logMapper.insert(log);
    }

    @Override
    public List<Log> listLog(String clientIp) {
        return logMapper.listByClientIp(clientIp);
    }
}
