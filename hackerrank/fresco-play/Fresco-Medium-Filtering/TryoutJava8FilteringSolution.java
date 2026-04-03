import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface ReadInput {
    List<List<Integer>> readInput();
}

interface FilterData {
    List<List<Integer>> filterData(List<List<Integer>> li);
}

class MyOperations {
    // BEGINNER NOTE: This stores the trailing number from the first input line.
    // BEGINNER NOTE: The second lambda (filterData) uses this value.
    private static int trailingNumber;

    static ReadInput readInput() {
        // BEGINNER NOTE: This lambda reads input and builds a list of integer lists.
        return () -> {
            List<List<Integer>> result = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // BEGINNER NOTE: First line = trailing number used for filtering.
                String first = br.readLine();
                if (first == null || first.trim().isEmpty()) {
                    return result;
                }
                trailingNumber = Integer.parseInt(first.trim());

                // BEGINNER NOTE: Read remaining lines until EOF.
                // Each line is one inner list.
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) {
                        continue;
                    }

                    // BEGINNER NOTE: Split by spaces and parse each token as integer.
                    List<Integer> row = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                    result.add(row);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return result;
        };
    }

    static FilterData filterData() {
        // BEGINNER NOTE: This lambda transforms each row in the list.
        // 1) remove numbers ending with trailingNumber
        // 2) square remaining numbers
        return li -> li.stream()
            .map(row -> row.stream()
                // BEGINNER NOTE: x % 10 gives the last digit; Math.abs handles negatives safely.
                .filter(x -> Math.abs(x) % 10 != trailingNumber)
                // BEGINNER NOTE: square each remaining value.
                .map(x -> x * x)
                .collect(Collectors.toList()))
            .collect(Collectors.toList());
    }
}

public class TryoutJava8FilteringSolution {
    public static void main(String[] args) throws Exception {
        // BEGINNER NOTE: Get lambda implementation for reading input.
        ReadInput readInput;
        readInput = MyOperations.readInput();

        // BEGINNER NOTE: Read and build the original list-of-lists.
        List<List<Integer>> li = readInput.readInput();

        // BEGINNER NOTE: Get lambda implementation for filtering + squaring.
        FilterData filterData;
        filterData = MyOperations.filterData();

        // BEGINNER NOTE: Apply transformation.
        li = filterData.filterData(li);

        // BEGINNER NOTE: Print output exactly as required by stub (one number per line).
        for (List<Integer> l : li) {
            for (Integer i : l) {
                System.out.println(i);
            }
        }
    }
}
