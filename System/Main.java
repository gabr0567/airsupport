package application;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Main extends Application {
	private static DataAccessLayer db;
	private static int currentPlane;
	private static String currentNavn;
	private static String currentTlf;
	private static String currentEmail;
	private static String currentCVR;
	
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
  	public static void selectPlane(int id) {
      		currentPlane = id;
  	}
    
   	 //Gabriel
  	public static int currentPlane() {
      		return currentPlane;
  	}

	
	public static String currentNavn() {
		return currentNavn;
	}
	
	public static void selectCustomer(String navn, String tlf, String email, String CVR) {
		currentNavn = navn;
		currentTlf = tlf;
		currentEmail = email;
		currentCVR = CVR;
	}
}

	
