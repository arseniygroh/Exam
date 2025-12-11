import acm.program.ConsoleProgram;

public class FactorialAndFibonncci extends ConsoleProgram {
    public void run() {

    }

    private void factorial() {
        print("Enter a number you want to find a factorial of: ");
        int n = readInt();
        while (n < 0) {
            print("Your value must be positive: ");
            n = readInt();
        }

        if (n == 0) {
            println("Factorial of 0 is 1");
            return;
        }

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            if (i != n) print(i + " * " );
            else print(i + " = " + factorial);
        }
    }

    private int factorialR(int n) {
        if (n <= 0) {
            return 1;
        }
        return n * factorialR(n - 1);
    }

    private int fibanocciR(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibanocciR(n - 2)  + fibanocciR(n - 1);
    }

    public void calculateFibonacci() {
        print("Enter a number you want to find a fibonacci of: ");
        int n = readInt();
        while (n < 0) {
            print("Your value must be positive: ");
            n = readInt();
        }

        if (n == 0) {
            println("Result of calculation is " + 0);
            return;
        }
        if (n == 1) {
            println("Result of calculation is " + 1);
            return;
        }

        int a = 0;
        int b = 1;
        int next;

        for (int i = 2; i <= n; i++) {
            next = a + b;
            a = b;
            b = next;
        }
        println("Result of calculation is " + b);
    }

    public static void main(String[] args) {
        new FactorialAndFibonncci().start(args);
    }
}
