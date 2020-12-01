package task1_task3.infrastructure;

import java.util.Vector;
import task1_task3.transport.*;

// Transport park
public interface ITransportPark {
	
	// Adds new transport to park
	public void addTransport(TransportType transportType, int count) throws UnsupportedTransportTypeException;

	// Gets transport filtered by param
	public <T extends TransportBase> Vector<T> getTransportFiltered(IFilter filter);
	
	// Gets transport sorted by fuel consumption level
	public <T extends TransportBase> Vector<T> getTransportSorted(IComparer comparator);
	
	// Gets all transport in the park
	public Vector<TransportBase> getTransportAll();
	
	// #Task3-4: This is functional interface to define lambda func
	@FunctionalInterface
	// Transport filter comparer 
	public static interface IComparer {
		public int compare(TransportBase transport1, TransportBase transport2);
	}

	// #Task3-4: This is functional interface to define lambda func
	@FunctionalInterface
	// Transport filter
	public static interface IFilter {
		public boolean apply(TransportBase transport);
	}
}