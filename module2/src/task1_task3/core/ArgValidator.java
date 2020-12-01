package task1_task3.core;

// Argument validation helper
public class ArgValidator {
	// Checks that argument is not null
	public static void IsNotNull(Object arg, String argName) throws IllegalArgumentException {
		if(arg == null) {
			throw new IllegalArgumentException("Argument cannot be null (" + argName + ")");
		}
	}
}