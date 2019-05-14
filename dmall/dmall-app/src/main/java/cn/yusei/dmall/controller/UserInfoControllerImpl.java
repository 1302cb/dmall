package cn.yusei.dmall.controller;
/**
 * @author 11366
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.yusei.dmall.user.controller.UserInfoController;
import cn.yusei.dmall.user.model.CodeResult;
import cn.yusei.dmall.user.model.UserInfo;
import cn.yusei.dmall.user.service.UserInfoService;
@RestController
@RequestMapping("/userInfo")
public class UserInfoControllerImpl implements UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("/findUserInfoById")
	@Override
	public UserInfo getUserInfoById(int id) {
		return userInfoService.getUserInfoById(id);
	}

	@RequestMapping("/update/nickname")
	@Override
	public String updateUserInfoNickname(UserInfo user) {
		try {
			System.out.println(user);
			userInfoService.updateUserInfoNickname(user);
			System.out.println(user);
			return CodeResult.getJsonCode(CodeResult.SUCCESS);
		} catch (Exception e) {
			return CodeResult.getJsonCode(CodeResult.NICKNAME_UPDATE_ERROR);
		}
	}

}
