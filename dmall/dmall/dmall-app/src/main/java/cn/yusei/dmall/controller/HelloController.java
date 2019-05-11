package cn.yusei.dmall.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yusei.dmall.user.controller.UserController;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.service.UserService;

/**
 * 这个类只是用于测试，可以删掉
 *
 */
@RestController
public class HelloController {

	@Reference(url = "dubbo://localhost:20080")
	private UserService service;
	
	@Reference(url = "dubbo://localhost:20080")
	private UserController controller;
	
	@RequestMapping("/user/register")
	public String userRegister(User user) {
		return controller.register(user)+"注册成功";
	}
	
	/*@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String Login() {
		return "login";
	}*/
	
	/*@GetMapping(value = "/hello")
	public String hello() {
		UserDetails userDetails = service.loadUserByUsername("");
		return "Hello " + userDetails + " !";
	}*/
	
	
}
