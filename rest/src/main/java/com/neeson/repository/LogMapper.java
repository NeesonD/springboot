package com.neeson.repository;


import com.neeson.domain.Log;

public interface LogMapper {
    int deleteByPrimaryKey(Integer idlog);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer idlog);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}