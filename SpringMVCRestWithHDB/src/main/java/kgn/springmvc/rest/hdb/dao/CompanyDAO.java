package kgn.springmvc.rest.hdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kgn.springmvc.rest.hdb.bean.Company;

public class CompanyDAO {
	 private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	CompanyDAO(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	
	public List<Company> getAllCompanies() throws SQLException{
		List<Company> companies = new ArrayList<Company>();
		Connection con = dataSource.getConnection();
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery("select * from Company");
			while(rs.next()){
				Company c = new Company();
				c.setCompanyId(rs.getString(1));
				c.setCompanyName(rs.getString(2));
			//	c.setAddress(rs.getString(3));
				companies.add(c);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		con.close();
		return companies;
		
	}
	
	public int saveCompany(Company comp) throws Exception{
		int status = 0;
		Connection con = dataSource.getConnection();
		try{
			    PreparedStatement ps=con.prepareStatement("insert into Company values(?,?)");  
	            ps.setString(1,comp.getCompanyId().toString());  
	            ps.setString(2,comp.getCompanyName().toString());               
	            status=ps.executeUpdate();  	           			
			
		}catch(Exception ex){
			return 2;
		}
		
		con.close();
		return status;
	}

	 
}
