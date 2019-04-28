package cn.yusei.dmall.config;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.yusei.dmall.user.service.UserService;

@Configuration
public class DubboBeanConfig {

	@Reference
	private UserService service;

	@Bean
	public UserService userService() {
		return service;
	}

}
