package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class TestController implements org.springframework.web.servlet.mvc.Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		// TODO Auto-generated method stub
//		http://localhost:8080/MyServer/test
		ModelAndView modelAndView = new ModelAndView();
		// 存值
		modelAndView.addObject("testMessage", "hi,第一个SpringMvc程序！");
		// 设置跳转的页面(视图：View)
		modelAndView.setViewName("WEB-INF/helloworld");
		return modelAndView;
	}

}