package task1_task3;

import java.util.*;

import task1_task3.infrastructure.*;
import task1_task3.transport.*;

public class Task1Program {

	private static int BusesCount = 3;
	private static int TaxiesCount = 1;
	private static int TrollyBusesCount = 2;
		
	public static void main(String[] args) {
		
		System.out.println("---- Task 1 ----\n");
		
		// #TASK1-4-1: Initialize transport park
		System.out.println("* #TASK1-4-1: Initialize transport park");
		try	{
			Services.ParkService.addTransport(TransportType.BUS, BusesCount);
			Services.ParkService.addTransport(TransportType.TAXI, TaxiesCount);
			Services.ParkService.addTransport(TransportType.TROLLEYBUS, TrollyBusesCount);
		} 
		catch(UnsupportedTransportTypeException ex) {
			System.out.println("! Something went wrong: " + ex.getMessage());
		}
		System.out.println("\nDone (Initialize transport park).");
		
		
		// #Task1-4-2: Get total price of the transport in the park
		System.out.println("\n* #Task1-4-2: Get total price of the transport in the park");
		try {
			Services.CostService.getTotalPrice(Services.ParkService.getTransportAll());
		} catch (UnsupportedEngineTypeException ex) {
			System.out.println("! Something went wrong: " + ex.getMessage());
		}
		System.out.println("\nDone (Get total park cost).");

		Vector<TransportBase> operationResult;
		
		// #Task1-4-3: Sort transport in the park by fuel consumption level
		System.out.println("\n* #Task1-4-2: Sort transport in the park by fuel consumption level");
		operationResult = Services.ParkService.getTransportSorted((t1, t2) -> t2.getFuelConsumption() - t1.getFuelConsumption());
		DumpTransport(operationResult);
		System.out.println("\nDone (Sort transport by fuel consumption level).");
		
		// #Task1-4-4: Filter buses by the max fuel consumption level
		System.out.println("\n* #Task1-4-4: Filter buses by the max fuel consumption level - 44");
		operationResult = Services.ParkService.getTransportFiltered((i) -> i.getTransportType() == TransportType.BUS && i.getFuelConsumption() < 45);
		DumpTransport(operationResult);
		System.out.println("\nDone (Gets bus with fuel consumption level less than 45).");
				
		// #Task1-5: Test cases for exception handling
		System.out.println("\n-- #Task1-5: Test cases for exception handling");
		ExceptionTests();
	}
	
	private static void DumpTransport(Vector<TransportBase> transport) {
		transport.forEach(i -> System.out.println(i));
	}
	
	private static void ExceptionTests() {
		System.out.print("\n* Test#1 - UnsupportedTransportTypeException");
		try	{
			Services.ParkService.addTransport(TransportType.AIRCRAFT, 1);
			System.out.println("\t! Test#1 Failed!");
		} 
		catch(UnsupportedTransportTypeException ex) {
			System.out.println("\t> " + ex.getMessage());
			System.out.println("\tTest#1 Passed.");
		}
		finally {
			System.out.println("Done (Test#1)");
		}
		
		System.out.print("\n* Test#2 - UnsupportedEngineTypeException\n");
		try	{
			Services.CostService.getPrice(new JetAirplane(1));
			System.out.println("\t! Test#2 Failed!");
		} 
		catch(UnsupportedEngineTypeException ex) {
			System.out.println("\t> " + ex.getMessage());
			System.out.println("\tTest#2 Passed.");
		}
		finally {
			System.out.println("Done (Test#2)");
		}
		
		System.out.print("\n* Test#3 - IllegalArgumentException\n");
		try	{
			Services.CostService.getPrice(new Bus(0));
			System.out.println("\t! Test#3 Failed!");
		} 
		catch(IllegalArgumentException ex) {
			System.out.println("\t> " + ex.getMessage());
			System.out.println("\tTest#3 Passed.");
		}
		catch(UnsupportedEngineTypeException ex) {
			System.out.println("\t> " + ex.getMessage());
			System.out.println("\tTest#3 Failed.");
		}
		finally {
			System.out.println("Done (Test N3 - IllegalArgumentException)");
		}
	}
}
