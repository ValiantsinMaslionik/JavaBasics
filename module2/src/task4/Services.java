package task4;

import java.lang.reflect.*;
import task1_task3.infrastructure.*;

// Cost service locator
public class Services {
	public static ICostService costService;
	public static ITransportFactory factoryService; 
	public static ITransportPark parkService;

	static {
        try {
        	// #TASK4-1: Instantiate classes via reflection
        	costService = (DefaultCostService)DefaultCostService.class.getConstructor().newInstance();
        	factoryService = (DefaultTransportFactory)DefaultTransportFactory.class.getConstructor().newInstance();
        	parkService = (DefaultTransportPark)DefaultTransportPark.class.getConstructor(ITransportFactory.class).newInstance(factoryService);
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
					| InvocationTargetException	| NoSuchMethodException | SecurityException  ex) {

        	System.out.println("! Fatal error: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
		}
   }
	
	// Gets cost service
	public static ICostService getCostService() {
		return costService;
	}
	
	// Gets factory service instance
	public static ITransportFactory getFactoryService() {
		return factoryService; 
	}
	
	// Gets transport park instance
	public static final ITransportPark getParkService() {
		return parkService;
	}
}