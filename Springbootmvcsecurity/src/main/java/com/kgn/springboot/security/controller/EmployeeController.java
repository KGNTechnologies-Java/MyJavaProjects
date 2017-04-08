/**
 * 
 */
package com.kgn.springboot.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nagaraju Kotta
 *
 */

@RestController
public class EmployeeController {
	@RequestMapping("/")
	public String hellowMessage(){
		return "Welcome employee";
	}

}
