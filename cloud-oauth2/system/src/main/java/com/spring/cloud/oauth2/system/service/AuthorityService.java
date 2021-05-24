package com.spring.cloud.oauth2.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.AuthorityEntity;
import com.spring.cloud.web.bean.PageVO;

import java.util.List;

/**
 * description UserService
 *
 * @author qinchao
 * @date 2021/4/20 17:14
 */
public interface AuthorityService {

    void save(AuthorityEntity authorityEntity);

    Page<AuthorityEntity> page(PageVO<AuthorityEntity> pageVO);

    void delete(String ids);

    List<AuthorityEntity> authorities();
}
