package mypackage;

public class Driver {
	public static void main(String[] args) {
		
		LLStack stack = new LLStack();
		stack.push(Integer.valueOf(10));
		stack.push(Integer.valueOf(5));
		stack.push(Integer.valueOf(7));
		stack.push(Integer.valueOf(11));
		stack.pop();
		System.out.println( ((Integer)stack.topEl()).toString() );
		
		stack.push(Integer.valueOf(19));
		System.out.println( ((Integer)stack.topEl()).toString() );

	}
}
