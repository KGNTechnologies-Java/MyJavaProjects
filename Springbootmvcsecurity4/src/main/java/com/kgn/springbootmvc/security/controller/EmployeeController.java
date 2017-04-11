package com.kgn.springbootmvc.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@RequestMapping("/")
	public String message(){
		return "custom security";
	}
	
	@RequestMapping("/user")
	public String messages(){
		return "custom security users";
	}
	
	@RequestMapping("/admin")
	public String messageadm(){
		return "custom security admin";
	}
}
