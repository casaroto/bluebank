package br.com.bluebank.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/bluebank?user=blue&password=6945";
	
	static{
        try {
            Class.forName(DRIVER_NAME).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
    public DataSource() {

    }
    
    public Connection obterConexao(){
    Connection conn = null;
    
	    try {
	        conn = DriverManager.getConnection(CONNECTION_URL);
	    } catch (SQLException ex) {
	    	 ex.printStackTrace();
	    	 System.out.println("SQLException: " + ex.getMessage());
	    }	
	    
	    return	conn;
    }

}
