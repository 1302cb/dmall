package cn.yusei.dmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexTestController {

	@RequestMapping("/register")
	public String register() {
		return "registerPage";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "loginPage";
	}
}
