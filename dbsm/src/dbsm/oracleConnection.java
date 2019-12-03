package dbsm;
import java.sql.*;

import javax.swing.JOptionPane;

public class oracleConnection {	
	Connection con = null;
	
	public static Connection dbConnector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection( "jdbc:oracle:thin:url:1521:orcl","user","password");
			return con;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please check your connection and try again");
			return null;
		}
	}
}
