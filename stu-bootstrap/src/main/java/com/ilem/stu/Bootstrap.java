package com.ilem.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuwenkai
 * @date 2019/10/28 7:29 下午
 **/
@SpringBootApplication(scanBasePackages = {
		"com.ilem"
})
public class Bootstrap {
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}

}
