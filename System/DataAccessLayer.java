package application;
import java.sql.*;

public class DataAccessLayer {
	private Connection connection;

	public DataAccessLayer(String databaseName) {
		loadJdbcDriver();
		openConnection(databaseName);
	}
  
	private boolean loadJdbcDriver() {
		try {
			System.out.println("Loading JDBC driver...");
      
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      
			System.out.println("JDBC driver loaded");
      
			return true;
		}
		catch (ClassNotFoundException e) {
			System.out.println("Could not load JDBC driver!");
			return false;
		}
	}
  
  private boolean openConnection(String databaseName) {
	  String connectionString =
			  "jdbc:sqlserver://localhost:1433;" +
					  "instanceName=SQLEXPRESS;" +
					  "databaseName=" + databaseName + ";" +
					  "integratedSecurity=true;";
    
	  try {
		  System.out.println("Connecting to database...");
      
		  connection = DriverManager.getConnection(connectionString);
      
		  System.out.println("Connected to database");
      
		  return true;
	  }
	  catch (SQLException e) {
		  connection = null;

		  System.out.println("Could not connect to database!");
		  System.out.println(e.getMessage());
      
		  return false;
	  }
  	}
  
  	public boolean executeUpdate(String sql) {
  		try {
  			System.out.println(sql);
  			Statement statement = connection.createStatement();
  			int affectedRows = statement.executeUpdate(sql);
  			return (affectedRows == 1);
  		}
  		catch (SQLException e) {
  			System.out.println("executeUpdate(): Error");
  			e.printStackTrace();
  			return false;
	    }
  	}

  	public int executeInsert(String sql) {
  		try {
  			System.out.println(sql);
  			Statement statement = connection.createStatement();
  			int affectedRows = statement.executeUpdate(sql);
  			if (affectedRows == 1) {
  				ResultSet resultSet = statement.executeQuery("SELECT SCOPE_IDENTITY()");
  				if (resultSet.next())
  					return resultSet.getInt(1);
  			}
	      
  			return 0;
  		}
  		catch (SQLException e) {
  			System.out.println("executeInsert(): Error");
  			e.printStackTrace();
  			return 0;
  		}
  	}
}