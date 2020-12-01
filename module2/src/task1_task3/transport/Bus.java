package task1_task3.transport;

// Generic bus
public class Bus extends TransportBase {
	
	// Constructor
	public Bus(int registrationNumber) throws IllegalArgumentException {
		super(registrationNumber);
		
		System.out.println(this.toString());
	}

	// Gets average speed
	@Override
	public int getAverageSpeed() {
		return 30;
	}

	// Gets engine type
	@Override
	public EngineType getEngineType() {
		return EngineType.DIESEL;
	}

	// Gets number of seats
	@Override
	public int getNumberOfSeats() {
		return 50;
	}

	// Gets transport type
	// This property cannot be overridden in a derived class
	@Override
	public final TransportType getTransportType() {
		return TransportType.BUS;
	}
}