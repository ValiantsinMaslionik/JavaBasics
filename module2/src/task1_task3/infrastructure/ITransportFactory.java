package task1_task3.infrastructure;

import task1_task3.transport.*;

// Transport factory
public interface ITransportFactory {

	// Creates specific transport unit 
	public TransportBase createTransport(TransportType transportType) throws UnsupportedTransportTypeException;
}