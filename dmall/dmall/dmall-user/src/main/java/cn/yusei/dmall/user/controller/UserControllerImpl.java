package cn.yusei.dmall.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.dao.UserMapper;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.model.UserInfo;

@Component
public class UserControllerImpl implements UserController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;

	
	@Override
	public String register(User user) {

		try {
			userMapper.addUser(user);
			userInfoMapper.addUserInfo(new UserInfo(new Date()));
			return "0";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "1";
	}

}
