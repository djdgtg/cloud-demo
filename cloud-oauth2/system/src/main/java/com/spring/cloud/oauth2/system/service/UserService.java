package com.spring.cloud.oauth2.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.vo.UserVO;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * description UserService
 *
 * @author qinchao
 * @date 2021/4/20 17:14
 */
public interface UserService {

    void save(UserVO userVO);

    Page<UserVO> page(PageVO<UserVO> pageVO);

    void delete(String ids);

    void export(UserVO userVO);

    void imports(MultipartFile file);

    void template();

    void enabled(Boolean enabled, List<Integer> ids);

}
