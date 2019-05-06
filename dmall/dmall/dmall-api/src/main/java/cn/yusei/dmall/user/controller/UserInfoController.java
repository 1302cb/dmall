package cn.yusei.dmall.user.controller;

import cn.yusei.dmall.user.model.UserInfo;

/**
 * 
 * @author Yusei
 *
 */
public interface UserInfoController {

	/**
	 * 
	 * @param id 要获取的用户的 id
	 * @return
	 */
	UserInfo get(int id);
	
	/**
	 * 
	 * @param user
	 * @return 更新状态的 JSON 字符串
	 */
	String update(UserInfo user);
}
