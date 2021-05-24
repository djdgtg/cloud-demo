package com.spring.cloud.web.bean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * description PageVO 分页查询对象
 *
 * @author qinchao
 * @date 2021/2/3 17:52
 */
@Data
public class PageVO<T> extends Page<T> {

    private T query;

    public PageVO(){

    }

    public PageVO(T query){
        this.query = query;
    }

    public static <T> PageVO<T> pageVO(T query){
        return new PageVO<>(query);
    }

}
