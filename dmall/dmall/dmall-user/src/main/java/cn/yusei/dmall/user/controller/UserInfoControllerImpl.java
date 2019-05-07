package cn.yusei.dmall.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.model.UserInfo;
@Component
public class UserInfoControllerImpl implements UserInfoController {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	@ResponseBody
	public UserInfo get(int id) {
		return userInfoMapper.findUserInfoById(id);
	}

	@Override
	public String update(UserInfo user) {
		try {
			userInfoMapper.updateUserInfo(user);
			return "0";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "1";
	}

}
