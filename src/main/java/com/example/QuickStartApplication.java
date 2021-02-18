package com.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StopWatch;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author  zxc
 * @date  2019/08/16
 */
@Slf4j
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.example.*.dao")
@EnableSwagger2
@EnableCaching
public class QuickStartApplication {

	public static void main(String[] args) {
		//统计启动耗时
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("run");
		SpringApplication.run(QuickStartApplication.class, args);
		stopWatch.stop();
		log.info("run end！ {}", stopWatch.prettyPrint());
	}

}
