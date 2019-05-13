package cn.yusei.dmall.user.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.yusei.dmall.user.model.User;

@Mapper
@Repository
public interface UserMapper {

	// 插入到用户表，并且将密码md5
	@Insert("insert into user(password,email,phone) values(md5(#{password}),#{email},#{phone})")
	void addUser(User user);

	//通过id查询用户
	@Select("select * from user where id=#{id}")
	User findUserById(int id);

	//根据email来查询用户，了解到username就是email和phone，所以分开两个来写
	@Select("select * from user where email=#{email}")
	User findUserByEmail(String email);
	
	@Select("select * from user where phone=#{phone}")
	User findUserByPhone(String phone);
	
	
	//用户更新email,,我直接一个user参数打包了，感觉用email和id作为参数好low啊，就是low
	@Update("update user set email=#{email} where id=#{id}")
	void updateUserEmail(User user);
	
	
	//用户更新密码
	@Update("update user set password=md5(#{password})")
	void updateUserPassword(User user);
	
	
	//删除用户，这个一般是自己注销账号，或者管理员有的权限
	@Delete("DELETE FROM USER WHERE id=#{id}")
	void deleteUserById(int id);
}
