package com.javalemon.guide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.javalemon.guide.dao.mapper") //扫描的mapper
public class GuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuideApplication.class, args);
	}

}
