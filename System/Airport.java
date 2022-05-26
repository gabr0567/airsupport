package application;
//Gabriel

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Airport {
	private int DestinationID;
	private String Destination;
	private String Abbreviation;
	
	public Airport(int DestinationID, String Destination, String Abbreviation) {
		this.DestinationID = DestinationID;
		this.Destination = Destination;
		this.Abbreviation = Abbreviation;
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
	
	@Override
	public String toString() {
		return "";
	}
}
