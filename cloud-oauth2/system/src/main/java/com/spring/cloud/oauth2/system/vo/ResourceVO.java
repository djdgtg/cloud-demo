package com.spring.cloud.oauth2.system.vo;

import com.spring.cloud.oauth2.system.entity.ResourceEntity;
import lombok.Data;

import java.util.List;

/**
 * Description UserVO
 *
 * @author qinchao
 * @date 2021/4/26 15:07
 */
@Data
public class ResourceVO extends ResourceEntity {

    private String authorityNames;

    private String authorityIds;

    private List<Integer> ids;

}
