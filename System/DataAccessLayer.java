package application;
import java.sql.*;
import java.text.SimpleDateFormat;
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
				Date currentDato, Date currentDato2, Time currentAfgang, Time currentAfgang2, String currentTlf, 
				String currentEmail, int currentCVR, float currentBilletPris)  {
			String insert = "INSERT INTO Billet(BilletID, Navn, Til, Fly, Dato, Dato2, afgang, Afgang2, tlf, Email, CVR, Endt, billetPris) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(insert);
				
				ps.setInt(1, billetID);
				ps.setString(2, currentNavn);
				ps.setString(3, currentTil);
				ps.setInt(4, currentPlane);
				ps.setDate(5, currentDato);
				ps.setDate(6, currentDato2);
				ps.setTime(7, currentAfgang);
				ps.setTime(8, currentAfgang2);
				ps.setString(9, currentTlf);
				ps.setString(10, currentEmail);
				ps.setInt(11, currentCVR);
				ps.setInt(12, 0);
				ps.setFloat(13, currentBilletPris);
					
				ps.executeQuery();
				
				return true;
			} catch (SQLException e) {
				return false;
			}
		}

		//Gabriel
		public ResultSet getRS7() throws SQLException {
			ResultSet rs;
			
			rs = connection.createStatement().executeQuery("SELECT * FROM Destination");
			return rs;

		}
		
		//Gabriel
		public boolean executeInsertNuvProdukter(int ID, String Navn, int prod, int billetID, float pris, int antal) {
			String insert = "INSERT INTO NuværendeTillægsprodukter(NTID, Navn, tillægsprodukt, BilletID, Pris, Antal) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(insert);
				
				ps.setInt(1, ID);
				ps.setString(2, Navn);
				ps.setInt(3, prod);
				ps.setInt(4, billetID);
				ps.setFloat(5, pris);
				ps.setInt(6, antal);
					
				ps.executeQuery();
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		
		//Gabriel
		public boolean executePlaneFalse(int currentPlane, String currentTil) {
			String update = "UPDATE Fly SET Status = 0, Placering = ? WHERE FlyID = ?";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(update);
				
				ps.setString(1, currentTil);
				ps.setInt(2, currentPlane);
					
				ps.executeQuery();
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		
		//Gabriel
		public boolean disableProd(int ID) {
			String update = "UPDATE Tillægsprodukter SET Aktiv = 0 WHERE TillægsproduktID = ?";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(update);
				
				ps.setInt(1, ID);
				
				ps.executeQuery();
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		
		//Gabriel
		public boolean updatePrice(int ID, float price) {
			String update = "UPDATE Tillægsprodukter SET Pris = ? WHERE TillægsproduktID = ?";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(update);
				
				ps.setFloat(1, price);
				ps.setInt(2, ID);
				
				ps.executeQuery();
				
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		//Gabriel
		public boolean newProduct(int ID, String name, float price) {
			String insert = "INSERT INTO Tillægsprodukter(TillægsproduktID, Pris, Navn, Aktiv) VALUES (?,?,?,1)";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(insert);
				
				ps.setInt(1, ID);
				ps.setFloat(2, price);
				ps.setString(3, name);
				
				ps.executeQuery();
				
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		//Gabriel
		public boolean tilkald(int ID) {
			String update = "UPDATE Fly SET Placering = 'BLL', Status = 1 WHERE FlyID = ?";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(update);
				
				ps.setInt(1, ID);
				
				ps.executeQuery();
				
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		//Gabriel
		public boolean send(int flyID, String airport) {
			String update = "UPDATE Fly SET Placering = ?, Status = 0 WHERE FlyID = ?";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(update);
				
				ps.setString(1, airport);
				ps.setInt(2, flyID);
				
				ps.executeQuery();
			
				return true;
			} catch (SQLException e) {
				return false;
			}
		}

		public boolean endtBillet(int currentBilletID) {
			String update = "UPDATE Billet SET Endt = 1 WHERE BilletID = ?";
			
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(update);
				
				ps.setInt(1, currentBilletID);
				
				ps.executeQuery();
				
				return true;
			} catch (SQLException e) {
				return false;
			}
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