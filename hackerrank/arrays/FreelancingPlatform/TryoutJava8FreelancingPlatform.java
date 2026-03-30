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
     * Complete the 'minCost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER numProjects
     *  2. INTEGER_ARRAY projectId
     *  3. INTEGER_ARRAY bid
     */
    public static long minCost(int numProjects, List<Integer> projectId, List<Integer> bid) {
        // minBid[p] stores the cheapest bid seen so far for project p.
        // Start with a very large value meaning "no bid seen yet".
        long[] minBid = new long[numProjects];
        Arrays.fill(minBid, Long.MAX_VALUE);

        // projectId[i] aligns with bid[i], so each index i is one bid entry.
        for (int i = 0; i < projectId.size(); i++) {
            int project = projectId.get(i);
            long amount = bid.get(i);

            // Keep only the minimum bid for each project.
            if (amount < minBid[project]) {
                minBid[project] = amount;
            }
        }

        // Add the minimum bid of every project.
        // If any project never received a bid, answer must be -1.
        long total = 0;
        for (int p = 0; p < numProjects; p++) {
            if (minBid[p] == Long.MAX_VALUE) {
                return -1;
            }
            total += minBid[p];
        }

        return total;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Standard HackerRank I/O setup.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read number of projects (projects are labeled 0 to numProjects - 1).
        int numProjects = Integer.parseInt(bufferedReader.readLine().trim());

        // Read projectId array.
        int projectIdCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> projectId = IntStream.range(0, projectIdCount)
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

        // Read bid array.
        int bidCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> bid = IntStream.range(0, bidCount)
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

        // Compute the minimum total hiring cost.
        long result = Result.minCost(numProjects, projectId, bid);

        // Print the final answer.
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
