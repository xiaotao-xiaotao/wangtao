package com.example.demo.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.R;
import com.example.demo.api.service.LoanApplyService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@RestController
public class TestController {
   // Logger logger = Logger.getLogger(TestController.class);
    @Reference(version = "1.0.0")
    private LoanApplyService loanApplyService;
    @RequestMapping("/test")
    public R test(){
        return R.ok().put("data",loanApplyService.loanApplyList());
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("张三",123);
        map.put("李四",234);
        map.put("王五",456);
        Set set = map.entrySet();
        for (int i = 0; i < set.size(); i++) {
        }
    }
}
