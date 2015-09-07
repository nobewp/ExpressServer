package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("HelloController")
public class HelloController
{
	//http://localhost:8080/MyServer/HelloController/hello.json
	// value： 指定请求的实际地址；
	// method： 指定请求的method类型， GET、POST、PUT、DELETE等；
	@RequestMapping(value = "/hello.json", method = RequestMethod.GET)
	@ResponseBody
	public Object hello()
	{
		return "Hello word";
	}
}
