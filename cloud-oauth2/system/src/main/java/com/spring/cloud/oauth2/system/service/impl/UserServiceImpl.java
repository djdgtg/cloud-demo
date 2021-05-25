package com.spring.cloud.oauth2.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.UserEntity;
import com.spring.cloud.oauth2.system.entity.UserRoleEntity;
import com.spring.cloud.oauth2.system.mapper.UserMapper;
import com.spring.cloud.oauth2.system.mapper.UserRoleMapper;
import com.spring.cloud.oauth2.system.service.UserService;
import com.spring.cloud.oauth2.system.vo.UserImportVO;
import com.spring.cloud.oauth2.system.vo.UserVO;
import com.spring.cloud.web.bean.PageVO;
import com.spring.cloud.web.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description JdbcUserDetailsServiceImpl
 *
 * @author qinchao
 * @date 2021/3/12 14:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private ExcelUtils excelUtils;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void save(UserVO userVO) {
        if (userVO.getId() == null) {
            userMapper.insert(userVO);
        } else {
            userMapper.updateById(userVO);
            //先删除，后新增
            LambdaQueryWrapper<UserRoleEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserRoleEntity::getUserId, userVO.getId());
            userRoleMapper.delete(wrapper);
        }

        List<Integer> ids = userVO.getIds();
        if (!CollectionUtils.isEmpty(ids)) {
            Integer id = userVO.getId();
            for (Integer roleId : ids) {
                UserRoleEntity entity = new UserRoleEntity();
                entity.setUserId(id);
                entity.setRoleId(roleId);
                userRoleMapper.insert(entity);
            }
        }
    }

    @Override
    public Page<UserVO> page(PageVO<UserVO> pageVO) {
        return userMapper.getPage(pageVO);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        if (!CollectionUtils.isEmpty(list)) {
            userMapper.deleteBatchIds(list);

            LambdaQueryWrapper<UserRoleEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(UserRoleEntity::getUserId, list);
            userRoleMapper.delete(wrapper);
        }
    }

    @Override
    public void export(UserVO userVO) {
        Map<String, Object> query = new HashMap<>();
        query.put("query", userVO);
        List<UserVO> list = userMapper.getList(query);
        excelUtils.export(list, "用户导出", UserVO.class);
    }

    @Override
    public void imports(MultipartFile file) {
        List<UserImportVO> list = excelUtils.getList(file, UserImportVO.class);
        userMapper.importBatch(list);
    }

    @Override
    public void template() {
        excelUtils.exportFile("user-import-template.xlsx");
    }

    @Override
    public void enabled(Boolean enabled, List<Integer> ids) {
        UserEntity entity = new UserEntity();
        entity.setEnabled(enabled);
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(UserEntity::getId, ids);
        userMapper.update(entity, wrapper);
    }

}
