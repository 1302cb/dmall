package cn.yusei.dmall.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.dao.UserMapper;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.model.UserInfo;
import org.apache.dubbo.config.annotation.Service;
@Service
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
			return "{\"code\":\"0\"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"code\":\"1\"}";
	}

	//更新用户的邮箱的服务
	@Override
	public String updateUserEmail(User user) {
		try {
//			user = userMapper.findUserByPhone(user.getPhone());
			userMapper.updateUserEmail(user);
			return "{\"code\":\"0\"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"code\":\"1\"}";
	}
	//更新用户密码的服务
	@Override
	public String updateUserPassword(User user) {
		try {
			userMapper.updateUserPassword(user);
			return "{\"code\":\"0\"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"code\":\"1\"}";
	}
	
}
