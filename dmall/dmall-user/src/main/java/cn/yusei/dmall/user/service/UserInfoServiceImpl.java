package cn.yusei.dmall.user.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.model.UserInfo;

/**
 * 
 * 而且你那个getByusername有点鸡肋的感觉，如果是通过nickname来找的话，
 * 没什么意义啊。nickname可重复而且一直变，但是出于道义我还是写完了。就是这么倔强
 * @author 11366
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	//更新用户昵称
	@Override
	public void updateUserInfoNickname(UserInfo userInfo) {
		userInfoMapper.updateUserInfo(userInfo);
	}
	
	//根据id找到对应的UserInfo
	@Override
	public UserInfo getUserInfoById(int id) {
		return userInfoMapper.findUserInfoById(id);
	}

	//根据昵称查找UserInfo
	@Override
	public UserInfo getUserInfoByNickname(String username) {
		return userInfoMapper.findUserInfoByNickname(username);
	}

	//添加UserInfo
	@Override
	public void addUserInfo(UserInfo userInfo) {
		try {
			userInfoMapper.addUserInfo(userInfo);
		} catch (Exception e) {
			throw e;
		}
	}
}
