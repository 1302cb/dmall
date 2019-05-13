package cn.yusei.dmall.global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.zookeeper.KeeperException.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.yusei.dmall.user.model.CodeResult;
@Controller
public class AuthSuccessController implements AuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	//成功的界面
	@Autowired
	private ObjectMapper objectMapper;
	private CodeResult code = new CodeResult("0");
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//TODO 返回登录成功码
		logger.info("登录成功");
		response.setContentType("application/json;charset=UTF-8");
//		response.getWriter().write(objectMapper.writeValueAsString(authentication));
//		code.setCode("1");
		response.getWriter().write(objectMapper.writeValueAsString(code));
	}

}
