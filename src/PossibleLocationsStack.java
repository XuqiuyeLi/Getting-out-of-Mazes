package project3;

/**
 * This class creates a reference-based stack implementation of the
 * PossibleLocations interface.
 * 
 * @author Summer Li
 *
 */

public class PossibleLocationsStack implements PossibleLocations {
	private Node first; // top of stack
	private int size;

	// nested linked list class
	private class Node {
		private Location data;
		private Node next;
	}

	/**
	 * Initializes an empty stack.
	 */
	public PossibleLocationsStack() {
		first = null;
		size = 0;
	}

	/**
	 * Returns the number of items in the stack.
	 * 
	 * @return the number of items in the stack
	 */
	public int size() {
		return size;
	}

	/**
	 * Add a SquarePosition object to the beginning of LinkedList Stack.
	 * 
	 * @param s
	 *            object to be added
	 */
	public void add(Location s) throws IllegalArgumentException {
		if (s == null)
			throw new IllegalArgumentException("Invalid location");
		Node current = first;
		first = new Node();
		first.data = s;
		first.next = current;
		size++;
	}

	/**
	 * Removes and returns the item most recently added to this stack.
	 * 
	 * @return the item most recently added or null if empty stack
	 */
	public Location remove() {
		if (isEmpty())
			return null;
		Location data = first.data; // the removed location
		first = first.next; // delete the first node
		size--;
		return data;
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
