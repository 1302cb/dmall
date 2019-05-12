package cn.yusei.dmall.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yusei.dmall.user.controller.UserController;
import cn.yusei.dmall.user.controller.UserInfoController;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.model.UserInfo;
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
	private UserController userController;
	
	@Reference(url = "dubbo://localhost:20080")
	private UserInfoController userInfoController;
	
	//用户注册接口
	@RequestMapping("/user/register")
	public String userRegister(User user) {
		return userController.register(user);
	}
	//用户修改邮箱接口
	@RequestMapping("/user/update/email")
	public String userUpdateEmail(User user) {
		return userController.updateUserEmail(user);
	}
	//用户修改密码接口
	@RequestMapping("/user/update/password")
	public String userUpdatePassword(User user) {
		return userController.updateUserPassword(user);
	}
	//用户修改昵称
	@RequestMapping("/user/update/nickname")
	public String userInfoUpdateNickname(UserInfo userInfo) {
		return userInfoController.update(userInfo);
	}
}
