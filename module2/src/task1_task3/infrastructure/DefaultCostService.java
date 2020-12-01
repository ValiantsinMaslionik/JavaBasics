package task1_task3.infrastructure;

import java.util.Vector;

import task1_task3.core.*;
import task1_task3.transport.*;

public final class DefaultCostService implements ICostService {
	
	// Price multiplier for average speed
	public static double PRICE_MULTIPLIER_AVG_SPEED = 1000;

	// Price multiplier for number of seats
	public static double PRICE_MULTIPLIER_NUM_OF_SEATS = 1000;
	
	// Price multiplier for engine type
	public static double PRICE_DISCOUNTER_ENGINE_ELECTRIC = 0.1;

	// Price multiplier for engine type
	public static double PRICE_DISCOUNTER_ENGINE_GASOLINE = 1;
	
	// Price multiplier for engine type
	public static double PRICE_DISCOUNTER_ENGINE_DIESEL = 1.1;
	
	// Task3-2: Overrides base class method
	@Override
	// Gets transport price
	public double getPrice(TransportBase transport) throws UnsupportedEngineTypeException {
		System.out.println(">>>> DefaultCostService.getPrice");
		System.out.println(transport);
				
		ArgValidator.IsNotNull(transport, "transport");
		
		double basePrice = this.getBaseTransportPrice(transport);
		System.out.println("\tBase price: " + basePrice);

		double engineTypeDiscount = this.getEngineTypeDiscounter(transport);
		System.out.println("\tEngine type discount: " + engineTypeDiscount);

		double totalPrice = (double)Math.round(basePrice * engineTypeDiscount * 100d) /100d; 
		System.out.println("\tPrice: " + totalPrice);
		
		System.out.println("<<<< DefaultCostService.getPrice");
		return totalPrice;
	}

	// Task3-2: Overrides base class method
	@Override
	// Gets total price
	public double getTotalPrice(Vector<TransportBase> transportSet) throws UnsupportedEngineTypeException {
		System.out.println("\n>> DefaultCostService.getTotalPrice");
		
		double result = 0d;
		for(TransportBase i: transportSet) {
			result += this.getPrice(i);
		}
		
		System.out.println("<< DefaultCostService.getTotalPrice: " + result);
		return result;
	}
	
	private double getBaseTransportPrice(TransportBase transport) {
		return this.getAvgSpeedPricePart(transport)	+ this.getNumberOfSeatsPricePart(transport); 
	}
	
	private double getAvgSpeedPricePart(TransportBase transport) {
		return transport.getAverageSpeed() * PRICE_MULTIPLIER_AVG_SPEED;
	}

	private double getEngineTypeDiscounter(TransportBase transport) throws UnsupportedEngineTypeException {
		switch(transport.getEngineType()) {
			case ELECTRIC: return PRICE_DISCOUNTER_ENGINE_ELECTRIC;
			case DIESEL: return PRICE_DISCOUNTER_ENGINE_DIESEL;
			case GASOLINE: return PRICE_DISCOUNTER_ENGINE_GASOLINE;
			
			default: throw new UnsupportedEngineTypeException(transport.getEngineType()); 
		}
	}
	
	private double getNumberOfSeatsPricePart(TransportBase transport) {
		return transport.getNumberOfSeats() * PRICE_MULTIPLIER_NUM_OF_SEATS;
	}
}