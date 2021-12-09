import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        List<BigInteger> factorials = new ArrayList<>();
        factorials.add(BigInteger.valueOf(0));
        factorials.add(BigInteger.valueOf(1));

        for (int x = 2; x <= n; x++) {
            factorials.add(BigInteger.valueOf(x).multiply(factorials.get(x-1)));
        }
        System.out.println(factorials.get(n));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
