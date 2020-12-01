package task1_task3.infrastructure;

import java.util.*;

import task1_task3.transport.*;

// Cost service
public interface ICostService {

	// Gets price of the specific public transport
	public double getTotalPrice(Vector<TransportBase> publicTransport) throws UnsupportedEngineTypeException;
	
	// Gets price of the specific public transport
	public double getPrice(TransportBase transport) throws UnsupportedEngineTypeException;
}