package cn.yusei.dmall.user.controller;
/**
 * 这个类实现了注册的业务，还有出路用户的一些业务
 * @author 11366
 */
import java.util.Date;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.dao.UserMapper;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.model.UserInfo;
import cn.yusei.dmall.user.utils.MatchEmailAndPhoneUtil;
@Service
public class UserControllerImpl implements UserController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;

	
	
	
	@Override
	public String register(User user) {

		try {
			//校验电话号码是否符合规则
			if(MatchEmailAndPhoneUtil.isPhoneNumber(user.getPhone())==false) {
				return "{\"code\":\"0\"}"; 
			}
			//校验是否已经注册过
			User isRegisterable = userMapper.findUserByPhone(user.getPhone());
			if(isRegisterable!=null) {
				return "{\"code\":\"0\"}";
			}
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
