package application;
//Gabriel

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Billetter {
	private int BilletID;
	private String Navn;
	private String Til;
	private int Fly;
	private Date Dato;
	private Time afgang;
	private String tlf;
	private String email;
	private int CVR;
	
	public Billetter(int BilletID, String Navn, String Til, int Fly, Date Dato, Time afgang, String tlf, String email, int CVR) {
		this.BilletID = BilletID;
		this.Navn = Navn;
		this.Til = Til;
		this.Fly = Fly;
		this.Dato = Dato;
		this.afgang = afgang;
		this.tlf = tlf;
		this.CVR = CVR;
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
