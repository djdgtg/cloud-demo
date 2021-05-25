package com.spring.cloud.oauth2.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.School;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description SchoolService
 *
 * @author qinchao
 * @date 2021/5/12 16:48
 */
public interface SchoolService {

    School getById(Integer id);

    Page<School> page(PageVO<School> page);

    List<School> list();

    void save(School school);

    void delete(String ids);

    void export(School school);

    void imports(MultipartFile file);

    void template();
}
