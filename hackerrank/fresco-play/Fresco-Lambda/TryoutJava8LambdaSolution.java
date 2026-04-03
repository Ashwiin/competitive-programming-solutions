import java.io.*;
import java.util.*;

interface PerformOperation {
    // BEGINNER NOTE: This is a functional interface (only one abstract method),
    // so lambdas can be assigned to it.
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        // BEGINNER NOTE: Executes whichever lambda is passed in.
        return p.check(num);
    }

    public PerformOperation isOdd() {
        // BEGINNER NOTE: Returns a lambda that checks odd/even.
        return a -> a % 2 != 0;
    }

    public PerformOperation isPrime() {
        // BEGINNER NOTE: Returns a lambda that checks if number is prime.
        return a -> {
            // BEGINNER NOTE: Numbers less than 2 are not prime.
            if (a < 2) {
                return false;
            }
            if (a == 2) {
                return true;
            }
            // BEGINNER NOTE: Any even number greater than 2 is not prime.
            if (a % 2 == 0) {
                return false;
            }
            // BEGINNER NOTE: Try odd divisors up to sqrt(a).
            for (int i = 3; i * i <= a; i += 2) {
                if (a % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        // BEGINNER NOTE: Returns a lambda that checks if digits read same forward/backward.
        return a -> {
            // BEGINNER NOTE: Use absolute value so negatives are handled by digit comparison.
            int original = Math.abs(a);
            int x = original;
            int reversed = 0;

            // BEGINNER NOTE: Reverse digits mathematically.
            while (x > 0) {
                reversed = reversed * 10 + (x % 10);
                x /= 10;
            }

            return original == reversed;
        };
    }
}

public class TryoutJava8LambdaSolution {
    public static void main(String[] args) throws IOException {
        // BEGINNER NOTE: Create helper object and input reader.
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // BEGINNER NOTE: Number of test cases.
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans;

        // BEGINNER NOTE: Process each test case.
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            // BEGINNER NOTE:
            // ch == 1 -> odd/even
            // ch == 2 -> prime/composite
            // ch == 3 -> palindrome/not palindrome
            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = ret ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                ans = ret ? "PRIME" : "COMPOSITE";
            } else {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = ret ? "PALINDROME" : "NOT PALINDROME";
            }

            System.out.println(ans);
        }
    }
}
