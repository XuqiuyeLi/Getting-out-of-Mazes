package project3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsQueueTest {
	PossibleLocationsQueue queue = new PossibleLocationsQueue();
	PossibleLocationsQueue q1 = new PossibleLocationsQueue(2);
	Location x = new Location(2, 1);
	Location y = new Location(3, 3);
	Location z = new Location(5, 6);
	Location m = new Location(2, 2);
	Location n = null;

	@Test
	public void testAdd() throws Exception {
		assertTrue(q1.isEmpty());
		q1.add(x);
		assertFalse(q1.isEmpty()); // check if the location is successfully
									// added
		Location removed = q1.remove();
		assertEquals(x, removed); // check if the correct data added
		q1.add(y);
		q1.add(z);
		q1.add(m); // check if m can be added after exceeding the original
					// capacity
		q1.remove();
		q1.remove();
		removed = q1.remove();
		assertEquals(m, removed);
		// if add the null value n, the test would fail
	}

	@Test
	public void testRemove() throws Exception {
		assertNull(queue.remove()); // return null if attempt to remove on an
									// empty queue
		queue.add(x);
		queue.add(y);
		queue.add(z);
		Location removed = queue.remove();
		assertEquals(x, removed); // check if the first location was
									// successfully removed
		removed = queue.remove();
		assertEquals(y, removed); // check if the second location was
									// successfully removed
		removed = queue.remove();
		assertEquals(z, removed); // check if the third location was
									// successfully removed
		queue.remove();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty()); // should return true when checked on an
										// empty queue
		queue.add(x);
		assertFalse(queue.isEmpty()); // should return false after added a
										// location to the empty queue
		queue.remove();
		assertTrue(queue.isEmpty());
	}
}
