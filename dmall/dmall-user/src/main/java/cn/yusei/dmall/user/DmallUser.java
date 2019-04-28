package cn.yusei.dmall.user;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan(basePackages = { "cn.yusei.dmall.user" })
@SpringBootApplication
public class DmallUser {
	public static void main(String[] args) {
		SpringApplication.run(DmallUser.class, args);
	}
}
