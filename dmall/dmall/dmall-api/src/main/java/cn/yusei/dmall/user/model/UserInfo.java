package cn.yusei.dmall.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 
 * 用户信息
 *
 */
public class UserInfo implements Serializable{
	
	//TODO 增加属性和 getter setter
	private int id;
	private String nickname;
	private Date create_time;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(Date create_time) {
		super();
		this.create_time = create_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", nickname=" + nickname + ", create_time=" + create_time + "]";
	}
	
	
}
