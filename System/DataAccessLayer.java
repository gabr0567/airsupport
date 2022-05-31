package application;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataAccessLayer {
	private Connection connection;
	//Gabriel
	public DataAccessLayer(String databaseName) {
		loadJdbcDriver();
		openConnection(databaseName);
	}
	
	//Gabriel
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
	//Gabriel
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
  
//Gabriel
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
  //Gabriel
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
  	
  //Gabriel
	public ResultSet getRS() {
		ResultSet rs;
		try {
			rs = connection.createStatement().executeQuery("SELECT * FROM Fly");
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	  //Gabriel
		public ResultSet getRS2() {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM Billet");
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
		//Nilaksan
		public ResultSet getRS3() {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM Tillægsprodukter");
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
		public ResultSet getRS4() {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM Tillægsprodukter");
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
		//Tilkald
		public ResultSet getRS5() {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM Fly");
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
		//Tilkald 2
		public ResultSet getRS6() {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM Fly");
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
		
		//Gabriel
		public ResultSet getRS8() {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM NuværendeTillægsprodukter");
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
		
		//Gabriel
		public boolean executeInsertBillet(int billetID, 
				String currentNavn, String currentTil, int currentPlane, 
				Date currentDato, Time currentAfgang, int currentTlf, 
				String currentEmail, int currentCVR) {
	  		int id = executeInsert("INSERT INTO Billet VALUES (" +
	  		billetID + ", '" +
			currentNavn + "', '" +
			currentTil + "', " +
			currentPlane + ", '" +
			currentDato + "', '" +
			currentAfgang + "', '" +
			currentTlf + "', '" +
			currentEmail + "', " + 
			currentCVR + ", 0)");
	  		return (id != 0);
		}
		
		//Gabriel
		public ResultSet getRS7() {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM Destination");
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
		
		//Gabriel
		public boolean executeInsertNuvProdukter(int ID, String Navn, int prod, int billetID, float pris, int antal) {
	  		int id = executeInsert("INSERT INTO NuværendeTillægsprodukter VALUES (" +
	  		ID + ", '" +
			Navn + "', " +
			prod + ", " +
			billetID + ", " +
			pris + ", " +
			antal + ")");
	  		return (id != 0);
		}
		
		//Gabriel
		public boolean executePlaneFalse(int currentPlane, String currentTil) {
			boolean id = executeUpdate("UPDATE Fly SET Status = 0, Placering = '" + currentTil + "' WHERE FlyID = " + currentPlane);
			return (id);
		}
		
		//Gabriel
		public boolean disableProd(int ID) {
			boolean id = executeUpdate("UPDATE Tillægsprodukter SET Aktiv = 0 WHERE TillægsproduktID = " + ID);
			return (id);
		}
		
		//Gabriel
		public boolean updatePrice(int ID, float price) {
			boolean id = executeUpdate("UPDATE Tillægsprodukter SET Pris = " + price +" WHERE TillægsproduktID = " + ID);
			return (id);
		}
		//Gabriel
		public boolean newProduct(int ID, String name, float price) {
			int id = executeInsert("INSERT INTO Tillægsprodukter VALUES (" + ID + ", " + price + ", '" + name + "', 1, 1)");
			return (id != 0);
		}
		//Gabriel
		public boolean tilkald(int ID) {
			boolean id = executeUpdate("UPDATE Fly SET Placering = 'BLL', Status = 1 WHERE FlyID = " + ID);
			return (id);
		}
		//Gabriel
		public boolean send(int flyID, String airport) {
			boolean id = executeUpdate("UPDATE Fly SET Placering = '" + airport + "', Status = 0 WHERE FlyID = " + flyID);
			return (id);
		}

		public boolean endtBillet(int currentBilletID) {
			boolean id = executeUpdate("UPDATE Billet SET Endt = 1 WHERE BilletID = " + currentBilletID);
			return (id);
		}

		public ResultSet getRS9(int ID) {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM NuværendeTillægsprodukter WHERE BilletID = " + ID);
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}

		public ResultSet getRS10(int ID) {
			ResultSet rs;
			try {
				rs = connection.createStatement().executeQuery("SELECT * FROM Billet WHERE BilletID = " + ID);
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
		}
}