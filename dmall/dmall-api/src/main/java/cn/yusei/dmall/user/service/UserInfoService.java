package cn.yusei.dmall.user.service;

import cn.yusei.dmall.user.model.UserInfo;

/**
 * 重新命名,使之命名规范化,加入了添加用户信息和修改昵称的方法
 * 
 * @author Yusei
 *
 */
public interface UserInfoService {

	void updateUserInfoNickname(UserInfo user);
	
	UserInfo getUserInfoById(int id);
	
	UserInfo getUserInfoByNickname(String username);
	
	void addUserInfo(UserInfo userInfo);
}
