package mypackage;

public class Driver {
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(Integer.valueOf(7));
		queue.enqueue(Integer.valueOf(10));
		queue.dequeue();
		
		System.out.println(queue.firstEl());
		
		queue.enqueue(Integer.valueOf(-3));
		queue.dequeue();
		System.out.println(queue.firstEl());


	}
}
