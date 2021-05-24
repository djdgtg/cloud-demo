package com.spring.cloud.oauth2.gateway.config.manager;

import com.spring.cloud.oauth2.gateway.entity.ResourceEntity;
import com.spring.cloud.oauth2.gateway.mapper.ResourceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Description 自定义权限管理器
 *
 * @author qinchao
 * @date 2021/4/28 14:21
 */
@Configuration
@Slf4j
public class GatewayReactiveAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    private final static String AUTHORITY_PREFIX = "ROLE_";

    private final static String CLAIM_NAME = "authorities";

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        String url = request.getURI().getPath();
        String method = request.getMethodValue();
        //根据请求方式和url获取当前资源
        ResourceEntity resourceEntity = resourceMapper.getResourceEntity(method, url);
        if (resourceEntity != null) {
            //如果该资源permitAll，直接返回true
            if (resourceEntity.getPermitAll() != null && resourceEntity.getPermitAll()) {
                return Mono.just(new AuthorizationDecision(true));
            }
            List<String> authorities = new ArrayList<>();
            //获取该资源能够访问的权限
            List<String> accessAuthorities = resourceMapper.getAccessAuthorities(resourceEntity.getId());
            if (!CollectionUtils.isEmpty(accessAuthorities)) {
                for (String authority : accessAuthorities) {
                    authorities.add(AUTHORITY_PREFIX + authority);
                }
            }
            return mono
                    //用户是否已经认证，没有返回401(token没有或者失效)
                    .filter(Authentication::isAuthenticated)
                    //获取用户的权限
                    .flatMapIterable(Authentication::getAuthorities)
                    .map(GrantedAuthority::getAuthority)
                    //资源权限跟用户拥有的权限匹配，有一个满足即可
                    .any(authorities::contains)
                    .map(AuthorizationDecision::new)
                    //为空返回false
                    .defaultIfEmpty(new AuthorizationDecision(false));
        }
        //为空返回false，即403(forbidden)
        return Mono.just(new AuthorizationDecision(false));
    }

    @Bean
    public Converter<Jwt, Mono<AbstractAuthenticationToken>> jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(AUTHORITY_PREFIX);
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(CLAIM_NAME);
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }
}
