import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {

        String strWithOutSpaces = s.replaceAll("\\s+","");
        Integer strLen = strWithOutSpaces.length();

        // Calculate rows and cols
        Double lenSqrt = Math.sqrt(strLen);
        int rows = (int) Math.floor(lenSqrt);
        int cols = (int) Math.ceil(lenSqrt);

        if (rows * cols < strLen) { rows += 1;}


        // separate into matrix
        List<String> matrix = new ArrayList<>();
        for (int x = 0; x < rows; x ++) {
            int beginning = cols * x;
            int ending = (x == rows-1) ? strLen : cols * (x+1);

            String segment = strWithOutSpaces.substring(beginning, ending);
            matrix.add(segment);
        }

        String solution = "";
        for (int x = 0; x < cols; x ++) {
            for (int y = 0; y < rows; y++) {
                String currentSegment = matrix.get(y);
                if (currentSegment.length() > x) {
                    solution += currentSegment.charAt(x);
                }
            }
            solution += " ";
        }

        return solution;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
