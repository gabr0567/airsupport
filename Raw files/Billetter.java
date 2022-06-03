package application;
//Gabriel

import java.sql.Date;
import java.sql.Time;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Billetter {
	private int BilletID;
	private String Navn;
	private String Til;
	private int Fly;
	private Date Dato;
	private Date Dato2;
	private Time afgang;
	private Time afgang2;
	private String tlf;
	private String email;
	private int CVR;
	private boolean Endt;
	private float billetPris;
	
	public Billetter(int BilletID, String Navn, String Til, int Fly, Date Dato, Date Dato2, Time afgang, Time afgang2, String tlf, String email, int CVR, boolean Endt, float billetPris) {
		this.BilletID = BilletID;
		this.Navn = Navn;
		this.Til = Til;
		this.Fly = Fly;
		this.Dato = Dato;
		this.Dato2 = Dato2;
		this.afgang = afgang;
		this.afgang2 = afgang2;
		this.tlf = tlf;
		this.email = email;
		this.CVR = CVR;
		this.Endt = Endt;
		this.billetPris = billetPris;
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
	
	public StringProperty getDato2() {
		StringProperty var = new SimpleStringProperty(""+Dato2);
		return var;
	}
	
	public StringProperty getTid() {
		StringProperty var = new SimpleStringProperty(""+afgang);
		return var;
	}
	
	public StringProperty getTid2() {
		StringProperty var = new SimpleStringProperty(""+afgang2);
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

	public StringProperty getPris() {
		StringProperty var = new SimpleStringProperty(""+billetPris);
		return var;
	}
}
