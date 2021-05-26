package com.spring.cloud.oauth2.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * description 日志切面
 *
 * @author qinchao
 * @date 2020/12/8 16:13
 */
@Component
@Aspect
@Slf4j
public class AuthAspect {

    private final TokenStore tokenStore;

    public AuthAspect(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Before("execution(* com.spring.cloud.oauth2.controller.*Controller.*(..))")
    public void auth() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String authorization = request.getHeader("Authorization");
        if (StringUtils.hasText(authorization)) {
            authorization = authorization.replace("Bearer ", "");
            OAuth2Authentication authentication = tokenStore.readAuthentication(authorization);
            if (authentication != null) {
                User principal = (User) authentication.getPrincipal();
                Collection<? extends GrantedAuthority> authorities = authentication.getUserAuthentication().getAuthorities();
                log.info("username: {}, authorities: {}", principal.getUsername(), authorities);
            }
        }
    }

}
