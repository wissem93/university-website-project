package metier;

import java.sql.DriverManager;

import com.sun.corba.se.pept.transport.Connection;

public class SingletonConnection {

	private static java.sql.Connection connection;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myecole","root","");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static java.sql.Connection getConnection() {
		return connection;
	}
	public static void setConnection(java.sql.Connection connection) {
		SingletonConnection.connection = connection;
	}
	
	
}
