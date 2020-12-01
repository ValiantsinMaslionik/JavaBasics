package task1_task3.transport;

// Trolley bus
public class TrolleyBus extends TransportBase {

	// Constructor
	public TrolleyBus(int registrationNumber) throws IllegalArgumentException {
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
		return EngineType.ELECTRIC;
	}

	// Gets number of seats
	@Override
	public int getNumberOfSeats() {
		return 50;
	}

	// Gets transport type
	// This property cannot be overridden in a derived class
	@Override
	public TransportType getTransportType() {
		return TransportType.TROLLEYBUS;
	}
}