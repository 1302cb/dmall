package cn.yusei.dmall;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan(basePackages = { "cn.yusei.dmall" })
@SpringBootApplication
public class DMallApp {

	public static void main(String[] args) {
		SpringApplication.run(DMallApp.class, args);
	}

}
