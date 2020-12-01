package task2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

	@Test
	void testDynamicArray() {
		DynamicArray<String> array = new DynamicArray<String>(String.class);
		assertEquals(DynamicArray.MinimumCapacity, array.capacity());
	}

	@Test
	void testDynamicArrayInt() {
		DynamicArray<String> array = new DynamicArray<String>(String.class, DynamicArray.MiddleCapacityLimit);
		assertEquals(DynamicArray.MiddleCapacityLimit, array.capacity());
	}

	@Test
	void testCapacity() {
		DynamicArray<String> array = new DynamicArray<String>(String.class);
		int idx = 0;
		
		// Test case 1
		for(; idx < DynamicArray.LowCapacityLimit; idx++) {
			array.push("some string 1");
		}
		assertEquals(DynamicArray.LowCapacityLimit, array.capacity());
		
		// Test case 2
		for(; idx < DynamicArray.MiddleCapacityLimit; idx++) {
			array.push("some string 2");
		}
		assertEquals(DynamicArray.MiddleCapacityLimit, array.capacity());
		
		// Test case 3
		for(; idx < DynamicArray.HighCapacityLimit; idx++) {
			array.push("some string 3");
		}
		assertEquals(DynamicArray.HighCapacityLimit, array.capacity());
		
		// Test case 4
		for(; idx < DynamicArray.VeryHighCapacityDelta; idx++) {
			array.push("some string 4");
		}
		assertEquals(DynamicArray.VeryHighCapacityDelta, array.capacity());
	}
	
	
	@Test
	void testClear() {
		DynamicArray<String> array = new DynamicArray<String>(String.class, DynamicArray.MiddleCapacityLimit);
		
		// Test case 1
		array.push("some string 1");
		assertEquals(DynamicArray.MiddleCapacityLimit, array.capacity());
		assertEquals(1, array.size());
		
		// T2st case 2
		array.clear();
		assertEquals(DynamicArray.MinimumCapacity, array.capacity());
		assertEquals(0, array.size());
	}

	@Test
	void testGet() {
		DynamicArray<String> array = new DynamicArray<String>(String.class);
		
		// Test case 1
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			array.get(2);
		});
		
		// Test case 2
		array.push("some string 0");
		assertDoesNotThrow(() -> {
			array.get(0);
		});
		
		// Test case 3
		for(int idx = 1; idx <= DynamicArray.VeryHighCapacityDelta; idx++) {
			array.push("some string " + idx);
		}
		assertEquals("some string " + DynamicArray.VeryHighCapacityDelta, array.get(DynamicArray.VeryHighCapacityDelta));
	}

	@Test
	void testPeek() {
		DynamicArray<String> array = new DynamicArray<String>(String.class);
		
		// Test case 1
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			array.peek();
		});
		
		// Test case 2
		array.push("some string 0");
		assertDoesNotThrow(() -> {
			array.peek();
		});
		
		// Test case 3
		for(int idx = 1; idx <= DynamicArray.VeryHighCapacityDelta; idx++) {
			array.push("some string " + idx);
		}
		assertEquals("some string " + DynamicArray.VeryHighCapacityDelta, array.peek());
	}

	@Test
	void testPush() {
		DynamicArray<String> array = new DynamicArray<String>(String.class);

		// Test case 1
		for(int idx = 1; idx <= DynamicArray.VeryHighCapacityDelta; idx++) {
			array.push("some string " + idx);
		}
		assertEquals(DynamicArray.VeryHighCapacityDelta, array.size());
		assertEquals("some string " + DynamicArray.VeryHighCapacityDelta, array.peek());
	}

	@Test
	void testRemove() {
		DynamicArray<String> array = new DynamicArray<String>(String.class);
		
		for(int idx = 0; idx < 10; idx++) {
			array.push("some string " + idx);
		}

		// Test case 1
		array.remove(5);
		assertEquals("some string 6", array.get(5));

		// Test case 2
		array.remove(7);
		assertEquals("some string 9", array.get(7));
	}

	@Test
	void testSize() {
		DynamicArray<String> array = new DynamicArray<String>(String.class);
		
		// Test case 1
		assertEquals(0, array.size());
		
		// Test case 2
		array.push("some string 1");
		assertEquals(1, array.size());

		// Test case 2
		array.remove(0);
		assertEquals(0, array.size());
	}
	
	@Test
	void testPack() {
		DynamicArray<String> array = new DynamicArray<String>(String.class, DynamicArray.MiddleCapacityLimit);
		
		// Test case 1
		array.push("some string 0");
		array.push("some string 1");
		assertEquals(DynamicArray.MiddleCapacityLimit, array.capacity());
		assertEquals(2, array.size());
		
		// Test case 2
		array.pack();
		assertEquals(2, array.capacity());
		assertEquals(2, array.size());
	}

}
