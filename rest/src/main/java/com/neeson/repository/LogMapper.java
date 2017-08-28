package com.neeson.repository;


import com.neeson.domain.Log;

import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(Integer idlog);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer idlog);

    List<Log> listByClientIp(String clientIp);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}