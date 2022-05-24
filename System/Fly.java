package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fly {
	private int FlyID;
	private String navn;
	private int pladser;
	private boolean Status;
	private String Placering;
	
	//Gabriel
	public Fly(int FlyID, String navn, int pladser, boolean Status, String Placering) {
		this.FlyID = FlyID;
		this.navn = navn;
		this.pladser = pladser;
		this.Status = Status;
		this.Placering = Placering;
	}
	//Gabriel
	public StringProperty getId() {
		StringProperty var = new SimpleStringProperty(""+FlyID);
		return var;
	}
	//Gabriel
	public StringProperty getNavn() {
		StringProperty var = new SimpleStringProperty(navn);
		return var;
	}
	//Gabriel
	public StringProperty getPladser() {
		StringProperty var = new SimpleStringProperty(""+pladser);
		return var;
	}
	//Gabriel
	public StringProperty getStatus() {
		StringProperty var = new SimpleStringProperty(""+Status);
		return var;
	}
	
	public StringProperty getPlacering() {
		StringProperty var = new SimpleStringProperty(Placering);
		return var;
	}
	
	//Gabriel
	@Override
	public String toString() {
		return "";
	}
}
