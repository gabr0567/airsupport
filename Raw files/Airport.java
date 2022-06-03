package application;
//Gabriel

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Airport {
	private int DestinationID;
	private String Destination;
	private String Abbreviation;
	private Float Tur;
	private Float Retur;
	
	public Airport(int DestinationID, String Destination, String Abbreviation, Float Tur, Float Retur) {
		this.DestinationID = DestinationID;
		this.Destination = Destination;
		this.Abbreviation = Abbreviation;
		this.Tur = Tur;
		this.Retur = Retur;
	}
	
	public StringProperty getID() {
		StringProperty var = new SimpleStringProperty(""+DestinationID);
		return var;
	}
	
	public StringProperty getDestination() {
		StringProperty var = new SimpleStringProperty(Destination);
		return var;
	}
	
	public StringProperty getAbbreviation() {
		StringProperty var = new SimpleStringProperty(Abbreviation);
		return var;
	}
	
	public StringProperty getTur() {
		StringProperty var = new SimpleStringProperty(""+Tur);
		return var;
	}
	
	public StringProperty getRetur() {
		StringProperty var = new SimpleStringProperty(""+Retur);
		return var;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
