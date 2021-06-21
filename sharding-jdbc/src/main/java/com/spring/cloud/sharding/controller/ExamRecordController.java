package com.spring.cloud.sharding.controller;

import com.spring.cloud.sharding.entity.ExamRecord;
import com.spring.cloud.sharding.mapper.ExamRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description ExamRecordController
 *
 * @author qinchao
 * @date 2021/6/21 11:43
 */
@RestController
@RequestMapping("exam_record")
public class ExamRecordController {

    @Autowired
    private ExamRecordMapper examRecordMapper;

    @GetMapping("{id}")
    public ExamRecord getById(@PathVariable Long id){
        return examRecordMapper.selectById(id);
    }

}
