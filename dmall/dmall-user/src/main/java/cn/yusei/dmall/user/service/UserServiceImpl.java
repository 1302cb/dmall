package cn.yusei.dmall.user.service;

import java.util.Arrays;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.yusei.dmall.user.dao.UserMapper;
/**
 * security验证的实体，因为最终的username可以是phone也可以是email，所以我两个都去验证了
 * 实现了api里面的userService的接口里面的方法
 * @author 11366
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		cn.yusei.dmall.user.model.User phoneMan = userMapper.findUserByPhone(username);
		cn.yusei.dmall.user.model.User emailMan = userMapper.findUserByEmail(username);
		if(phoneMan == null&&emailMan==null) {
			throw new UsernameNotFoundException(username+"不存在");
		}else if(phoneMan!=null) {
			User user = new User(username, "{MD5}"+phoneMan.getPassword(), Arrays.asList(new SimpleGrantedAuthority("role")));
			return user;
		}else {
			User user = new User(username, "{MD5}"+emailMan.getPassword(), Arrays.asList(new SimpleGrantedAuthority("role")));
			return user;
		}
		
	}
	@Override
	public cn.yusei.dmall.user.model.User findUserByPhone(cn.yusei.dmall.user.model.User user) {
		return userMapper.findUserByPhone(user.getPhone());
	}
	@Override
	public void addUser(cn.yusei.dmall.user.model.User user) {
		userMapper.addUser(user);
	}
	@Override
	public void updateUserPassword(cn.yusei.dmall.user.model.User user) {
		userMapper.updateUserPassword(user);
	}
	@Override
	public void updateUserEmail(cn.yusei.dmall.user.model.User user) {
		userMapper.updateUserEmail(user);
	}
}
