package task1_task3.infrastructure;

import task1_task3.core.*;

// #Task3-3: Suppress warning because this class isn't planning to be serialized
@SuppressWarnings("serial")
//Unsupported transport type exception
public final class UnsupportedTransportTypeException extends Task1Exception {
	private ITransportType transportType;
	
	// Constructor
	public UnsupportedTransportTypeException(ITransportType transportType) {
		super("Transport type '" + transportType.getDescription() + "' is not supported");	
	}
	
	// Gets unsupported transport type
	public ITransportType getTransportType() {
		return this.transportType;
	}
}