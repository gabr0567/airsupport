package application;

import java.sql.Date;
import java.sql.Timestamp;

import java.io.IOException;
import java.sql.ResultSet;

import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SceneController {
	
	@FXML
	private TableView<Fly> table_fly;
	@FXML
	private TableColumn<Fly,String> col_flynr;
	@FXML
	private TableColumn<Fly,String> col_flynavn;
	@FXML
	private TableColumn<Fly,String> col_flypladser;
	@FXML
	private TableColumn<Fly,String> col_flystatus;
	
	@FXML
	private TableView<Billetter> table_billetter;
	@FXML
	private TableColumn<Billetter,String> col_billetID;
	@FXML
	private TableColumn<Billetter,String> col_navn;
	
	
	private Stage stage;
	private Scene scene;
	
	//Skift til scenen "fly.fxml" - Gabriel
	public void switchToFly(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("fly.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "billetter.fxml" - Gabriel
	public void switchToBilletter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("billetter.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "menu.fxml" - Gabriel
	public void switchToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "nybillet.fxml" - Gabriel
	public void switchToNyBillet(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("nybillet.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "produkter.fxml" - Gabriel
	public void switchToProdukter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("produkter.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Skift til scenen "produkter.fxml" - Gabriel
	public void switchToRprodukter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Rprodukter.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//Indlæs de forskellige fly - Gabriel
	public void loadFly(ActionEvent event)	{
		ObservableList<Fly> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs = Main.getRS();
			
			while(rs.next()) {
				if (rs.getBoolean("status") == true) {
					oblist.add(new Fly(rs.getInt("FlyID"),rs.getString("navn"),rs.getInt("pladser"),rs.getBoolean("status")));
				}
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_flynr.setCellValueFactory(cellData -> cellData.getValue().getId());
		col_flynavn.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_flypladser.setCellValueFactory(cellData -> cellData.getValue().getPladser());
		col_flystatus.setCellValueFactory(cellData -> cellData.getValue().getStatus());

		table_fly.setItems(oblist);
	}
	
	public void loadBilletter(ActionEvent event) {
		ObservableList<Billetter> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs2 = Main.getRS2();
			
			while(rs2.next()) {
				oblist.add(new Billetter(rs2.getInt("BilletID"), 
						rs2.getInt("KundeID"), 
						rs2.getString("Navn"), 
						rs2.getString("Til"), 
						rs2.getInt("Fly"), 
						rs2.getDate("Dato"), 
						rs2.getInt("Sæde"), 
						rs2.getString("Gate"), 
						rs2.getTimestamp("afgang")));
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_billetID.setCellValueFactory(cellData -> cellData.getValue().getBilletID());
		col_navn.setCellValueFactory(cellData -> cellData.getValue().getNavn());

		table_billetter.setItems(oblist);
	}
}