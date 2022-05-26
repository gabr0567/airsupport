package application;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Time;

import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneController {
	ObservableList<Rprodukter> oblistprod = FXCollections.observableArrayList();
	
	//Tabel fly
	@FXML
	private TableView<Fly> table_fly;
	@FXML
	private TableColumn<Fly,String> col_flynr;
	@FXML
	private TableColumn<Fly,String> col_flynavn;
	@FXML
	private TableColumn<Fly,String> col_flypladser;
	
	//Tabel billetter
	@FXML
	private TableView<Billetter> table_billetter;
	@FXML
	private TableColumn<Billetter,String> col_billetID;
	@FXML
	private TableColumn<Billetter,String> col_navn;
	
	//table nuværendeprodukter
	@FXML
	private TableView<Rprodukter> table_TPTV;
	@FXML
	private TableColumn<Rprodukter, String> col_TP;
	@FXML
	private TableColumn<Rprodukter, String> col_pris;
	
	//Table Produkter
	@FXML
	private TableView<Produkter> table_produkter;
	@FXML
	private TableColumn<Produkter, String> col_produktpris;
	@FXML 
	private TableColumn<Produkter, String> col_produkt;
	
	//Tabel tilkald fly
	@FXML
	private TableView<Fly> table_tilkald;
	@FXML
	private TableColumn<Fly, String> col_flyid;
	@FXML
	private TableColumn<Fly, String> col_model;
	@FXML
	private TableColumn<Fly, String> col_lokation;
	
	//Tabel send fly
	@FXML
	private TableView<Fly> table_send;
	@FXML
	private TableColumn<Fly, String> col_sendFly;
	@FXML
	private TableColumn<Fly, String> col_sendModel;
	@FXML
	private TableColumn<Fly,String> col_sendLokation;
	
	//Tekst
	@FXML
	private Text fly_nr;
	@FXML
	private Text kunde_navn;
	
	//nybillet.fxml
	@FXML
	private TextField inputNavn;
	@FXML
	private TextField inputTlf;
	@FXML
	private TextField inputEmail;
	@FXML 
	private TextField inputCVR;
	
	//tabel valgte produkter
	@FXML
	private TextField inputAntal;
	@FXML
	private TableView <Rprodukter> table_produkter2;
	@FXML
	private TableColumn <Rprodukter, String> col_produkt2;
	@FXML
	private TableColumn <Rprodukter, String> col_produktpris2;
	@FXML
	private TableColumn <Rprodukter, String> col_produktantal;
	
	//Dato og tid
	@FXML
	private DatePicker dateSelection;
	@FXML
	private TextField HH;
	@FXML
	private TextField MM;
	
	//Tabel destination
	@FXML
	private TableView <Airport> table_destination;
	@FXML
	private TableColumn <Airport, String> col_destination;
	@FXML
	private TableColumn <Airport, String> col_abbreviation;
	
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
		if (selectFly()) {
			Parent root = FXMLLoader.load(getClass().getResource("nybillet.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Noget mangler!");
			errorAlert.setContentText("Husk at udfylde alle felter og vælge både fly og destination!");
			errorAlert.showAndWait();
		}
	}
	
	//Skift til scenen "produkter.fxml" - Gabriel
	
	public void switchToProdukter(ActionEvent event) throws IOException {
		if (selectKunde()) {
			Parent root = FXMLLoader.load(getClass().getResource("produkter.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Nogle ting mangler at blive udfyldt");
			errorAlert.setContentText("Tjek at navn, tlf og email er udfyldt!");
			errorAlert.showAndWait();
		}
	}
	
	//Skift til scenen "Rprodukter.fxml" - Gabriel
	public void switchToRprodukter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Rprodukter.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//Nilaksan

	public void SwitchToFly1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("fly.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	//Nilaksan
	public void switchToTur(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("tilkald.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	//Nilaksan
	public void SwitchToTurTilbage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void loadFaktura(ActionEvent event) throws IOException {
		try {
			
			if ((new File("C:\\Users\\nilak\\Desktop\\Skrivebord\\test.pdf")).exists()) {
		Process p = Runtime
		   .getRuntime()
		   .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\nilak\\Desktop\\Skrivebord\\test.pdf");
		p.waitFor();
			
	} 	else {
			System.out.println("Filen findes ikke");
	}
			System.out.println("Fakturaen er Ã¥bnet som pdf");
	  } catch (Exception ex) {
		ex.printStackTrace();
  }
}
	
	
	//Indlæs de forskellige fly - Gabriel
	public void loadFly(ActionEvent event)	{
		ObservableList<Fly> oblist = FXCollections.observableArrayList();
		ObservableList<Airport> oblist2 = FXCollections.observableArrayList();
		
		try {
			ResultSet rs = Main.getRS();
			ResultSet rs2 = Main.getRS7();
			
			while(rs.next()) {
				if (rs.getBoolean("Status") == true) {
					oblist.add(new Fly(rs.getInt("FlyID"),
							rs.getString("navn"),
							rs.getInt("pladser"),
							rs.getBoolean("Status"),
							rs.getString("Placering")));
				}
			}
			
			while(rs2.next()) {
				oblist2.add(new Airport(rs2.getInt("DestinationID"),rs2.getString("Destination"),rs2.getString("Abbreviation")));
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_flynr.setCellValueFactory(cellData -> cellData.getValue().getId());
		col_flynavn.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_flypladser.setCellValueFactory(cellData -> cellData.getValue().getPladser());
		
		col_destination.setCellValueFactory(cellData -> cellData.getValue().getDestination());
		col_abbreviation.setCellValueFactory(cellData -> cellData.getValue().getAbbreviation());

		table_fly.setItems(oblist);
		
		table_destination.setItems(oblist2);
		
	}
	//knappen til at loade billetter Nilaksan
	public void loadBilletter(ActionEvent event) {
		ObservableList<Billetter> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs2 = Main.getRS2();
			
			while(rs2.next()) {
				oblist.add(new Billetter(rs2.getInt("BilletID"), 
						rs2.getString("Navn"), 
						rs2.getString("Til"), 
						rs2.getInt("Fly"), 
						rs2.getDate("Dato"), 
						rs2.getTime("afgang"), 
						rs2.getString("tlf"), 
						rs2.getString("email"),
						rs2.getInt("CVR")));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_billetID.setCellValueFactory(cellData -> cellData.getValue().getBilletID());
		col_navn.setCellValueFactory(cellData -> cellData.getValue().getNavn());

		table_billetter.setItems(oblist);
	}
	//Nilaksan knappen til at loade tillægsprodukter
	
	public void loadTP(ActionEvent event)	{
		ObservableList<Rprodukter> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs3 = Main.getRS3();
			
			while(rs3.next()) {
				oblist.add(new Rprodukter(rs3.getInt("TillægsproduktID"),
					rs3.getString("Navn"),
					rs3.getInt("tillægsprodukter"),
					rs3.getInt("BilletID"),
					rs3.getFloat("Pris"),
					rs3.getInt("Antal")));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_TP.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_pris.setCellValueFactory(cellData -> cellData.getValue().getPris());


		table_TPTV.setItems(oblist);
	}
	
	//Gabriel
	public boolean selectFly() {
		ObservableList <Fly> flylist;
		ObservableList <Airport> airportlist;
		
		flylist = table_fly.getSelectionModel().getSelectedItems();
		airportlist = table_destination.getSelectionModel().getSelectedItems();
		
		try {
			Date DatePickerDate = Date.valueOf(dateSelection.getValue());
			@SuppressWarnings("deprecation")
			Time tid = new Time(Integer.parseInt(HH.getText()),Integer.parseInt(MM.getText()),0);
			Main.selectPlane(Integer.parseInt(flylist.get(0).getId().get()), airportlist.get(0).getAbbreviation().get(), DatePickerDate, tid);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	} 	
	
	//Gabriel
	public boolean selectKunde() {
		if (inputNavn.getText() == "" || inputTlf.getText() == "" || inputEmail.getText() == "") {
			return false;
		} else {
			Main.selectCustomer(inputNavn.getText(),inputTlf.getText(),inputEmail.getText(), Integer.parseInt(inputCVR.getText()));
			return true;
		}
	}
	
	//Nilaksan
	//Knappen til at loade tillægsprodukter under produkter.fxml
	public void loadProdukt(ActionEvent event)	{
		ObservableList<Produkter> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs4 = Main.getRS4();
			
			while(rs4.next()) {
				oblist.add(new Produkter(rs4.getInt("TillægsproduktID"),
					rs4.getFloat("Pris"),
					rs4.getString("Navn"),
					rs4.getBoolean("Aktiv"),
					rs4.getBoolean("UnderFlyvning")));
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_produkt.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_produktpris.setCellValueFactory(cellData -> cellData.getValue().getPris());


		table_produkter.setItems(oblist);
		
		//Gabriel
		fly_nr.setText(String.valueOf(Main.currentPlane()));
		kunde_navn.setText(String.valueOf(Main.currentNavn()));
	}
	//Nilaksan //Load fly under tilkald.fxml
	public void loadTur(ActionEvent event)	{
		ObservableList<Fly> oblist = FXCollections.observableArrayList();
		ObservableList<Fly> oblist2 = FXCollections.observableArrayList();
		
		try {
			ResultSet rs5 = Main.getRS5();
			ResultSet rs6 = Main.getRS6();

			
			while(rs5.next()) {
				if(rs5.getBoolean("Status") != true) {
					oblist.add(new Fly(rs5.getInt("FlyID"),
					rs5.getString("Navn"),
					rs5.getInt("pladser"),
					rs5.getBoolean("Status"),
					rs5.getString("Placering")));
					
				}
			}
			while(rs6.next()) {
				if(rs6.getBoolean("Status")) {
					oblist2.add(new Fly(rs6.getInt("FlyID"),
					rs6.getString("Navn"),
					rs6.getInt("pladser"),
					rs6.getBoolean("Status"),
					rs6.getString("Placering")));
				}
			}
		
		} 	catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_flyid.setCellValueFactory(cellData -> cellData.getValue().getId());
		col_model.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		
		col_sendFly.setCellValueFactory(cellData -> cellData.getValue().getId());	
		col_sendModel.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_sendLokation.setCellValueFactory(cellData -> cellData.getValue().getPladser());

		table_tilkald.setItems(oblist);
		
		table_send.setItems(oblist2);
	}
	
	//Gabriel
	public void insertValgt (ActionEvent event) {
		ObservableList<Produkter> produktList;
		
		produktList = table_produkter.getSelectionModel().getSelectedItems();
		
		try {
				oblistprod.add(new Rprodukter(0, 
						produktList.get(0).getNavn().get(),
						Integer.parseInt(produktList.get(0).getID().get()),
						0,
						Float.parseFloat(produktList.get(0).getPris().get())*Integer.parseInt(inputAntal.getText()), 
						Integer.parseInt(inputAntal.getText())));
				
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_produkt2.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_produktpris2.setCellValueFactory(cellData -> cellData.getValue().getPris());
		col_produktantal.setCellValueFactory(cellData -> cellData.getValue().getAntal());

		table_produkter2.setItems(oblistprod);
	}
	
	//Gabriel
	public void createBillet(ActionEvent event) throws IOException {
		Main.insertBillet(oblistprod);
		//skift til menu
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
}
	