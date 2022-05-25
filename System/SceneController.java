package application;

import java.sql.Date;
import java.sql.Timestamp;
import java.io.File;
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
import javafx.scene.text.Text;
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
	private TableView<Billetter> table_billetter;
	@FXML
	private TableColumn<Billetter,String> col_billetID;
	@FXML
	private TableColumn<Billetter,String> col_navn;
	
	//table billetter
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
	private TableColumn<Produkter, String> col_produktmad;
	
	@FXML
	private TableView<Fly> table_tilkald;
	@FXML
	private TableColumn<Fly, String> col_flyid;
	@FXML
	private TableColumn<Fly, String> col_model;
	@FXML
	private TableColumn<Fly, String> col_lokation;
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
	
	//Skift til scenen "produkter.fxml" - Nilaksan
	public void SwitchToProdukt(ActionEvent event) throws IOException {
		selectFly();
		Parent root = FXMLLoader.load(getClass().getResource("produkter.fxml"));
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
			System.out.println("Fakturaen er åbnet som pdf");
	  } catch (Exception ex) {
		ex.printStackTrace();
  }

}
	
	
	//Indlæs de forskellige fly - Gabriel
	public void loadFly(ActionEvent event)	{
		ObservableList<Fly> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs = Main.getRS();
			
			while(rs.next()) {
				if (rs.getBoolean("Status") == true) {
					oblist.add(new Fly(rs.getInt("FlyID"),rs.getString("navn"),rs.getInt("pladser"),rs.getBoolean("Status"),rs.getString("Placering")));
				}
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_flynr.setCellValueFactory(cellData -> cellData.getValue().getId());
		col_flynavn.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_flypladser.setCellValueFactory(cellData -> cellData.getValue().getPladser());

		table_fly.setItems(oblist);
	}
	//knappen til at loade billetter
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
	//Nilaksan knappen til at loade tillægsprodukter
	
	public void loadTP(ActionEvent event)	{
		ObservableList<Rprodukter> oblist = FXCollections.observableArrayList();
		
		try {
			ResultSet rs3 = Main.getRS3();
			
			while(rs3.next()) {
				oblist.add(new Rprodukter(rs3.getInt("TillægsproduktID"),
					rs3.getFloat("Pris"),
					rs3.getString("Navn"),
					rs3.getBoolean("Aktiv")));
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		col_TP.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_pris.setCellValueFactory(cellData -> cellData.getValue().getPris());


		table_TPTV.setItems(oblist);
	}
	
	public void selectFly() {
		ObservableList <Fly> flylist;
		
		flylist = table_fly.getSelectionModel().getSelectedItems();
		
		Main.selectPlane(Integer.parseInt(flylist.get(0).getId().get()));
		System.out.println(flylist.get(0).getId().get());
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
		
		col_produktmad.setCellValueFactory(cellData -> cellData.getValue().getNavn());
		col_produktpris.setCellValueFactory(cellData -> cellData.getValue().getPris());


		table_produkter.setItems(oblist);
		
		fly_nr.setText(String.valueOf(Main.currentPlane()));
		System.out.println(Main.currentPlane());
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
}
	