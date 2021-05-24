package com.spring.cloud.oauth2.gateway.config;

import com.spring.cloud.oauth2.gateway.config.manager.GatewayReactiveAuthorizationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

/**
 * description
 *
 * @author qinchao
 * @date 2021/3/12 10:45
 */
@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
                                                            Converter<Jwt, Mono<AbstractAuthenticationToken>> jwtAuthenticationConverter,
                                                            GatewayReactiveAuthorizationManager manager) {
        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
        http.authorizeExchange()
                .pathMatchers("/auth/oauth/**").permitAll()
                .anyExchange()
                .access(manager)
                .and().csrf().disable();
        return http.build();
    }

}
