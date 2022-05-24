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
	
	@Override
	
	//Indl�s den f�rste scene - Gabriel
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
	
	//Gabriel
	public static void selectPlane(int id) {
		currentPlane = id;
	}
	
	//Gabriel
	public static int currentPlane() {
		return currentPlane;
	}
}
	