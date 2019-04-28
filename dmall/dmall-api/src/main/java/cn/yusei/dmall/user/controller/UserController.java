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
}
