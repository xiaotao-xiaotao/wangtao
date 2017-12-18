package com.example.demo;

import com.example.demo.api.entity.CapitalInfo;
import com.example.demo.api.service.CapitalInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplicationTests.class)
@WebAppConfiguration
@SpringBootTest(classes = ServiceApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)

public class ServiceApplicationTests {

	@Autowired
	CapitalInfoService capitalInfoService;
	@Test
	public void selectCapitalInfo() {
		/*capitalInfoService.selectCapitalInfo("csd");
		capitalInfoService.modifyCapitalInfo("1","外滩网信1");
		capitalInfoService.deleteCapitalInfo("1");*/
		CapitalInfo capitalInfo = new CapitalInfo();
		capitalInfo.setName("张三1");
		capitalInfo.setAddress("ddddd");
		capitalInfo.setCreateTime(new Date());
		capitalInfo.setUpdateTime(new Date());
		capitalInfoService.addCapitalInfo(capitalInfo);
	}

}
