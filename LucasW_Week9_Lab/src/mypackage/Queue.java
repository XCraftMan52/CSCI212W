package mypackage;

public class Queue {
	private java.util.LinkedList<Object> queue = new java.util.LinkedList<Object> ();
	
	public Queue() {
		
	}
	public void clear() {
		queue.clear();
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	public Object firstEl() {
		return queue.getFirst();
	}
	public Object dequeue() {
		return queue.removeFirst();
	}
	public void enqueue(Object el) {
		queue.addLast(el);
	}
	public String toString() {
		return queue.toString();
	}
}
