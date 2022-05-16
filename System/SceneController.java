package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.scene.Node;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage;
	private Scene scene;
	
	//Skift til scenen "fly.fxml"
	public void switchToFly(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("fly.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "billetter.fxml"
	public void switchToBilletter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("billetter.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "menu.fxml"
	public void switchToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "nybillet.fxml"
	public void switchToNyBillet(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("nybillet.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "produkter.fxml"
	public void switchToProdukter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("produkter.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "produkter.fxml"
	public void switchToRprodukter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Rprodukter.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}