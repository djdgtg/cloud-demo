package com.spring.cloud.oauth2.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.RoleAuthorityEntity;
import com.spring.cloud.oauth2.system.entity.RoleEntity;
import com.spring.cloud.oauth2.system.mapper.RoleAuthorityMapper;
import com.spring.cloud.oauth2.system.mapper.RoleMapper;
import com.spring.cloud.oauth2.system.service.RoleService;
import com.spring.cloud.oauth2.system.vo.RoleVO;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void save(RoleVO roleVO) {
        if (roleVO.getId() == null) {
            roleMapper.insert(roleVO);
        } else {
            roleMapper.updateById(roleVO);
        }
        List<Integer> ids = roleVO.getIds();
        if (!CollectionUtils.isEmpty(ids)) {
            Integer id = roleVO.getId();
            LambdaQueryWrapper<RoleAuthorityEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(RoleAuthorityEntity::getRoleId, id);
            roleAuthorityMapper.delete(wrapper);

            for (Integer authorityIdId : ids) {
                RoleAuthorityEntity entity = new RoleAuthorityEntity();
                entity.setRoleId(id);
                entity.setAuthorityId(authorityIdId);
                roleAuthorityMapper.insert(entity);
            }
        }
    }

    @Override
    public Page<RoleVO> page(PageVO<RoleVO> pageVO) {
        return roleMapper.getPage(pageVO, pageVO.getQuery());
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(String ids) {
        roleMapper.deleteBatchIds(Arrays.asList(ids.split(",")));

        List<String> list = Arrays.asList(ids.split(","));
        if (!CollectionUtils.isEmpty(list)) {
            roleMapper.deleteBatchIds(list);

            LambdaQueryWrapper<RoleAuthorityEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(RoleAuthorityEntity::getRoleId, list);
            roleAuthorityMapper.delete(wrapper);
        }
    }

    @Override
    public List<RoleEntity> roles() {
        return roleMapper.selectList(null);
    }
}
