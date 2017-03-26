package kgn.servlet.com;

public class LoginDAO {
	
	public boolean loginDetails(String usrid, String pass){
		if("naga".equals(usrid) && "naga".equalsIgnoreCase(pass)){
			return true;
			
		}
		return false;
	}

}
