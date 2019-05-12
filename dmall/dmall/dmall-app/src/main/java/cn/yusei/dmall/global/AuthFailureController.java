package cn.yusei.dmall.global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class AuthFailureController implements AuthenticationFailureHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	//失败的界面
	@Autowired
	private ObjectMapper objectMapper;
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		//TODO 根据错误类型（exception.getMessage())，返回对应错误码
		logger.info("登录失败");

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(exception.getMessage()));
	}

}
