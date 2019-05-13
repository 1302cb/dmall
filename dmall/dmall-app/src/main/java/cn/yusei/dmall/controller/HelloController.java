package cn.yusei.dmall.controller;
/**
 * @author 11366
 */
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yusei.dmall.user.controller.UserController;
import cn.yusei.dmall.user.controller.UserInfoController;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.model.UserInfo;
import cn.yusei.dmall.user.service.UserInfoService;
import cn.yusei.dmall.user.service.UserService;

/**
 * @author 11366
 *
 */
@RestController
public class HelloController {

	@Reference(url = "dubbo://localhost:20080")
	private UserService service;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private UserInfoController userInfoController;
	
	@Autowired
	private UserInfoService userInfoService;
	
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
		return userInfoController.updateUserInfoNickname(userInfo);
	}
}
