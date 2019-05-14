package cn.yusei.dmall.user.test;
/**
 * 这个你到时候可以删除，或者直接测试
 * @author 11366
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.dao.UserMapper;
import cn.yusei.dmall.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class userTest {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Test
	public void testAddUser() {
		User user = new User();
		user.setPassword("130248cb");
		user.setPhone("15197546321");
		userMapper.addUser(user);
		System.out.println(userMapper.findUserByPhone(user.getPhone()));
		userMapper.deleteUserByPhone(user.getPhone());
	}
	
	@Test
	public void testUpdateUserEmail() {
		User user = userMapper.findUserByPhone("15197587253");
		String oldEmail = user.getEmail();
		System.out.println("未修改前的邮箱号："+oldEmail);
		user.setEmail("1136687924@qq.com");
		userMapper.updateUserEmail(user);
		System.out.println("修改之后的邮箱号："+userMapper.findUserByPhone("15197587253").getEmail());
		user.setEmail(oldEmail);
		userMapper.updateUserEmail(user);
	}
	
	@Test
	public void testUpdateUserPassword() {
		User user = userMapper.findUserByPhone("15197587253");
		System.out.println("未修改前的用户密码为："+user.getPassword());
		user.setPassword("130248");
		userMapper.updateUserPassword(user);
		System.out.println("修改之后的用户密码为："+userMapper.findUserByPhone("15197587253").getPassword());
	}
}
