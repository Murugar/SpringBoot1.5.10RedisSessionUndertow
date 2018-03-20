package com.iqmsoft.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping(value="/getSessionId")
	@ResponseBody
	public String getSessionId(HttpServletRequest request){
		
		Object o = request.getSession().getAttribute("springboot");
		if(o == null){
			o = "spring boot " + request.getLocalPort();
			request.getSession().setAttribute("springboot", o);
		}
		
		return request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
	}
	
}
