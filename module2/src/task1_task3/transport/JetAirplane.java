package task1_task3.transport;

//#Task3-1: This type of transport is not longer supported
@Deprecated
//Generic jet airplane
public class JetAirplane extends TransportBase {
	
	// Constructor
	public JetAirplane(int registrationNumber) throws IllegalArgumentException {
		super(registrationNumber);
		
		System.out.println(this.toString());
	}

	// Gets average speed
	@Override
	public int getAverageSpeed() {
		return 700;
	}

	// Gets engine type
	@Override
	public EngineType getEngineType() {
		return EngineType.JET;
	}

	// Gets number of seats
	@Override
	public int getNumberOfSeats() {
		return 320;
	}

	// Gets transport type
	// This property cannot be overridden in a derived class
	@Override
	public final TransportType getTransportType() {
		return TransportType.AIRCRAFT;
	}
}