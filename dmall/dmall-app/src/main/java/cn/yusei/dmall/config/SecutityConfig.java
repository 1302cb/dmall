package cn.yusei.dmall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cn.yusei.dmall.user.AuthProvider;
import cn.yusei.dmall.user.service.UserService;

@Component
public class SecutityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserService service;
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Override
	//为了测试方便我开放了很多接口，到时候记得删除
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/user/login","/user/register","/user/update/email","/user/update/password","/user/update/nickname").permitAll()
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginProcessingUrl("/user/login")
				.successHandler(successHandler)
				.failureHandler(authenticationFailureHandler);
		
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.authenticationProvider(new AuthProvider(service));
	}

}