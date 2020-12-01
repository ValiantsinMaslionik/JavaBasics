package task4;

import java.io.IOException;
import java.lang.reflect.*;
import task1_task3.infrastructure.*;
import task1_task3.transport.*;

public class Task4Program {

	private static int BusesCount = 3;
	private static int TaxiesCount = 3;
	private static int TrollyBusesCount = 3;
		
	public static void main(String[] args) {
		// Initialize transport park
		System.out.println("* Initialize transport park");
		try	{
			//  #TASK4-3: Call method via reflection		
			Class<?> clazz = Services.getParkService().getClass();
			Method addTransportMethod = clazz.getMethod("addTransport", TransportType.class, int.class);
			addTransportMethod.invoke(Services.getParkService(), TransportType.BUS, BusesCount);
			addTransportMethod.invoke(Services.getParkService(), TransportType.TAXI, TaxiesCount);
			addTransportMethod.invoke(Services.getParkService(), TransportType.TROLLEYBUS, TrollyBusesCount);
		} 
		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			System.out.println("! Fatal error: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
		}
		System.out.println("\nDone (Initialize transport park).");
				
		// Run exception throwing/handling tests
		System.out.println("\n------ Run exception throwing/handling tests");
		exceptionTests();
		
		// #TASK4-4: Dump all types in the package
		System.out.println("\n------ Dump all types in the package");
		dumpAllTypes();
	}
	
	private static void exceptionTests() {
		System.out.print("\n* Test N1 - UnsupportedTransportTypeException");
		try	{
			Services.getParkService().addTransport(TransportType.AIRCRAFT, 1);
			System.out.println("\t! Test N1 Failed!");
		} 
		catch(UnsupportedTransportTypeException ex) {
			System.out.println("\t" + ex.getMessage());
			System.out.println("Test N1 Passed.");
		}
		System.out.println("Done (Test N1 - UnsupportedTransportTypeException)");
		
		System.out.print("\n* Test N2 - UnsupportedEngineTypeException\n");
		try	{
			// #TASK4-1 Instantiate classes via reflection
			Bus bus = (Bus)Bus.class.getConstructor(int.class).newInstance(1);
			System.out.println("\tRegistration number before: " + bus.getRegistrationNumber());
			
			// #TASK4-2 Set private field via reflection
			Field registrationNumberField = Bus.class.getSuperclass().getDeclaredField("registrationNumber");
			registrationNumberField.setAccessible(true);
			registrationNumberField.setInt(bus, registrationNumberField.getModifiers() & ~Modifier.FINAL);
			registrationNumberField.set(bus, 54321);
			System.out.println("\tRegistration number after: " + bus.getRegistrationNumber());
		} 
		catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException 
				| NoSuchMethodException | SecurityException | NoSuchFieldException ex) {
			System.out.println("! " + ex.getMessage());
			System.out.println("Test N2 Passed.");
		}
		System.out.println("Done (Test N2 - UnsupportedTransportTypeException)");
	}

	private static void dumpAllTypes() {
		try {
			System.out.println("* Gets all types in the package 'task1_task3'");
			Class<?>[] typesInModule = TypeEnumerator.getClasses("task1_task3");
			for(Class<?> type: typesInModule) {
				System.out.println((new TypeDumper()).dumpType(type, false));
			}
		} catch (ClassNotFoundException | IOException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}
}