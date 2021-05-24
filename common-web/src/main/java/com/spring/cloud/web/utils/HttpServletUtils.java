package com.spring.cloud.web.utils;

import com.spring.cloud.web.exception.StatusException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Description HttpServletUtils
 *
 * @author qinchao
 * @date 2021/5/8 18:09
 */
@Slf4j
public class HttpServletUtils {

    private static final String UNKNOWN = "unknown";

    public static String getFileName(String fileName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            fileName = new String(fileName.getBytes(), StandardCharsets.UTF_8);
            String agent = request.getHeader("USER-AGENT");
            if (agent.contains("Firefox")) {
                // 火狐浏览器
                BASE64Encoder base64Encoder = new BASE64Encoder();
                fileName = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes(StandardCharsets.UTF_8)) + "?=";
            } else {
                // 其它浏览器
                fileName = URLEncoder.encode(fileName, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            log.error("encode fileName [{}] error", fileName, e);
            throw new StatusException(400, e);
        }
        return fileName;
    }

    /**
     * 获取IP地址
     *
     * @return
     */
    public static String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
