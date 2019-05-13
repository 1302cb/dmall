package cn.yusei.dmall.user.controller;

import cn.yusei.dmall.user.model.User;

/**
 * 
 * @author Yusei
 *
 */
public interface UserController {

	/**
	 * 
	 * @param user
	 * @return 注册结果的 JSON 字符串，格式为 {"code":0}
	 */
	String register(User user);
	//添加了连个方法，更新用户的email和password
	String updateUserEmail(User user); 
	String updateUserPassword(User user);
}
