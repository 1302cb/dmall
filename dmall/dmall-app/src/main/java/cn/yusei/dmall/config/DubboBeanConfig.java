package cn.yusei.dmall.config;
/**
 * @author 11366
 * 将暴露服务的Bean交给容器
 */
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonBackReference;

import cn.yusei.dmall.user.controller.UserController;
import cn.yusei.dmall.user.controller.UserInfoController;
import cn.yusei.dmall.user.model.UserInfo;
import cn.yusei.dmall.user.service.UserInfoService;
import cn.yusei.dmall.user.service.UserService;

@Configuration
public class DubboBeanConfig {

	@Reference
	private UserService service;

	@Bean
	public UserService userService() {
		return service;
	}
	
	@Reference
	private UserInfoService userInfoService;
	
	@Bean
	public UserInfoService userInfoService() {
		return userInfoService;
	}
}
