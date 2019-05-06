package cn.yusei.dmall.user.service;

import java.util.Arrays;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 从数据库中读取 username 对应的 username 、password 及 role 返回一个 UserDetails 对象
		// password 必须以 {XXX} 开头，其中 XXX 为加密编码方式
		User user = new User("username", "{MD5}5f4dcc3b5aa765d61d8327deb882cf99", Arrays.asList(new SimpleGrantedAuthority("role")));
		return user;
	}
}
