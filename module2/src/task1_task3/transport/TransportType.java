package task1_task3.transport;

import task1_task3.core.*;

// Defines transport types
public enum TransportType implements ITransportType {
	TAXI		(1, "Taxi"),
	BUS			(2, "Bus"),
	TROLLEYBUS	(3, "Trolleybus"),
	AIRCRAFT    (4, "Jet aircraft");
	
	// Description
	private String description;
	private int typeId;
	
	// Constructor
	private TransportType(int typeId, String description) {
		this.description = description;
		this.typeId = typeId;
	}

	// Gets description
	@Override
	public String getDescription() {
		return this.description;
	}

	// Gets type Id
	@Override
	public int getTypeId() {
		return this.typeId;
	}
}