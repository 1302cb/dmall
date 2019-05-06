package cn.yusei.dmall.user.model;

import java.io.Serializable;

/**
 * @author
 * 用户账号信息
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String password;
	private String phone;
	private String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String password, String phone, String email) {
		super();
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", phone=" + phone + ", email=" + email + "]";
	}
	
	

}
