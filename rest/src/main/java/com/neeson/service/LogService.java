package com.neeson.service;

import com.neeson.domain.Log;

import java.util.List;

/**
 * Created by daile on 2017/8/17.
 */
public interface LogService {

    void saveLog(Log log);

    List<Log> listLog(String clientIp);

    Log getLog();

}
