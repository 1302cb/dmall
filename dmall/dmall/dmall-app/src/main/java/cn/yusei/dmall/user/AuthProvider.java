package cn.yusei.dmall.user;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Component;

import cn.yusei.dmall.user.service.UserService;

@Component
public class AuthProvider extends DaoAuthenticationProvider {
	
	public AuthProvider(UserService service) {
		setUserDetailsService(service);
	}
	
}
