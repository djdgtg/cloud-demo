package com.spring.cloud.web.aspect;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * description 日志切面
 *
 * @author qinchao
 * @date 2020/12/8 16:13
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    private final ObjectMapper objectMapper;

    public LogAspect(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Around("execution(* com.spring.cloud..controller.*Controller.*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        // 方法名
        String methodName = signature.getName();
        // 类名
        String serviceName = signature.getDeclaringType().getSimpleName();
        // 参数名数组
        String[] parameterNames = ((MethodSignature) signature).getParameterNames();
        Object[] args = joinPoint.getArgs();

        // 构造参数组集合
        Map<String, Object> params = new HashMap<>(8);
        for (int i = 0; i < parameterNames.length; i++) {
            Object value = args[i];
            if (args[i] instanceof HttpServletRequest) {
                value = "request";
            } else if (args[i] instanceof HttpServletResponse) {
                value = "response";
            } else if (args[i] instanceof MultipartFile) {
                value = ((MultipartFile) value).getOriginalFilename();
            }
            params.put(parameterNames[i], value);
        }
        long start = System.currentTimeMillis();
        log.info("Class name: {}, method name: {}, request params: {}",
                serviceName, methodName, objectMapper.writeValueAsString(params));
        Object result = joinPoint.proceed();
        log.info("Response params: {}, cost {}ms",
                objectMapper.writeValueAsString(result),(System.currentTimeMillis()-start));
        return result;
    }

}
