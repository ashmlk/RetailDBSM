package dbsm;
import java.sql.*;

import javax.swing.JOptionPane;

public class oracleConnection {	
	Connection con = null;
	
	public static Connection dbConnector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return con;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
