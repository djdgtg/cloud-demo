package com.spring.cloud.oauth2.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.vo.ResourceVO;
import com.spring.cloud.web.bean.PageVO;

/**
 * description UserService
 *
 * @author qinchao
 * @date 2021/4/20 17:14
 */
public interface ResourceService {

    void save(ResourceVO resourceVO);

    Page<ResourceVO> page(PageVO<ResourceVO> pageVO);

    void delete(String ids);
}
