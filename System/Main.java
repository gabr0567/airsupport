package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Main extends Application {
	private static DataAccessLayer db;
	private static int currentPlane;
	private static String currentNavn;
	private static int currentTlf;
	private static String currentEmail;
	private static int currentCVR;
	private static String currentTil;
	private static Date currentDato;
	private static Time currentAfgang;
	private static int currentBilletID;
	
	@Override
	//Indlæs den første scene - Gabriel
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Gabriel
	public static void main(String[] args) {
		db = new DataAccessLayer("Airsupport");
		launch(args);
	}
	//Gabriel
	public static ResultSet getRS() {
		return db.getRS();
	}
	
	//Gabriel
	public static ResultSet getRS2() {
		return db.getRS2();
	}
	//Nilaksan //Rprodukter
	public static ResultSet getRS3() {
		return db.getRS3();
	}
	//Nilaksan // Produkter
	public static ResultSet getRS4() {
		return db.getRS4();
	}
	//Nilaksan //Tilkald
	public static ResultSet getRS5() {
		return db.getRS5();
	}
	//Nilaksan //Tilkald 2
	public static ResultSet getRS6() {
		return db.getRS6();
	}
	
	//Gabriel
	public static ResultSet getRS7() {
		return db.getRS7();
	}

	//Gabriel
  	public static void selectPlane(int id, String til, Date dato, Time afgang) {
      		currentPlane = id;
      		currentTil = til;
      		currentDato = dato;
      		currentAfgang = afgang;
  	}
    
   	//Gabriel
  	public static int currentPlane() {
      		return currentPlane;				
  	}
  	
  	//Gabriel
	public static String currentNavn() {
		return currentNavn;
	}
	
	//Gabriel
	public static void selectCustomer(String navn, String tlf, String email, int CVR) {
		currentNavn = navn;
		currentTlf = Integer.parseInt(tlf);
		currentEmail = email;
		currentCVR = CVR;
	}
	
	//Gabriel
	public static void insertBillet(ObservableList<Rprodukter> oblistprod) {
		Random rand = new Random();
		currentBilletID = rand.nextInt(999999999);
		
		db.executeInsertBillet(currentBilletID, 
				currentNavn, currentTil, currentPlane, 
				currentDato, currentAfgang, currentTlf, 
				currentEmail, currentCVR);
		
		for (int i = 0; i < oblistprod.size(); i++) {
			db.executeInsertNuvProdukter(rand.nextInt(999999999),
					oblistprod.get(i).getNavn().get(),
					oblistprod.get(i).getProd(),
					currentBilletID,
					Float.parseFloat(oblistprod.get(i).getPris().get()),
					Integer.parseInt(oblistprod.get(i).getAntal().get()));
		}
		
		db.executePlaneFalse(currentPlane, currentTil);
	}
	//Gabriel
	public static void disableProd(int ID) {
		db.disableProd(ID);
	}
	//Gabriel
	public static void updatePrice(int ID, float price) {
		db.updatePrice(ID, price);
	}
	//Gabriel
	public static void newProduct(String name, float price) {
		Random rand = new Random();
		db.newProduct(rand.nextInt(999999999), name, price);
	}
	//Gabriel
	public static void tilkald(int ID) {
		db.tilkald(ID);
	}
	//Gabriel
	public static void send(int flyID, String airport) {
		db.send(flyID, airport);
	}
	//Gabriel
	public static void setCurrentBillet(int ID) {
		currentBilletID = ID;
	}
	//Gabriel
	public static void updateBillet(ObservableList<Rprodukter> oblistprod) {
		Random rand = new Random();
		for (int i = 0; i < oblistprod.size(); i++) {
			db.executeInsertNuvProdukter(rand.nextInt(999999999),
					oblistprod.get(i).getNavn().get(),
					oblistprod.get(i).getProd(),
					currentBilletID,
					Float.parseFloat(oblistprod.get(i).getPris().get()),
					Integer.parseInt(oblistprod.get(i).getAntal().get()));
		}
		db.endtBillet(currentBilletID);
	}
	//Gabriel
	public static void createCSV() {
		try {
			String home = System.getProperty("user.home");
			PrintWriter pw = new PrintWriter(new File(home + "\\Downloads\\tabel2.csv"));
			StringBuilder sb = new StringBuilder();
			ResultSet rs = db.getRS8();
			
			sb.append("ID, Navn, Pris, Antal\r\n");
			
			try {
				while(rs.next()) {
					sb.append(String.valueOf(rs.getInt("BilletID")) + ", " + 
							rs.getString("Navn") + ", " + 
							String.valueOf(rs.getFloat("Pris")) + ", " + 
							String.valueOf(rs.getInt("Antal")) + "\r\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			pw.write(sb.toString());
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}