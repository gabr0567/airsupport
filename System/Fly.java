package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fly {
	private int fly_id;
	private String navn;
	private int pladser;
	private boolean status;
  
	public Fly(int fly_id, String navn, int pladser, boolean status) {
		this.fly_id = fly_id;
		this.navn = navn;
		this.pladser = pladser;
		this.status = status;
	}

	public StringProperty getId() {
		StringProperty var = new SimpleStringProperty(""+fly_id);
		return var;
	}

	public StringProperty getNavn() {
		StringProperty var = new SimpleStringProperty(navn);
		return var;
	}
	
	public StringProperty getPladser() {
		StringProperty var = new SimpleStringProperty(""+pladser);
		return var;
	}

	public StringProperty getStatus() {
		StringProperty var = new SimpleStringProperty(""+status);
		return var;
	}
  
	@Override
	public String toString() {
		return "[Hold: hold_id=" + fly_id +
				", navn=" + navn +
				", point=" + status + "]";
	}
}
