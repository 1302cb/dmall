package cn.yusei.dmall.user;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@DubboComponentScan(basePackages = { "cn.yusei.dmall.user" })
@SpringBootApplication
//开启事务管理的支持
@EnableTransactionManagement
public class DmallUser {
	public static void main(String[] args) {
		SpringApplication.run(DmallUser.class, args);
	}
}
