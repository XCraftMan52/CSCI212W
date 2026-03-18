package mypackage;

public class RecursiveFunction {
	public static void main(String[] args) {
		double y = power(5.6,2);
		System.out.println ( y );
	}
	
	static double power(double x, int n) {
		if (n == 0)
			return 1.0;
		return x * power(x, n-1);
	}
}
