package task1_task3.infrastructure;

import task1_task3.core.*;

//#Task3-3: Suppress warning because this class isn't planning to be serialized
@SuppressWarnings("serial")
// Unsupported transport type exception
public final class UnsupportedEngineTypeException extends Task1Exception {
	private IEngineType engineType;
	
	// Constructor
	public UnsupportedEngineTypeException(IEngineType engineType) {
		super("Engine type '" + engineType.getDescription() + "' is not supported");	
	}
	
	// Gets unsupported transport type
	public IEngineType getEngineType() {
		return this.engineType;
	}
}