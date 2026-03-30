import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'countMinimumOperations' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY price
     *  2. INTEGER_ARRAY query
     */
    public static List<Long> countMinimumOperations(List<Integer> price, List<Integer> query) {
        // Number of items in the original price list.
        int n = price.size();

        // Copy prices into a primitive long array.
        // Using long prevents overflow during large sum calculations.
        long[] sorted = new long[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = price.get(i);
        }

        // Sort once so each query can be answered efficiently.
        Arrays.sort(sorted);

        // prefix[i] = sum of first i elements in sorted (prefix[0] = 0)
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + sorted[i];
        }

        // Final answer list (one result for each query).
        List<Long> result = new ArrayList<>(query.size());

        // Process each query independently.
        for (int q : query) {
            // idx is the first position with value > q.
            // So [0, idx) are <= q and [idx, n) are > q.
            int idx = upperBound(sorted, q);

            // Cost to raise all values on the left side up to q.
            long leftCost = (long) q * idx - prefix[idx];
            // Cost to lower all values on the right side down to q.
            long rightCost = (prefix[n] - prefix[idx]) - (long) q * (n - idx);

            result.add(leftCost + rightCost);
        }

        return result;
    }

    private static int upperBound(long[] arr, int target) {
        // Classic binary search for first element strictly greater than target.
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Standard HackerRank input/output setup.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read price array.
        int priceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> price = IntStream.range(0, priceCount)
            .mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        // Read query array.
        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> query = IntStream.range(0, queryCount)
            .mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        // Compute minimum operations for each query.
        List<Long> result = Result.countMinimumOperations(price, query);

        // Print each answer on a new line.
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
