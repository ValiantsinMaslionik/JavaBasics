package task2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DynamicDoubleArrayTest {

	@Test
	void testDynamicDoubleArray() {
		DynamicDoubleArray array = new DynamicDoubleArray();
		assertEquals(DynamicDoubleArray.MinimumCapacity, array.capacity());
	}

	@Test
	void testDynamicDoubleArrayInt() {
		DynamicDoubleArray array = new DynamicDoubleArray(DynamicDoubleArray.MiddleCapacityLimit);
		assertEquals(DynamicDoubleArray.MiddleCapacityLimit, array.capacity());
	}

	@Test
	void testCapacity() {
		DynamicDoubleArray array = new DynamicDoubleArray();
		int idx = 0;
		
		// Test case 1
		for(; idx < DynamicDoubleArray.LowCapacityLimit; idx++) {
			array.push(1);
		}
		assertEquals(DynamicDoubleArray.LowCapacityLimit, array.capacity());
		
		// Test case 2
		for(; idx < DynamicDoubleArray.MiddleCapacityLimit; idx++) {
			array.push(1);
		}
		assertEquals(DynamicDoubleArray.MiddleCapacityLimit, array.capacity());
		
		// Test case 3
		for(; idx < DynamicDoubleArray.HighCapacityLimit; idx++) {
			array.push(1);
		}
		assertEquals(DynamicDoubleArray.HighCapacityLimit, array.capacity());
		
		// Test case 4
		for(; idx < DynamicDoubleArray.VeryHighCapacityDelta; idx++) {
			array.push(1);
		}
		assertEquals(DynamicDoubleArray.VeryHighCapacityDelta, array.capacity());
	}
	
	
	@Test
	void testClear() {
		DynamicDoubleArray array = new DynamicDoubleArray(DynamicDoubleArray.MiddleCapacityLimit);
		
		// Test case 1
		array.push(1);
		assertEquals(DynamicDoubleArray.MiddleCapacityLimit, array.capacity());
		assertEquals(1, array.size());
		
		// T2st case 2
		array.clear();
		assertEquals(DynamicDoubleArray.MinimumCapacity, array.capacity());
		assertEquals(0, array.size());
	}

	@Test
	void testGet() {
		DynamicDoubleArray array = new DynamicDoubleArray();
		
		// Test case 1
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			array.get(2);
		});
		
		// Test case 2
		array.push(0);
		assertDoesNotThrow(() -> {
			array.get(0);
		});
		
		// Test case 3
		for(int idx = 1; idx <= DynamicDoubleArray.VeryHighCapacityDelta; idx++) {
			array.push(idx);
		}
		assertEquals(DynamicDoubleArray.VeryHighCapacityDelta, array.get(DynamicDoubleArray.VeryHighCapacityDelta));
	}

	@Test
	void testPeek() {
		DynamicDoubleArray array = new DynamicDoubleArray();
		
		// Test case 1
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			array.peek();
		});
		
		// Test case 2
		array.push(0);
		assertDoesNotThrow(() -> {
			array.peek();
		});
		
		// Test case 3
		for(int idx = 1; idx <= DynamicDoubleArray.VeryHighCapacityDelta; idx++) {
			array.push(idx);
		}
		assertEquals(DynamicDoubleArray.VeryHighCapacityDelta, array.peek());
	}

	@Test
	void testPush() {
		DynamicDoubleArray array = new DynamicDoubleArray();

		// Test case 1
		for(int idx = 1; idx <= DynamicDoubleArray.VeryHighCapacityDelta; idx++) {
			array.push(idx);
		}
		assertEquals(DynamicDoubleArray.VeryHighCapacityDelta, array.size());
		assertEquals(DynamicDoubleArray.VeryHighCapacityDelta, array.peek());
	}

	@Test
	void testRemove() {
		DynamicDoubleArray array = new DynamicDoubleArray();
		
		for(int idx = 0; idx < 10; idx++) {
			array.push(idx);
		}

		// Test case 1
		array.remove(5);
		assertEquals(6, array.get(5));

		// Test case 2
		array.remove(7);
		assertEquals(9, array.get(7));
	}

	@Test
	void testSize() {
		DynamicDoubleArray array = new DynamicDoubleArray();
		
		// Test case 1
		assertEquals(0, array.size());
		
		// Test case 2
		array.push(1);
		assertEquals(1, array.size());

		// Test case 2
		array.remove(0);
		assertEquals(0, array.size());
	}
	
	@Test
	void testPack() {
		DynamicDoubleArray array = new DynamicDoubleArray(DynamicDoubleArray.MiddleCapacityLimit);
		
		// Test case 1
		array.push(1);
		array.push(1);
		assertEquals(DynamicDoubleArray.MiddleCapacityLimit, array.capacity());
		assertEquals(2, array.size());
		
		// Test case 2
		array.pack();
		assertEquals(2, array.capacity());
		assertEquals(2, array.size());
	}

}
