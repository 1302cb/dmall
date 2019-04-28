package cn.yusei.dmall.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yusei.dmall.user.service.UserService;

/**
 * 这个类只是用于测试，可以删掉
 *
 */
@RestController
public class HelloController {

	@Reference(url = "dubbo://localhost:20080")
	private UserService service;

	@GetMapping(value = "/hello")
	public String hello() {
		UserDetails userDetails = service.loadUserByUsername("");
		return "Hello " + userDetails + " !";
	}

}
