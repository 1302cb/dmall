package cn.yusei.dmall.user.utils;
/**
 * 
 * @author 11366
 *
 */
public class MatchEmailAndPhoneUtil {

	//判断手机号
	public static boolean isPhoneNumber(String phone) {
		if(phone==null||"".equals(phone)==true) {
			return false;
		}
		return phone.matches("^(\\+86|86)?1((3[0-9])|(4[5|7])|(5([0-3]|[5-9]))|(8[0,5-9]))\\d{8}$");
	}
	
	//判断邮箱号
	public static boolean isEmail(String email) {
		if(email==null||"".equals(email)) {
			return false;
		}
		return email.matches("^[\\w-]+@[\\w-]+(\\.[\\w-]+)+$");
	}
}
