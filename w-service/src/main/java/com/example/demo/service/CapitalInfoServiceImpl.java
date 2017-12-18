package com.example.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.api.entity.CapitalInfo;
import com.example.demo.api.service.CapitalInfoService;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 3
 * @since 2017-12-08
 */
@org.springframework.stereotype.Service
public class CapitalInfoServiceImpl implements CapitalInfoService {

    @Override
    public List<CapitalInfo> selectCapitalInfo(String type) {
        List<CapitalInfo> capitalInfoList = new CapitalInfo().selectList(new EntityWrapper<CapitalInfo>().eq("product_type",type));
        return capitalInfoList;
    }

    @Override
    public void modifyCapitalInfo(String id, String name) {
        CapitalInfo capitalInfo = new CapitalInfo();
        capitalInfo.setId(id);
        capitalInfo.setName(name);
        capitalInfo.setUpdateTime(new Date());
        capitalInfo.updateById();
    }

    @Override
    public void deleteCapitalInfo(String id) {
        CapitalInfo capitalInfo = new CapitalInfo();
        capitalInfo.setId(id);
        capitalInfo.deleteById();
    }

    @Override
    public void addCapitalInfo(CapitalInfo capitalInfo) {
        capitalInfo.insert();
    }
}
