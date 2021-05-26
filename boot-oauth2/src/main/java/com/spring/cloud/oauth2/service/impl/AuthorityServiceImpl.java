package com.spring.cloud.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.AuthorityEntity;
import com.spring.cloud.oauth2.mapper.AuthorityMapper;
import com.spring.cloud.oauth2.service.AuthorityService;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
            if (StringUtils.hasText(query.getAuthorityName())) {
                wrapper.eq(AuthorityEntity::getAuthorityName, query.getAuthorityName());
            }
            if (StringUtils.hasText(query.getName())) {
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
