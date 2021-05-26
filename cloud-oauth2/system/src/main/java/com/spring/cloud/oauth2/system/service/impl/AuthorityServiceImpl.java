package com.spring.cloud.oauth2.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.AuthorityEntity;
import com.spring.cloud.oauth2.system.mapper.AuthorityMapper;
import com.spring.cloud.oauth2.system.service.AuthorityService;
import com.spring.cloud.web.bean.PageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * description JdbcUserDetailsServiceImpl
 *
 * @author qinchao
 * @date 2021/3/12 14:32
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public void save(AuthorityEntity authorityEntity) {
        if (authorityEntity.getId() == null) {
            authorityMapper.insert(authorityEntity);
        } else {
            authorityMapper.updateById(authorityEntity);
        }
    }

    @Override
    public Page<AuthorityEntity> page(PageVO<AuthorityEntity> pageVO) {
        LambdaQueryWrapper<AuthorityEntity> wrapper = new LambdaQueryWrapper<>();
        AuthorityEntity query = pageVO.getQuery();
        if (query != null) {
            if (StringUtils.isNotBlank(query.getAuthorityName())) {
                wrapper.eq(AuthorityEntity::getAuthorityName, query.getAuthorityName());
            }
            if (StringUtils.isNotBlank(query.getName())) {
                wrapper.like(AuthorityEntity::getName, "%" + query.getName() + "%");
            }
        }
        return authorityMapper.selectPage(pageVO, wrapper);
    }

    @Override
    public void delete(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        if (!CollectionUtils.isEmpty(list)) {
            authorityMapper.deleteBatchIds(list);
        }

    }

    @Override
    public List<AuthorityEntity> authorities() {
        return authorityMapper.selectList(null);
    }
}
