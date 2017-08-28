package com.neeson.util;

import com.google.gson.Gson;
import com.neeson.dto.ResponseErrorEnum;
import com.neeson.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by daile on 2017/8/24.
 */
@Slf4j
public class RestResultGenerator {

    private static Gson gson = new Gson();

    /**
     * 生成响应成功的(不带正文)的结果
     * @param message
     * @return
     */
    public static ResponseResult genResult(String message){
        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setMessage(message);
        return responseResult;
    }

    /**
     * 生成响应成功的(带正文)的结果
     * @link ResponseResult
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> genResult(T data,String message){

        ResponseResult<T> responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setMessage(message);
        responseResult.setData(data);
        if (log.isDebugEnabled()){
            log.debug("------> result:{}",gson.toJson(responseResult));
        }
        return responseResult;
    }

    /**
     * 生成响应失败的结果
     * @param errorEnum
     * @return
     */
    public static ResponseResult genErrorResult(ResponseErrorEnum errorEnum){
        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(false);
        responseResult.setErrorInfo(errorEnum);
        if (log.isDebugEnabled()){
            log.debug("------> result:{}",gson.toJson(responseResult));
        }
        return responseResult;
    }

    public static ResponseResult genReeorResult(String message){
        ResponseResult result = ResponseResult.newInstance();
        result.setSuccess(false);
        result.setMessage(message);

        if (log.isDebugEnabled()) {
            log.debug("--------> result:{}", gson.toJson(result));
        }

        return result;
    }


}
