package task1_task3.infrastructure;

import task1_task3.transport.*;

// Default transport factory
public class DefaultTransportFactory implements ITransportFactory {
	// Registration number counter
	private static int RegistrationNumberCounter = 0;

	// Task3-2: Overrides base class method
	@Override
	// Creates transport of the specific type
	public TransportBase createTransport(TransportType transportType) throws UnsupportedTransportTypeException {
		System.out.println(">>>> DefaultTransportFactory.createTransport");
		TransportBase result = null;
		
		switch (transportType) {
			case BUS: 
				result = new Bus(getNextRegistarationNumber());
				break;
				
			case TAXI: 
				result = new Taxi(getNextRegistarationNumber());
				break;
				
			case TROLLEYBUS: 
				result = new TrolleyBus(getNextRegistarationNumber());
				break;
				
			default: throw new UnsupportedTransportTypeException(transportType); 
		}
		
		System.out.println("<<<< DefaultTransportFactory.createTransport");
		return result;
	}

	// Gets next registration number
	private static int getNextRegistarationNumber() {
		return (RegistrationNumberCounter += 1);
	}
}