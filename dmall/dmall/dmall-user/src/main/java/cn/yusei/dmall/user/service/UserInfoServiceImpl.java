package cn.yusei.dmall.user.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.model.UserInfo;

/**
 * 这里也不是很理解，为什么要引入dubbo的包，我引入framework的包就不对。
 * 而且你那个getByusername有点鸡肋的感觉，如果是通过nickname来找的话，
 * 没什么意义啊。nickname可重复而且一直变，但是出于道义我还是写完了。就是这么倔强
 * @author 11366
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public void update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoMapper.updateUserInfo(userInfo);
	}

	@Override
	public UserInfo getById(int id) {
		return userInfoMapper.findUserInfoById(id);
	}

	@Override
	public UserInfo getByUsername(String username) {
		return userInfoMapper.findUserInfoByNickname(username);
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		try {
			userInfoMapper.addUserInfo(userInfo);
		} catch (Exception e) {
			throw e;
		}
	}
}
