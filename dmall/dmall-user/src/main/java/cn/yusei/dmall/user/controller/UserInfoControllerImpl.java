package cn.yusei.dmall.user.controller;
/**
 * @author 11366
 */
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.model.UserInfo;


@Service
public class UserInfoControllerImpl implements UserInfoController {

	@Autowired
	private UserInfoMapper userInfoMapper;
	//根据id查找用户信息
	@Override
	@ResponseBody
	public UserInfo getUserInfoById(int id) {
		return userInfoMapper.findUserInfoById(id);
	}
	//更新用户的昵称
	@Override
	public String updateUserInfoNickname(UserInfo user) {
		try {
			userInfoMapper.updateUserInfo(user);
			return "{\"code\":\"0\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"code\":\"1\"}";
	}

}
