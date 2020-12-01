package task1_task3.transport;

// Base class for all public transport types
public abstract class TransportBase {
	
	// Registration number
	private final int registrationNumber;
	
	// Fuel consumption factor
	private final int fuelConsumptionFactor;  
	
	// Constructor
	protected TransportBase(int registrationNumber) throws IllegalArgumentException {
		if(registrationNumber <= 0) {
			throw new IllegalArgumentException("Registration number must be greater than 0 (registrationNumber)");
		}

		this.fuelConsumptionFactor = (int)((Math.random() * 9) + 1);
		this.registrationNumber = registrationNumber;
	}

	// Gets average speed
	public abstract int getAverageSpeed();

	// Gets fuel consumption per kilometer
	public abstract EngineType getEngineType();
	
	// GEts fuel consumption
	public int getFuelConsumption() {
		double result = this.getEngineType().getFuelConsumptionPer100Km() + this.fuelConsumptionFactor;
		return (int)Math.round(result);
	}
	
	// Gets number of seats
	public abstract int getNumberOfSeats();
	
	// Gets registration number
	public int getRegistrationNumber() {
		return this.registrationNumber;
	}

	// Gets transport type
	public abstract TransportType getTransportType();
	
	// Gets transport info
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t\tTransport: " + this.getTransportType().getDescription() + "\n");
		sb.append("\t\t\tRegistration number: " + this.getRegistrationNumber() + "\n");
		sb.append("\t\t\tNumber of seats: " + this.getNumberOfSeats() + "\n");
		sb.append("\t\t\tAverage speed: " + this.getAverageSpeed() + "\n");
		sb.append("\t\t\tEngine type: " + this.getEngineType().getDescription() + "\n");
		sb.append("\t\t\tFuel consumption: " + this.getFuelConsumption());
		return sb.toString();
	}
}