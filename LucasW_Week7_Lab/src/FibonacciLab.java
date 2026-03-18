
public class FibonacciLab {
    public static int Fib(int n) {
        if (n < 2) {
            return n;
        }
        return Fib(n - 1) + Fib(n - 2);
    }
    public static int iterativeFib(int n) {

        if (n < 2) {
            return n;
        }

        int a = 0;
        int b = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
    public static void main(String[] args) {

        int n = 3;

        System.out.println("Recursive Fibonacci:");
        for (int i = 0; i <= n; i++) {
            System.out.println("Fib(" + i + ") = " + iterativeFib(i));
        }
    }
}
