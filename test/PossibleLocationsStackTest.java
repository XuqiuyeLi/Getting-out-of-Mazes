package project3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsStackTest {
	PossibleLocationsStack stack = new PossibleLocationsStack();
	Location x = new Location(2, 1);
	Location y = new Location(3, 3);
	Location z = new Location(5, 6);
	Location m = new Location(2, 2);
	Location n = null;

	@Test
	public void testAdd() throws Exception {
		assertTrue(stack.isEmpty());
		stack.add(x);
		assertFalse(stack.isEmpty()); // if the location is successfully added
		Location removed = stack.remove();
		assertEquals(x, removed); // check if the correct data added
		// if add the null value n, the test would fail
	}

	@Test
	public void testRemove() throws Exception {
		assertNull(stack.remove()); // return null if attempt to remove on an
									// empty stack
		stack.add(x);
		stack.add(y);
		stack.add(z);
		Location removed = stack.remove();
		assertEquals(z, removed); // check if the last location was successfully
									// removed
		removed = stack.remove();
		assertEquals(y, removed); // check if the second last location was
									// successfully removed
		removed = stack.remove();
		assertEquals(x, removed); // check if the first location was
									// successfully removed
		stack.remove();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty()); // should return true when checked on an
										// empty stack
		stack.add(x);
		assertFalse(stack.isEmpty()); // should return false after added a
										// location to the empty stack
		stack.remove();
		assertTrue(stack.isEmpty());
	}

}
