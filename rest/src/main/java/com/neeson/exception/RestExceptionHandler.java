package com.neeson.exception;

import com.neeson.dto.ResponseErrorEnum;
import com.neeson.dto.ResponseResult;
import com.neeson.util.RestResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.UnexpectedTypeException;

/**
 * Created by daile on 2017/8/24.
 * controllerAdvice用来处理全局异常
 * 局部异常和全局异常同时存在时，局部异常将被使用
 */
@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private <T>ResponseResult<T> globalExceptionHandler(Exception e){

        return RestResultGenerator.genErrorResult(ResponseErrorEnum.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> ResponseResult<T> illegalParamsExceptionHandler(UnexpectedTypeException e) {

        return RestResultGenerator.genErrorResult(ResponseErrorEnum.ILLEGAL_PARAMS);
    }

}
