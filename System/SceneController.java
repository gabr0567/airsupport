package application;

import java.sql.Date;
import java.sql.Timestamp;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private boolean retur = false;
	
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
	private TableView<Produkter> table_TPTV;
	@FXML
	private TableColumn<Produkter, String> col_TP;
	@FXML
	private TableColumn<Produkter, String> col_pris;
	
	//Table Produkter
	@FXML
	private TableView<Produkter> table_produkter;
	@FXML
	private TableColumn<Produkter, String> col_produktpris;
	@FXML 
	private TableColumn<Produkter, String> col_produkt;
	
	//tilkald.fxml
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
	//Tabel lufthavne
	@FXML
	private TableView<Airport> table_airport;
	@FXML
	private TableColumn<Airport, String> col_airportName;
	@FXML
	private TableColumn<Airport, String> col_airportAbb;
	
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
	
	//Dato og tid2
	@FXML
	private DatePicker dateSelection2;
	@FXML
	private TextField HH2;
	@FXML
	private TextField MM2;
	
	//Tabel destination
	@FXML
	private TableView <Airport> table_destination;
	@FXML
	private TableColumn <Airport, String> col_destination;
	@FXML
	private TableColumn <Airport, String> col_abbreviation;
	@FXML
	private TableColumn <Airport, String> col_tur;
	@FXML
	private TableColumn <Airport, String> col_retur;
	
	//moms
	@FXML
	private Text exMoms;
	@FXML
	private Text moms;
	@FXML
	private Text inklMoms;
	
	//Rprodukter.fxml
	@FXML
	private TextField newPrice;
	@FXML
	private TextField addName;
	@FXML
	private TextField addPrice;
	
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
			errorAlert.setContentText("Tjek at navn, tlf og email er udfyldt! (husk at skrive 0 ved CVR, hvis der ikke er CVR)");
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
	
	//Gabriel
	public void switchToBilletter2(ActionEvent event) throws IOException {
		ObservableList<Billetter> billetList;
		
		billetList = table_billetter.getSelectionModel().getSelectedItems();
		
		Main.setCurrentBillet(Integer.parseInt(billetList.get(0).getBilletID().get()));
		Parent root = FXMLLoader.load(getClass().getResource("billetter2.fxml"));
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
				oblist2.add(new Airport(rs2.getInt("DestinationID"),rs2.getString("Destination"),rs2.getString("Abbreviation"),rs2.getFloat("Tur"),rs2.getFloat("Retur")));
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_flynr.setCellValueFactory(cellData -> cellData.getValue().getId());
		col_flynavn.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_flypladser.setCellValueFactory(cellData -> cellData.getValue().getPladser());
		
		col_destination.setCellValueFactory(cellData -> cellData.getValue().getDestination());
		col_abbreviation.setCellValueFactory(cellData -> cellData.getValue().getAbbreviation());
		col_tur.setCellValueFactory(cellData -> cellData.getValue().getTur());
		col_retur.setCellValueFactory(cellData -> cellData.getValue().getRetur());

		table_fly.setItems(oblist);
		
		table_destination.setItems(oblist2);
		
	}
	//knappen til at loade billetter Nilaksan
	public void loadBilletter(ActionEvent event) {
		ObservableList<Billetter> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs2 = Main.getRS2();
			while(rs2.next()) {
				if (rs2.getBoolean("Endt") == false) {
					oblist.add(new Billetter(rs2.getInt("BilletID"),
							rs2.getString("Navn"),
							rs2.getString("Til"),
							rs2.getInt("Fly"),
							rs2.getDate("Dato"),
							rs2.getDate("Dato2"),
							rs2.getTime("afgang"),
							rs2.getTime("afgang2"),
							rs2.getString("tlf"),
							rs2.getString("Email"),
							rs2.getInt("CVR"),
							rs2.getBoolean("Endt"),
							rs2.getFloat("billetPris")));
				}
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
		ObservableList<Produkter> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs3 = Main.getRS3();
			
			while(rs3.next()) {
				if (rs3.getBoolean("Aktiv")) {
					oblist.add(new Produkter(rs3.getInt("TillægsproduktID"),
						rs3.getInt("Pris"),
						rs3.getString("Navn"),
						rs3.getBoolean("Aktiv")));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_TP.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_pris.setCellValueFactory(cellData -> cellData.getValue().getPris());


		table_TPTV.setItems(oblist);
	}
	
	//Gabriel
	@SuppressWarnings("deprecation")
	public boolean selectFly() {
		ObservableList <Fly> flylist;
		ObservableList <Airport> airportlist;
		
		flylist = table_fly.getSelectionModel().getSelectedItems();
		airportlist = table_destination.getSelectionModel().getSelectedItems();
		
		try {
			Date DatePickerDate = Date.valueOf(dateSelection.getValue());
			Time tid = new Time(Integer.parseInt(HH.getText()),Integer.parseInt(MM.getText()),0);
			Date DatePickerDate2 = new Date(0);
			Time tid2 = new Time(0);
			float pris = Float.parseFloat(airportlist.get(0).getTur().get());
			if (retur) {
				DatePickerDate2 = Date.valueOf(dateSelection2.getValue());
				tid2 = new Time(Integer.parseInt(HH2.getText()), Integer.parseInt(MM2.getText()),0);
				pris = pris + Float.parseFloat(airportlist.get(0).getRetur().get());
			}
			Main.selectPlane(Integer.parseInt(flylist.get(0).getId().get()),
					airportlist.get(0).getAbbreviation().get(),
					DatePickerDate, DatePickerDate2, tid, tid2, pris);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	} 	
	
	//Gabriel
	public boolean selectKunde() {
		if (inputNavn.getText() == "" || inputTlf.getText() == "" || inputEmail.getText() == "" || inputCVR.getText() == "") {
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
					rs4.getBoolean("Aktiv")));
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_produkt.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_produktpris.setCellValueFactory(cellData -> cellData.getValue().getPris());


		table_produkter.setItems(oblist);
	}
	
	public void loadProdukt2(ActionEvent event) {
		loadProdukt(event);
		fly_nr.setText(String.valueOf(Main.currentPlane()));
		kunde_navn.setText(String.valueOf(Main.currentNavn()));
	}
	//Nilaksan //Load fly under tilkald.fxml
	public void loadTur(ActionEvent event)	{
		ObservableList<Fly> oblist = FXCollections.observableArrayList();
		ObservableList<Fly> oblist2 = FXCollections.observableArrayList();
		//Gabriel
		ObservableList<Airport> oblist3 = FXCollections.observableArrayList();
		//Nilaksan
		try {
			ResultSet rs5 = Main.getRS5();
			ResultSet rs6 = Main.getRS6();
			//Gabriel
			ResultSet rs = Main.getRS7();
			//Nilaksan
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
			//Gabriel
			while(rs.next()) {
				oblist3.add(new Airport(rs.getInt("DestinationID"), rs.getString("Destination"), rs.getString("Abbreviation"), rs.getFloat("Tur"), rs.getFloat("Retur")));
			}
			//Nilaksan
		} 	catch (Exception ex) {
			ex.printStackTrace();
		}

		col_flyid.setCellValueFactory(cellData -> cellData.getValue().getId());
		col_model.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_lokation.setCellValueFactory(cellData -> cellData.getValue().getPlacering());
		
		col_sendFly.setCellValueFactory(cellData -> cellData.getValue().getId());	
		col_sendModel.setCellValueFactory(cellData -> cellData.getValue().getNavn());

		table_tilkald.setItems(oblist);
		table_send.setItems(oblist2);
		//Gabriel
		col_airportName.setCellValueFactory(cellData -> cellData.getValue().getDestination());
		col_airportAbb.setCellValueFactory(cellData -> cellData.getValue().getAbbreviation());
		
		table_airport.setItems(oblist3);
	}
	
	//Gabriel
	public void insertValgt (ActionEvent event) {
		float inklMomsInt = 0;
		
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
		
		for (int i = 0; i < oblistprod.size(); i++) {
			float pris = Float.parseFloat(oblistprod.get(i).getPris().get());
			inklMomsInt = inklMomsInt + pris;
		}
		exMoms.setText(""+inklMomsInt*0.8);
		moms.setText(""+inklMomsInt*0.2);
		inklMoms.setText(""+inklMomsInt);
	}
	
	//Gabriel
	public void createBillet(ActionEvent event) throws IOException, SQLException {
		Main.insertBillet(oblistprod);
		//skift til menu
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Gabriel
	public void disableProd(ActionEvent event) throws NumberFormatException, SQLException {
		ObservableList<Produkter> produktList;
		produktList = table_TPTV.getSelectionModel().getSelectedItems();
		Main.disableProd(Integer.parseInt(produktList.get(0).getID().get()));
		
		loadTP(event);
	}
	
	//Gabriel
	public void updatePrice(ActionEvent event) throws NumberFormatException, SQLException {
		ObservableList<Produkter> produktList;
		produktList = table_TPTV.getSelectionModel().getSelectedItems();
		Main.updatePrice(Integer.parseInt(produktList.get(0).getID().get()), Float.parseFloat(newPrice.getText()));
		
		loadTP(event);
	}
	
	//Gabriel
	public void newProduct(ActionEvent event) throws NumberFormatException, SQLException {
		Main.newProduct(addName.getText(), Float.parseFloat(addPrice.getText()));
		
		loadTP(event);
	}
	
	//Gabriel
	public void tilkald(ActionEvent event) throws NumberFormatException, SQLException {
		ObservableList<Fly> flyList;
		flyList = table_tilkald.getSelectionModel().getSelectedItems();
		Main.tilkald(Integer.parseInt(flyList.get(0).getId().get()));
		
		loadTur(event);
	}
	
	//Gabriel
	public void send(ActionEvent event) throws NumberFormatException, SQLException {
		ObservableList<Fly> flyList;
		ObservableList<Airport> airportList;
		flyList = table_send.getSelectionModel().getSelectedItems();
		airportList = table_airport.getSelectionModel().getSelectedItems();
		
		Main.send(Integer.parseInt(flyList.get(0).getId().get()), 
				airportList.get(0).getAbbreviation().get());
		
		loadTur(event);
	}
	
	//Gabriel
	public void sendBillet(ActionEvent event) throws IOException, NumberFormatException, SQLException {
		Main.updateBillet(oblistprod);
		Main.sendPDF();
		//skift til menu
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//Gabriel
	public void CSV(ActionEvent event) {
		Main.createCSV();
	}
	
	//Gabriel
	public void enableRetur(ActionEvent event) {
		if (retur) {
			dateSelection2.setDisable(true);
			HH2.setDisable(true);
			MM2.setDisable(true);
			retur = false;
		} else {
			dateSelection2.setDisable(false);
			HH2.setDisable(false);
			MM2.setDisable(false);
			retur = true;
		}
	}
}