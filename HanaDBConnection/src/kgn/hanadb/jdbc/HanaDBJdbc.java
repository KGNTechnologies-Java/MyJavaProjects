package kgn.hanadb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class HanaDBJdbc {
	
	static final String JdbcDriver = "com.sap.db.jdbc.Driver";
    static final String DbUrl = "jdbc:sap://localhost:30215/";
    static final String User = "c5251932DB";
    static final String Pwd = "PaSsw0rd";

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int status = 0;
		try{
			System.out.println("Inside try");
			Class.forName(JdbcDriver);
			con = DriverManager.getConnection(DbUrl, User, Pwd);
			stmt = con.createStatement();
			pstmt=con.prepareStatement("insert into Company values(?,?)");  
            pstmt.setString(1,"5");  
            pstmt.setString(2,"Infosys");               
            status=pstmt.executeUpdate(); 
			ResultSet rs = (ResultSet) stmt.executeQuery("select * from Company");
			while(rs.next()){
				System.out.println(rs.getString(1)+" == "+rs.getString(2));
			}
			
		}catch(Exception ex){
			System.out.println("HanaDBConnection ==> "+ex.getMessage());
		}finally{
			if(stmt != null){
				stmt.close();
			} 
			if(con !=null){
				con.close();
			}
		}

	}

}
