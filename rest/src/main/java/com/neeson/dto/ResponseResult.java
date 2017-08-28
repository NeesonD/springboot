package com.neeson.dto;

/**
 * Created by daile on 2017/8/24.
 */
public class ResponseResult<T> {

    private boolean success;
    private String message;
    private T data;
    private String errorCode;

    public static <T> ResponseResult<T> newInstance(){
        return new ResponseResult<>();
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    // 设置错误信息
    public void setErrorInfo(ResponseErrorEnum responseErrorEnum) {
        this.errorCode = responseErrorEnum.getCode();
        this.message = responseErrorEnum.getMessage();
    }

}
