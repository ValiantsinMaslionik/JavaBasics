package task1_task3.transport;

// Taxi
public class Taxi extends TransportBase {

	// Constructor
	public Taxi(int registrationNumber) throws IllegalArgumentException {
		super(registrationNumber);
		
		System.out.println(this.toString());
	}

	// Gets average speed 
	@Override
	public int getAverageSpeed() {
		return 50;
	}

	// Gets engine type
	@Override
	public EngineType getEngineType() {
		return EngineType.GASOLINE;
	}
	
	// Gets number of seats
	@Override
	public int getNumberOfSeats() {
		return 4;
	}

	// Gets transport type
	// This property cannot be overridden in a derived class
	@Override
	public final TransportType getTransportType() {
		return TransportType.TAXI;
	}
}