package task2;

import java.util.Arrays;

public final class DynamicDoubleArray {
	public static int MinimumCapacity = 1024;
	public static int LowCapacityDelta = 1024;
	public static int LowCapacityLimit = 10240;
	public static int MiddleCapacityDelta = 10240;
	public static int MiddleCapacityLimit = 102400;
	public static int HighCapacityDelta = 102400;
	public static int HighCapacityLimit = 1024000;
	public static int VeryHighCapacityDelta = 1024000;

	private double[] array;
	private int size;
	
	// Default constructor
	public DynamicDoubleArray()  {
		this(MinimumCapacity);
	}

	// Constructor
	// Capacity - initial capacity
	public DynamicDoubleArray(int capacity) {
		int newCapacity = capacity;
		if(capacity < MinimumCapacity) {
			newCapacity = MinimumCapacity;
		}
		this.array = new double[newCapacity];
		this.size = 0;
	}

	// Gets capacity of the array
	public int capacity() {
		return this.array.length;
	}
	
	// Removes all items from the array
	public void clear() {
		this.array = new double[MinimumCapacity];
		this.size = 0;
	}
	
	// Gets item from array by its index.
	public double get(int index) {
		this.checkBounds(index);
		return this.array[index];
	}
	
	// Gets an item from the and of array.
	public double peek() {
		return this.get(this.size - 1);
	}
	
	// Appends new element to the end of the array 
	public void push(double item) {
		int newSize = this.size + 1;
		if(newSize > this.array.length) {
			this.array = this.extend(newSize);
		}
		this.array[this.size] = item;
		this.size = newSize;
	}

	// Removes an item from the by its index
	public void remove(int index) {
		this.checkBounds(index);
		System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
		this.size -= 1;
	}
	
	// Gets number of items stored in the array
	public int size() {
		return this.size;
	}
	
	// Packs array to free unused memory
	public void pack() {
		if(this.size == 0) {
			return;
		}
		this.array = Arrays.copyOfRange(this.array, 0, this.size);
	}

	private int calculateNewCapacity(int newSize) {
		if(newSize <= MinimumCapacity) {
			return MinimumCapacity;
		}
		
		if(newSize <= LowCapacityLimit) {
			return this.array.length + LowCapacityDelta; 
		}
		
		if(newSize <= MiddleCapacityLimit) {
			return this.array.length + MiddleCapacityDelta; 
		}
		
		if(newSize <= HighCapacityLimit) {
			return this.array.length + HighCapacityDelta; 
		}

		return (newSize % VeryHighCapacityDelta) + VeryHighCapacityDelta; 
	}
	
	private void checkBounds(int index) {
		if(index < 0 || index >= this.size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}
	
	private double[] extend(int newSize) {
		int newCapacity = this.calculateNewCapacity(newSize);
		if(newCapacity == this.array.length) {
			return this.array;
		}
		
		double[] newArray = new double[newCapacity];
		System.arraycopy(this.array, 0, newArray, 0, this.array.length);

		return newArray;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int idx = 0; idx < this.size(); idx++) {
			if(idx > 0) {
				sb.append(',');
			}
			sb.append(this.get(idx));
		}
		
		return sb.toString();
	}
	
	public String toString(int startIdx, int count) {
		StringBuilder sb = new StringBuilder();
		
		for(int idx = startIdx; idx < startIdx + count; idx++) {
			if(idx > 0) {
				sb.append(',');
			}
			sb.append(this.get(idx));
		}
		
		return sb.toString();
	}
}
