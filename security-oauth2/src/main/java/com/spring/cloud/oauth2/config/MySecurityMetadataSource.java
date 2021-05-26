package com.spring.cloud.oauth2.config;

import com.spring.cloud.oauth2.entity.ResourceEntity;
import com.spring.cloud.oauth2.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * Description MyFilter
 *
 * @author qinchao
 * @date 2021/5/24 9:34
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String url = ((FilterInvocation) object).getRequest().getRequestURI();
        String method = ((FilterInvocation) object).getRequest().getMethod();
        ResourceEntity resourceEntity = resourceMapper.getResourceEntity(method, url);
        if (resourceEntity != null) {
            List<String> authorities = resourceMapper.getAccessAuthorities(resourceEntity.getId());
            if (!CollectionUtils.isEmpty(authorities) && !resourceEntity.getPermitAll()) {
                return SecurityConfig.createList(authorities.toArray(new String[0]));
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
