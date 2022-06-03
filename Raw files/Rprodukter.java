//Nilaksan
package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rprodukter {
	private int TillægsproduktID;
	private String Navn;
	private int tillægsprodukter;
	private int BilletID;
	private float Pris;
	private int Antal;
	
	public Rprodukter(int TillægsproduktID, String Navn, int tillægsprodukter, int BilletID, float Pris, int Antal){
		this.TillægsproduktID = TillægsproduktID;
		this.Navn = Navn;
		this.tillægsprodukter = tillægsprodukter;
		this.Pris = Pris;
		this.Antal = Antal;
	}
	
	public StringProperty getNavn() {
		StringProperty var = new SimpleStringProperty(Navn);
		return var;
	}
		
	public StringProperty getPris() {
		StringProperty var = new SimpleStringProperty(""+Pris);
		return var;
	}
	
	public StringProperty getAntal() {
		StringProperty var = new SimpleStringProperty(""+Antal);
		return var;
	}

	public int getProd() {
		return tillægsprodukter;
	}
	
	public int getID() {
		return TillægsproduktID;
	}
}
