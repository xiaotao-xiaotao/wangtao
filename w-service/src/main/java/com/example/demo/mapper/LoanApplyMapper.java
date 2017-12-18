package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.api.entity.LoanApply;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hhc
 * @since 2017-08-29
 */
public interface LoanApplyMapper extends BaseMapper<LoanApply> {

    List<LoanApply> selectApplyList();
}