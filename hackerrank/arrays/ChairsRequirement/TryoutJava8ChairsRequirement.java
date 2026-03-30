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
     * Complete the 'minChairs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY simulations as parameter.
     */
    public static List<Integer> minChairs(List<String> simulations) {
        // Final answer: one integer per simulation string.
        List<Integer> answer = new ArrayList<>();

        // Process each simulation independently.
        for (String s : simulations) {
            // Chairs currently free to use.
            int available = 0;
            // Total chairs purchased so far for this simulation.
            int purchased = 0;

            // Read actions one by one: C, R, U, L.
            for (int i = 0; i < s.length(); i++) {
                char action = s.charAt(i);

                // C or U means someone needs a chair now.
                if (action == 'C' || action == 'U') {
                    // Use a free chair if one exists.
                    if (available > 0) {
                        available--;
                    } else {
                        // Otherwise buy a new chair.
                        purchased++;
                    }
                } else if (action == 'R' || action == 'L') {
                    // R or L means one chair becomes free.
                    available++;
                }
            }

            // Store minimal chairs needed for this simulation.
            answer.add(purchased);
        }

        return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Read input from standard input.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Write output to the path expected by HackerRank.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Number of simulation strings.
        int simulationsCount = Integer.parseInt(bufferedReader.readLine().trim());

        // Read all simulations using Java streams.
        List<String> simulations = IntStream.range(0, simulationsCount)
            .mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        // Compute answer for each simulation.
        List<Integer> result = Result.minChairs(simulations);

        // Print one result per line.
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
