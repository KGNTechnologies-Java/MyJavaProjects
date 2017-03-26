package kgn.springmvc.rest.hdb.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kgn.springmvc.rest.hdb.bean.Company;
import kgn.springmvc.rest.hdb.dao.CompanyDAO;

@RestController
public class CompanyController {
	
	@RequestMapping(value = "/companies", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Company> getAllCompanies(){
		List<Company> companies = new ArrayList<Company>();
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationcontext.xml");
		CompanyDAO dao = (CompanyDAO)context.getBean("companyDAO");
		try {
			companies = dao.getAllCompanies();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companies;
		
	}
		
	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET,headers="Accept=application/json")
	public Company getCompanyById(@PathVariable int companyId){
		Company comp = new Company();
		
		return comp;
		
	}
	
	@RequestMapping(value = "/saveCompany", method = RequestMethod.POST,headers="Accept=application/json")
	public int saveCompany(@RequestBody Company comp) throws Exception{
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationcontext.xml");
		CompanyDAO dao = (CompanyDAO)context.getBean("companyDAO");
		int status = dao.saveCompany(comp);
		
		return status;
	}

}
