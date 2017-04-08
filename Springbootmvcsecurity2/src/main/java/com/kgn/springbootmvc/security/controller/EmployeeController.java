/**
 * 
 */
package com.kgn.springbootmvc.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NagarajuKotta
 *
 */

@RestController
public class EmployeeController {
	
	@RequestMapping("/hellow")
	public String message(){
		return "welcome to springbootmvc2application with embedded tomcat server and SpringBootServletInitializer";
	}

}
