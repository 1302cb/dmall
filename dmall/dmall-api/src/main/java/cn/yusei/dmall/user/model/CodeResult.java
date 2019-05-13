package cn.yusei.dmall.user.model;

import java.io.Serializable;

/**
 * 这就就是一个简单的返回信息的类
 * @author 11366
 *
 */
public class CodeResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	//成功返回码
	public final static String  SUCCESS = "0";
	//登录失败
	public final static String LOGIN_ERROR = "1";
	//注册失败
	public final static String REGISTER_ERROR = "2";
	//电话验证失败
	public final static String PHONE_MATCH_ERROR = "3";
	//优秀验证失败
	public final static String EMAIL_MATCH_ERROR = "4";
	
	public CodeResult(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getSuccess() {
		return SUCCESS;
	}

	public static String getLoginError() {
		return LOGIN_ERROR;
	}

	public static String getRegisterError() {
		return REGISTER_ERROR;
	}

	public static String getPhoneMatchError() {
		return PHONE_MATCH_ERROR;
	}

	public static String getEmailMatchError() {
		return EMAIL_MATCH_ERROR;
	}
	
}
