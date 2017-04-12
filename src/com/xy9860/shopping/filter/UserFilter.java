package com.xy9860.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest reuest, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)reuest;
		if(req.getSession().getAttribute("users")==null){
			//非法请求,自动跳到用户登陆界面
			req.setAttribute("error","你还没有登录,请登录");
			req.getSession().setAttribute("goUrl", req.getRequestURI()+"?"+req.getQueryString());
			req.getRequestDispatcher("/ulogin.jsp").forward(reuest, response);
		}else{
			filter.doFilter(reuest, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
