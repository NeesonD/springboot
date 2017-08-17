package com.neeson.service.impl;

import com.neeson.domain.Log;
import com.neeson.repository.LogMapper;
import com.neeson.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by daile on 2017/8/17.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void saveLog(Log log) {
        logMapper.insert(log);
    }
}
