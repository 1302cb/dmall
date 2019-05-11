package cn.yusei.dmall.user.utils;

public class MyUtils {

	//判断手机号，网上抄的，亲测可用
	public static boolean isPhoneNumber(String phone) {
		if(phone==null||"".equals(phone)==true) {
			return false;
		}
		return phone.matches("^(\\+86|86)?1((3[0-9])|(4[5|7])|(5([0-3]|[5-9]))|(8[0,5-9]))\\d{8}$");
	}
	
	//判断邮箱号，也是网上抄的
	public static boolean isEmail(String email) {
		if(email==null||"".equals(email)) {
			return false;
		}
		return email.matches("^[\\w-]+@[\\w-]+(\\.[\\w-]+)+$");
	}
	
	
	//测试代码，不信你自己试试
	/*public static void main(String[] args) {
		System.out.println(MyUtils.isPhoneNumber("15197587253"));
		System.out.println(MyUtils.isPhoneNumber("12345678910"));
		System.out.println(MyUtils.isEmail("1136637927@qq.com"));
		System.out.println(MyUtils.isEmail("1dfa23@"));
	}*/
}
