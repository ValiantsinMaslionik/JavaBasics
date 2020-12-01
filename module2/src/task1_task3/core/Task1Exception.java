package task1_task3.core;

// Task3-3: Suppress warning because this class isn't planning to be serialized
@SuppressWarnings("serial")
//Base class for the all exceptions in the app
public abstract class Task1Exception extends Exception {
	
	// Constructor
	protected Task1Exception(String message) {
		super(message);
	}
}