package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fly {
	private int FlyID;
	private String navn;
	private int pladser;
	private boolean status;
	
	//Gabriel
	public Fly(int FlyID, String navn, int pladser, boolean status) {
		this.FlyID = FlyID;
		this.navn = navn;
		this.pladser = pladser;
		this.status = status;
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
		StringProperty var = new SimpleStringProperty(""+status);
		return var;
	}
	//Gabriel
	@Override
	public String toString() {
		return "[Hold: hold_id=" + FlyID +
				", navn=" + navn +
				", point=" + status + "]";
	}
}
