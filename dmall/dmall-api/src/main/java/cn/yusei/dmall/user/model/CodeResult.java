package cn.yusei.dmall.user.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * 这就就是一个简单的返回信息的类,还有一个根据状态码返回json字符串的静态方法
 * @author 11366
 *
 */
public class CodeResult implements Serializable{

	private static final long serialVersionUID = 1L;
	private String code;
	
	//为空状态码
	public final static String EMPLEMENT_NULL = "-1";
	//成功返回码
	public final static String  SUCCESS = "0";
	//登录失败
	public final static String LOGIN_ERROR = "1";
	//注册失败
	public final static String REGISTER_ERROR = "2";
	//电话验证失败
	public final static String PHONE_MATCH_ERROR = "3";
	//邮箱验证失败
	public final static String EMAIL_MATCH_ERROR = "4";
	//密码更新失败
	public final static String PASSWORD_UPDATE_ERROR="5";
	//邮箱更新失败
	public final static String EMAIL_UPDATE_ERROR="6";
	//用户昵称更新失败
	public final static String NICKNAME_UPDATE_ERROR="7";
	
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

	public static String getJsonCode(String jsonCode) {
		JSONObject object = (JSONObject) JSONObject.toJSON(new CodeResult(jsonCode));
		return object.toJSONString();
	}
}
