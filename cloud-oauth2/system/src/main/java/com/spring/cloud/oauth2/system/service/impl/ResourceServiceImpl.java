package com.spring.cloud.oauth2.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.ResourceAuthorityEntity;
import com.spring.cloud.oauth2.system.mapper.ResourceAuthorityMapper;
import com.spring.cloud.oauth2.system.mapper.ResourceMapper;
import com.spring.cloud.oauth2.system.service.ResourceService;
import com.spring.cloud.oauth2.system.vo.ResourceVO;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ResourceAuthorityMapper resourceAuthorityMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void save(ResourceVO resourceVO) {
        if (resourceVO.getId() == null) {
             resourceMapper.insert(resourceVO);
        } else {
            resourceMapper.updateById(resourceVO);

            LambdaQueryWrapper<ResourceAuthorityEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ResourceAuthorityEntity::getResourceId, resourceVO.getId());
            resourceAuthorityMapper.delete(wrapper);
        }

        List<Integer> ids = resourceVO.getIds();
        if (!CollectionUtils.isEmpty(ids)) {
            Integer id = resourceVO.getId();
            for (Integer authorityIdId : ids) {
                ResourceAuthorityEntity entity = new ResourceAuthorityEntity();
                entity.setResourceId(id);
                entity.setAuthorityId(authorityIdId);
                resourceAuthorityMapper.insert(entity);
            }
        }
    }

    @Override
    public Page<ResourceVO> page(PageVO<ResourceVO> pageVO) {
        return resourceMapper.getPage(pageVO, pageVO.getQuery());
    }

    @Override
    public void delete(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        if (!CollectionUtils.isEmpty(list)) {
            resourceMapper.deleteBatchIds(list);

            LambdaQueryWrapper<ResourceAuthorityEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(ResourceAuthorityEntity::getResourceId, list);
            resourceAuthorityMapper.delete(wrapper);
        }
    }

}
