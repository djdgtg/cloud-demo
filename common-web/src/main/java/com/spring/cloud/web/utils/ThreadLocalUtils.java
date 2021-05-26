package com.spring.cloud.web.utils;

/**
 * description 当前线程可以共享的变量（比如在controller设置当前请求的用户的id，在service层可以直接获取到该用户id）
 *
 * @author qinchao
 * @date 2021/2/25 17:25
 */
public class ThreadLocalUtils {

    private final static ThreadLocal<Object> LOCAL_VALUE = new ThreadLocal<>();

    public static void setLocalValue(Object value) {
        LOCAL_VALUE.set(value);
    }

    public static Object getLocalValue() {
        return LOCAL_VALUE.get();
    }

    public static void removeLocalValue() {
        LOCAL_VALUE.remove();
    }

}