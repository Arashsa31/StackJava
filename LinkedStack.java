package Midterm;

public class LinkedStack<T> implements StackInterface<T> {

	LLNode node = null;

	// Throws StackOverflowException if this stack is full,
	// otherwise places element at the top of this stack.
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		LLNode newNode = new LLNode(element);

		if (node == null) {
			newNode.setLink(node);
			node = newNode;
		} else {
			LLNode current = node.getLink();
			LLNode prev = node;

			// goes through the list
			while (current != null) {
				prev = current;
				current = current.getLink();
			}
			// changes the pointer location
			newNode.setLink(current);
			prev.setLink(newNode);
		}
	}

	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes top element from this stack.
	public void pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}

		LLNode current = null;
		LLNode prev = null;

		// checks if only one element is in the list
		if (node.getLink() != null) {
			current = node.getLink();
			prev = node;

			// goes through the list
			while (current.getLink() != null) {
				prev = current;
				current = current.getLink();
			}
			// swaps the pointer from the last item to null
			prev.setLink(null);
		}
	}

	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element of this stack.
	public T top() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}

		T value = null;
		LLNode current = node.getLink();
		LLNode prev = node;

		// goes through the list
		while (current != null) {
			prev = current;
			current = current.getLink();
		}
		value = (T) prev.getInfo();

		return value;
	}

	// Returns true if this stack is empty, otherwise returns false.
	public boolean isEmpty() {
		return node == null;
	}

	// Returns true if this stack is full, otherwise returns false.
	public boolean isFull() {
		return false;
	}

}
