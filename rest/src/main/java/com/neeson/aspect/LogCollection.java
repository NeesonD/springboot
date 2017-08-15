package com.neeson.aspect;

import com.google.gson.Gson;
import com.neeson.annotation.ControllerLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * Created by daile on 2017/8/14.
 */
@Aspect
@Component
@Slf4j
public class LogCollection {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.neeson.annotation.ControllerLog)")
    public void controllerAspect() {
    }

//    @Before("controllerAspect()")
//    public void before(JoinPoint joinPoint) throws IOException {
//        startTime.set(System.currentTimeMillis());
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes == null) {
//            return;
//        }
//        try {
//            HttpServletRequest request = attributes.getRequest();
//            String IP = request.getRemoteAddr();
//            String requestParam = getRequestParam(joinPoint);
//            Object[] args = joinPoint.getArgs();
//            for (int i = 0; i < args.length; i++) {
//                log.info("第" + (i + 1) + "个参数为:" + args[i]);
//            }
//
//            log.info("请求方法：" + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
//            log.info("请求描述：" + getMethodDesctiption(joinPoint));
//            log.info("请求参数：" + requestParam);
//            log.info("请求IP：" + IP);
//            log.info("服务器IP：" + request.getLocalAddr());
//        } catch (Exception e) {
//            log.error("异常信息{}", e);
//        }
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "controllerAspect()")
//    public void after(Object ret) {
//        log.info("response:" + ret);
//        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//    }

    @Around("controllerAspect()")
    public void logger(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String requestParam = getRequestParam(pjp);
        log.info("请求参数：" + requestParam);
//        Object[] args = pjp.getArgs();
//        for (int i = 0; i < args.length; i++) {
//            log.info("第" + (i + 1) + "个参数为:" + args[i]);
//        }
        Object proceed = pjp.proceed();
        log.info("运行结果：" + proceed);
        long endTime = System.currentTimeMillis();
        log.info("运行时间：" + (endTime - startTime));

    }

    private String getRequestParam(JoinPoint joinPoint) {
        Gson gson = new Gson();
        StringBuffer requestStr = new StringBuffer();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                if (i != joinPoint.getArgs().length - 1) {
                    requestStr.append(gson.toJson(joinPoint.getArgs()[i]));
                    requestStr.append(",");
                } else {
                    requestStr.append(gson.toJson(joinPoint.getArgs()[i]));
                }
            }
        }
        return requestStr.toString();
    }

    private String parseRequest(HttpServletRequest request) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();
        }
    }


    public String getMethodDesctiption(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] classes = method.getParameterTypes();
                if (classes.length == arguments.length) {
                    description = method.getAnnotation(ControllerLog.class).description();
                }
            }
        }
        return description;
    }

}
