package task1_task3.infrastructure;

import java.util.*;

import task1_task3.core.*;
import task1_task3.transport.*;

// Default transport park
public class DefaultTransportPark implements ITransportPark {
	// Garages to store transport
	private final Map<TransportType, Vector<TransportBase>> allGarages = new HashMap<TransportType, Vector<TransportBase>>();
	
	// Transport factory service
	private final ITransportFactory transportFactory;
		
	// Constructor
	public DefaultTransportPark(ITransportFactory transportFactory) {
		this.transportFactory = transportFactory;
	}
	
	// Adds transport to the park
	public void addTransport(TransportType transportType, int count) throws UnsupportedTransportTypeException {
		System.out.println("\n>> DefaultTransportPark.addTransport");
		
		ArgValidator.IsNotNull(transportType, "transportType");
		ArgValidator.IsNotNull(transportFactory, "transportFactory");
		
		Vector<TransportBase> garage = this.allGarages.getOrDefault(transportType, new Vector<TransportBase>());
		for(int idx = 0; idx < count; idx++) {
			TransportBase transportUnit = this.transportFactory.createTransport(transportType);
			garage.add(transportUnit);
		}
		this.allGarages.put(transportType, garage);
		
		System.out.println("<< DefaultTransportPark.addTransport");
	}

	// Get all transport 
	public Vector<TransportBase> getTransportAll() {
		Vector<TransportBase> result = new Vector<TransportBase>();
		this.allGarages.forEach((k, v) -> {
			v.forEach(t -> result.add(t) );
		});
		return result;
	}
	
	// Get transport filtered by criteria
	public Vector<TransportBase> getTransportFiltered(IFilter filter) {
		Vector<TransportBase> result = new Vector<TransportBase>();
		this.allGarages.forEach((k, v) -> {
			v.forEach(t -> {
				if(filter.apply(t)) 
					result.add(t);
			});
 		});
		return result;
	}
	
	public Vector<TransportBase> getTransportSorted(IComparer comparator) {
		Vector<TransportBase> result = this.getTransportAll();
	    Collections.sort(this.getTransportAll(), (i1, i2) -> comparator.compare(i1, i2));
	    return result;
	}
}