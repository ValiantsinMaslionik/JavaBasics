package task1_task3.transport;

import task1_task3.core.IEngineType;

// Engine types
public enum EngineType implements IEngineType {
	ELECTRIC	(1, "Electric engine", 2d),
	DIESEL		(2, "High power diesel engine", 40d),
	GASOLINE	(3, "Low power gasoline engine", 25d),
	JET			(4, "Very powerful jet engine", 2000d);
	
	// Description
	private String description;
	private double fuelConsumption;
	private int typeId;
	
	// Constructor
	private EngineType(int typeId, String description, double fuelConsumption) {
		this.description = description;
		this.fuelConsumption = fuelConsumption;
	}

	// Gets description
	@Override
	public String getDescription() {
		return this.description;
	}

	// Gets fuel consumption
	@Override
	public double getFuelConsumptionPer100Km() {
		return this.fuelConsumption;
	}
	
	// Gets type Id
	@Override
	public int getTypeId() {
		return this.typeId;
	}
}