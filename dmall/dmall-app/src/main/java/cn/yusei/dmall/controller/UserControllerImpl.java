package cn.yusei.dmall.controller;
/**
 * 关于user的控制器类,主要是实现用户的注册，修改邮箱和密码
 * @author 11366
 */
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.alibaba.fastjson.JSONObject;

import cn.yusei.dmall.user.controller.UserController;
import cn.yusei.dmall.user.model.CodeResult;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.model.UserInfo;
import cn.yusei.dmall.user.service.UserInfoService;
import cn.yusei.dmall.user.service.UserService;
import cn.yusei.dmall.user.utils.MatchEmailAndPhoneUtil;
@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("/register")
	@Override
	public String register(User user) {
		
		try {
			if(user.getPhone()==null||user.getPassword()==null) {
				return CodeResult.getJsonCode(CodeResult.EMPLEMENT_NULL);
			}
			if(MatchEmailAndPhoneUtil.isPhoneNumber(user.getPhone())==false ||userService.findUserByPhone(user)!=null) {
				return CodeResult.getJsonCode(CodeResult.PHONE_MATCH_ERROR);
			}
			userService.addUser(user);
			userInfoService.addUserInfo(new UserInfo(new Date()));
			return CodeResult.getJsonCode(CodeResult.SUCCESS);
		} catch (Exception e) {
			return CodeResult.getJsonCode(CodeResult.REGISTER_ERROR);
		}
	}

	@RequestMapping("/update/email")
	@Override
	public String updateUserEmail(User user) {
		try {
			if(user.getEmail()==null) {
				return CodeResult.getJsonCode(CodeResult.EMPLEMENT_NULL);
			}
			if(MatchEmailAndPhoneUtil.isEmail(user.getEmail())==false) {
				return CodeResult.getJsonCode(CodeResult.EMAIL_MATCH_ERROR);
			}
			userService.updateUserEmail(user);
			return CodeResult.getJsonCode(CodeResult.SUCCESS);
		} catch (Exception e) {
			return CodeResult.getJsonCode(CodeResult.EMAIL_UPDATE_ERROR);
		}
	}

	@RequestMapping("/update/password")
	@Override
	public String updateUserPassword(User user) {
		try {
			if(user.getPassword()==null) {
				return CodeResult.getJsonCode(CodeResult.EMPLEMENT_NULL);
			}
			userService.updateUserPassword(user);
			return CodeResult.getJsonCode(CodeResult.SUCCESS);
		} catch (Exception e) {
			return CodeResult.getJsonCode(CodeResult.PASSWORD_UPDATE_ERROR);
		}
	}

}
