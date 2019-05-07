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
 * 这里因为考虑到客户端说注册只需要电话号码和密码，所以我这里只写了电话号码作为用户名的
 * @author 11366
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 从数据库中读取 username 对应的 username 、password 及 role 返回一个 UserDetails 对象
		// password 必须以 {XXX} 开头，其中 XXX 为加密编码方式"{MD5}5f4dcc3b5aa765d61d8327deb882cf99"
		/*User user = new User("username", "{MD5}5f4dcc3b5aa765d61d8327deb882cf99", Arrays.asList(new SimpleGrantedAuthority("role"))) ;
		return user;
		
		*/
		cn.yusei.dmall.user.model.User phoneMan = userMapper.findUserByPhone(username);
		if(phoneMan == null) {
			throw new UsernameNotFoundException(username+"不存在");
		}
		System.out.println("用户信息"+phoneMan);
		User user = new User(username, "{MD5}"+phoneMan.getPassword(), Arrays.asList(new SimpleGrantedAuthority("role")));
		return user;
	}
}
