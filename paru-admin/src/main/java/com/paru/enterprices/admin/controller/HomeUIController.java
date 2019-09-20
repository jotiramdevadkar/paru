package com.paru.enterprices.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeUIController {
	
	@RequestMapping("/")
	public String home(){
//		System.out.println("@@@@@@@@@@@@@@@@@@@ User " + UserUtil.getLoggedInUser());
		return "index";
	}
}
