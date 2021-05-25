package com.spring.cloud.oauth2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.RoleEntity;
import com.spring.cloud.oauth2.vo.RoleVO;
import com.spring.cloud.web.bean.PageVO;

import java.util.List;

/**
 * description UserService
 *
 * @author qinchao
 * @date 2021/4/20 17:14
 */
public interface RoleService {

    void save(RoleVO roleVO);

    Page<RoleVO> page(PageVO<RoleVO> pageVO);

    void delete(String ids);

    List<RoleEntity> roles();
}
