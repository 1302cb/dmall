package cn.yusei.dmall.controller;

import org.springframework.stereotype.Controller;
/**
 * 用于返回界面
 * @author 11366
 *
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {

	@GetMapping("/helloPage")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/registerPage")
	public String register(){
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String login(){
		return "login";
	}
}
