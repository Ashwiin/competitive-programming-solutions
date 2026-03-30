import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    /*
     * Complete the 'arrayChallenge' function below.
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Long> arrayChallenge(List<Integer> arr) {
        // This list will store the final answer for each index i.
        // result.get(i) = counter value for arr[i].
        List<Long> result = new ArrayList<>();

        // Outer loop: pick one element arr[i] at a time.
        for (int i = 0; i < arr.size(); i++) {
            // For every new i, counter starts from 0.
            // We use long because sums can grow larger than int range.
            long counter = 0;
            
            // Inner loop: compare arr[i] with each element to its left (arr[0..i-1]).
            for (int j = 0; j < i; j++) {
                // Absolute difference between current value and left value.
                int diff = Math.abs(arr.get(i) - arr.get(j));

                // Rule from the problem statement:
                // - If left element is smaller, add |difference|.
                // - Otherwise (left is greater or equal), subtract/add accordingly.
                // In this implementation, when current > left we subtract,
                // else we add, matching the logic used in this solution.
                if (arr.get(i) > arr.get(j)) {
                    counter -= diff;
                } else {
                    counter += diff;
                }
            }

            // Store the counter for this index i.
            result.add(counter);
        }

        // Return all counters.
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Read input from standard input.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Write output to the path expected by HackerRank runner.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        // First line: number of elements.
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = new ArrayList<>();
        
        // Next arrCount lines: array values.
        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        // Call the function to compute the answer.
        List<Long> result = Result.arrayChallenge(arr);

        // Print each answer on its own line.
        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        // Final newline and close resources.
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
