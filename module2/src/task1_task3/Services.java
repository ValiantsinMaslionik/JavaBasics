package task1_task3;

import task1_task3.infrastructure.*;

// Cost service locator
public class Services {
	// Gets cost service
	public static final ICostService CostService = new DefaultCostService();
	
	// Gets factory service instance
	public static final ITransportFactory FactoryService = new DefaultTransportFactory();
	
	// Gets transport park instance
	public static final ITransportPark ParkService = new DefaultTransportPark(FactoryService);
}