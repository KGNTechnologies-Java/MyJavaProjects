package kgn.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kgn.spring.service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {
		List list = new ArrayList();
		ApplicationContext context = new ClassPathXmlApplicationContext("/kgn/spring/resource/applicationContext.xml");
		EmployeeService es = (EmployeeService)context.getBean("empService");
		//list = es.getEmployeeDetails();
		System.out.println(list);
		System.out.println(es.getEmpBean().getEmpName());
	}

}
