package cn.yusei.dmall.user.dao;
/**
 * @author 11366
 */
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.yusei.dmall.user.model.UserInfo;

@Mapper
@Repository
public interface UserInfoMapper {

	//根据id查找对应的用户信息
	@Select("select * from userInfo where id=#{id}")
	UserInfo findUserInfoById(int id);
	
	//插入用户信息
	@Insert("insert into userInfo(nickname,create_time) values(#{nickname},#{create_time,jdbcType=DATE})")
	void addUserInfo(UserInfo userInfo);
	
	//更改用户信息,只能改昵称，时间不能改
	@Update("update userInfo set nickname=#{nickname} where id=#{id}")
	void updateUserInfo(UserInfo userInfo);
	
	@Select("select * from userInfo where nickname=#{nickname}")
	UserInfo findUserInfoByNickname(String nickname);
	
	//删除用户信息，一般这一步都是紧跟在删除用户后面的
	@Delete("DELETE FROM userinfo WHERE id=#{id}")
	void deleteUserInfoById(int id);
}
