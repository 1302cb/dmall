package cn.yusei.dmall.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import cn.yusei.dmall.user.model.User;

/**
 * 用户的service我都放这里面了，添加了一些关于对用户操作的方法
 * @author Yusei
 *
 */
public interface UserService extends UserDetailsService {

	//添加了对用户的增删查改之类的方法
	User findUserByPhone(User user);
	
	void addUser(User user);
	
	void updateUserPassword(User user);
	
	void updateUserEmail(User user);
}
