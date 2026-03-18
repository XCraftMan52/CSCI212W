package mypackage;

public class PowerExample2 {
	public static void main(String[] args) {
		double y = nonRecPower(5.6, 2);
		System.out.println(y);
		
	}
	
	static public double nonRecPower(double x, int n) {
		double result = 1;
		if (n > 0)
			for (result = x; n > 1; n--)
				result *= x;
		return result;
	}
}
