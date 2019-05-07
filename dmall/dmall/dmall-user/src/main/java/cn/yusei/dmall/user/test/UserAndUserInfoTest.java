package cn.yusei.dmall.user.test;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yusei.dmall.user.controller.UserControllerImpl;
import cn.yusei.dmall.user.dao.UserInfoMapper;
import cn.yusei.dmall.user.dao.UserMapper;
import cn.yusei.dmall.user.model.User;
import cn.yusei.dmall.user.model.UserInfo;
/**
 * 这个测试类测试了所有user模块的接口
 * @author 11366
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserAndUserInfoTest {

	@Autowired
	private UserControllerImpl controllerImpl;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	//测试注册
	@Test
	public void testRigister() {
		User user = new User();
		user.setPhone("15197582263");
		user.setPassword("130248cb");
		controllerImpl.register(user);
	}
	//测试往用户表插入数据
	@Test
	public void testUserInsert() {
		User user = new User();
		user.setPassword("130248cb");
		user.setPhone("13549577045");
		userMapper.addUser(user);
		userInfoMapper.addUserInfo(new UserInfo(new Date()));
	}
	//测试更新用户数据
	@Test
	public void testUserUpdate() {
		User user = userMapper.findUserById(12);
		System.out.println("修改前"+user);
//		user.setPassword("130248cb");
//		user.setPassword("130248cb");
		user.setEmail("123658@qq.com");
		userMapper.updateUserEmail(user);
		user=userMapper.findUserById(12);
		System.out.println("修改之后"+user);
	}
	//测试删除用户,为了保持一致，我直接user和userInfo一起删了
	@Test
	public void testUserDelete() {
//		userMapper.deleteUserById(16);
		userInfoMapper.deleteUserInfoById(16);
		
	}
}
