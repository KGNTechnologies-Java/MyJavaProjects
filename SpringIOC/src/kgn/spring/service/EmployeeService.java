package kgn.spring.service;

import java.util.ArrayList;
import java.util.List;

import kgn.spring.bean.EmployeeBean;
import kgn.spring.dao.EmployeeDAOImpl;

public class EmployeeService {
	private EmployeeBean empBean;
	
	public EmployeeBean getEmpBean() {
		return empBean;
	}

	public void setEmpBean(EmployeeBean empBean) {
		this.empBean = empBean;
	}

	List list = new ArrayList();
	EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
	
	public List getEmployeeDetails(){
		list = empDAO.getEmployeeDetails();
		return list;
		
	}

}
