package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuicksTartApplicationTests {

	@Autowired
	DataSourceProperties dataSourceProperties;

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		// 获取配置的数据源
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		// 查看配置数据源信息
		System.out.println(dataSource);
		System.out.println(dataSource.getClass().getName());
		System.out.println(dataSourceProperties);
	}
}
