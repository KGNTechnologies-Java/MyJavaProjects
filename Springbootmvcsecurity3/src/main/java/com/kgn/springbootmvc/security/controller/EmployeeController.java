package com.kgn.springbootmvc.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping("/")
	public String message(){
		return "employee login security";
	}
}
