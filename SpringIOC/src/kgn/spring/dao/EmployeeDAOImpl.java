package kgn.spring.dao;

import java.util.ArrayList;
import java.util.List;

import kgn.spring.bean.EmployeeBean;

public class EmployeeDAOImpl {
	List list = new ArrayList();
	EmployeeBean eb = new EmployeeBean();
	public List getEmployeeDetails(){
		System.out.println(eb.getEmpName());
		list.add(eb.getEmpNo());
		list.add(eb.getEmpName());
		
		return list;
	}

}
