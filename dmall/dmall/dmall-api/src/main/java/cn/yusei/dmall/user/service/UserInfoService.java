package cn.yusei.dmall.user.service;

import cn.yusei.dmall.user.model.UserInfo;

/**
 * 
 * @author Yusei
 *
 */
public interface UserInfoService {

	void update(UserInfo user);
	
	UserInfo getById(int id);
	
	UserInfo getByUsername(String username);
	
	void addUserInfo(UserInfo userInfo);
}
