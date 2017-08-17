package com.neeson.domain;

import lombok.Data;

@Data
public class Log {
    private Integer idlog;

    private String clientIp;

    private String serverIp;

    private Integer runningTime;

    private String requestParam;

    private String resultParam;

    private String interfaceMethod;

    private String description;

}