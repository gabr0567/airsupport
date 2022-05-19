package application;

import java.sql.Date;
import java.sql.Timestamp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Billetter {
	private int BilletID;
	private int KundeID;
	private String Navn;
	private String Til;
	private int Fly;
	private Date Dato;
	private int Sæde;
	private String Gate;
	private Timestamp afgang;
	
	public Billetter(int BilletID, int KundeID, String Navn, String Til, int Fly, Date Dato, int Sæde, String Gate, Timestamp afgang) {
		this.BilletID = BilletID;
		this.KundeID = KundeID;
		this.Navn = Navn;
		this.Til = Til;
		this.Fly = Fly;
		this.Dato = Dato;
		this.Sæde = Sæde;
		this.Gate = Gate;
		this.afgang = afgang;
	}
	
	public StringProperty getBilletID() {
		StringProperty var = new SimpleStringProperty(""+BilletID);
		return var;
	}
	
	public StringProperty getNavn() {
		StringProperty var = new SimpleStringProperty(Navn);
		return var;
	}
}
