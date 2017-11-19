package project3;

/**
 * This class creates a array-based queue implementation of the
 * PossibleLocations interface.
 * 
 * @author Summer Li
 *
 */

public class PossibleLocationsQueue implements PossibleLocations {
	private int front = 0;
	private int size = 0;
	private final int DEFAULTCAP = 100; // Set default capacity to 100
	private Location[] data;
	private Location[] growData;

	/**
	 * Construct a array-based queue with default capacity.
	 */
	public PossibleLocationsQueue() {
		data = (Location[]) new Object[DEFAULTCAP];
	}

	/**
	 * Construct a array-based queue with a given capacity.
	 */
	public PossibleLocationsQueue(int capacity) {
		data = (Location[]) new Object[capacity];
	}

	/**
	 * Returns the number of items in the queue.
	 * 
	 * @return the number of items in the queue.
	 */
	public int size() {
		return size;
	}

	/**
	 * Add a SquarePosition object to the rear of ArrayBased Queue.
	 * 
	 * @param s
	 *            object to be added
	 */
	public void add(Location s) throws IllegalArgumentException {
		if (s == null)
			throw new IllegalArgumentException("Invalid location");
		if (isFull())
			// if the ArrayBased Queue is full, grow the size by 2
			growData = new Location[data.length * 2];
		System.arraycopy(data, front, growData, front, size);
		data = growData;
		// add the new location s to the rear
		int available = (front + size) % data.length;
		data[available] = s;
		size++;
	}

	/**
	 * Removes and returns the item at the front of this queue.
	 * 
	 * @return the item most recently added or null if empty queue.
	 */
	public Location remove() {
		if (isEmpty())
			return null;
		Location removed = data[front];
		data[front] = null; // delete the front element in the array
		// reset the front to the next element in the array
		front = (front + 1) % data.length;
		size--;
		return removed;

	}

	public boolean isFull() {
		return (size == data.length);
	}

	/**
	 * Check if this stack is empty.
	 * 
	 * @return true if this stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
}
