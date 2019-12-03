package dbsm;
import java.sql.*;

import javax.swing.JOptionPane;

public class oracleConnection {	
	Connection con = null;
	
	public static Connection dbConnector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","h2kazi","11295798");
			return con;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please check your connection and try again");
			return null;
		}
	}
}
