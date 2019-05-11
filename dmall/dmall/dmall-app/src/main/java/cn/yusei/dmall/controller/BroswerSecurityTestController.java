package cn.yusei.dmall.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用于测试，正式可删
 * @author 11366
 *
 */
@Controller
public class BroswerSecurityTestController {
	
	/*private Logger logger = LoggerFactory.getLogger(getClass());
	
	//浏览器换缓存对象
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	//重定向策略
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
	@RequestMapping("/user/login")
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public String requireAuthentication(HttpServletRequest request,HttpServletResponse response) {
		
		SavedRequest savedRequest =requestCache.getRequest(request, response);
		if(savedRequest !=null ) {
			String targetUrl = savedRequest.getRedirectUrl();
			logger.info("引发跳转的url请求是："+targetUrl);
			if(org.springframework.util.StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/login.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		return "hello";
	}*/
}
