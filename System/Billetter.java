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
	private boolean Endt;
	
	public Billetter(int BilletID, String Navn, String Til, int Fly, Date Dato, Time afgang, String tlf, String email, int CVR, boolean Endt) {
		this.BilletID = BilletID;
		this.Navn = Navn;
		this.Til = Til;
		this.Fly = Fly;
		this.Dato = Dato;
		this.afgang = afgang;
		this.tlf = tlf;
		this.email = email;
		this.CVR = CVR;
		this.Endt = Endt;
	}
	
	public StringProperty getBilletID() {
		StringProperty var = new SimpleStringProperty(""+BilletID);
		return var;
	}
	
	public StringProperty getNavn() {
		StringProperty var = new SimpleStringProperty(Navn);
		return var;
	}
	
	public StringProperty getTil() {
		StringProperty var = new SimpleStringProperty(Til);
		return var;
	}
	
	public StringProperty getFly() {
		StringProperty var = new SimpleStringProperty(""+Fly);
		return var;
	}
	
	public StringProperty getDato() {
		StringProperty var = new SimpleStringProperty(""+Dato);
		return var;
	}
	
	public StringProperty getTid() {
		StringProperty var = new SimpleStringProperty(""+afgang);
		return var;
	}
	
	public StringProperty getTlf() {
		StringProperty var = new SimpleStringProperty(""+tlf);
		return var;
	}
	
	public StringProperty getEmail() {
		StringProperty var = new SimpleStringProperty(email);
		return var;
	}
	
	public StringProperty getCVR() {
		StringProperty var = new SimpleStringProperty(""+CVR);
		return var;
	}
}
