package com.example.demo.api.service;


import com.example.demo.api.entity.CapitalInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 3
 * @since 2017-12-08
 */
public interface CapitalInfoService {
	//查询贷款配资方
    List<CapitalInfo> selectCapitalInfo(String type);

    //修改贷款配资方
    void modifyCapitalInfo(String id, String name);

    //删除贷款配资方
    void deleteCapitalInfo(String id);

    //新增贷款配资方
    void addCapitalInfo(CapitalInfo capitalInfo);
}
