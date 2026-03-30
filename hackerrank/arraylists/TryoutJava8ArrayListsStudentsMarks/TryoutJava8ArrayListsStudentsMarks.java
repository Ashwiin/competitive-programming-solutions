// ArrayList   - a resizable array; unlike a fixed array, its size grows automatically.
// Arrays      - utility class; Arrays.asList() converts an array into a List.
// Collections - utility class; Collections.max/min find the largest/smallest value in a list.
// BufferedReader / InputStreamReader - read text input one line at a time.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ── Solution class ────────────────────────────────────────────────────────────
// This class contains only the logic for solving the problem.
// Having it separate keeps the logic clean and away from input/output code.
class ExamPerformanceResult {

    // 'static' means we can call this method without creating an object.
    // It takes five Integer arrays (one per subject) and returns an ArrayList<Integer>
    // with 20 values: 5 averages, 5 highs, 5 lows, 5 failure counts.
    public static ArrayList<Integer> performance(
        Integer[] tamil,    // marks of n students in Tamil
        Integer[] english,  // marks of n students in English
        Integer[] maths,    // marks of n students in Mathematics
        Integer[] science,  // marks of n students in Science
        Integer[] social    // marks of n students in Social
    ) {
        // ── Step 1: Group all five subject arrays into one 2-D array ──────────
        // Integer[][] is an "array of arrays" (think of it as a table).
        // Each row is one subject's marks array.
        // This lets us process all five subjects with a single for-loop.
        Integer[][] subjects = { tamil, english, maths, science, social };

        // ── Step 2: Create four empty lists to collect results ────────────────
        ArrayList<Integer> averages = new ArrayList<>(); // will hold 5 averages
        ArrayList<Integer> highest  = new ArrayList<>(); // will hold 5 highest marks
        ArrayList<Integer> lowest   = new ArrayList<>(); // will hold 5 lowest marks
        ArrayList<Integer> failures = new ArrayList<>(); // will hold 5 failure counts

        // ── Step 3: Loop over each subject (runs 5 times) ────────────────────
        for (Integer[] subject : subjects) {

            // Arrays.asList(subject) → converts Integer[] into a List<Integer>.
            // new ArrayList<>(...) → wraps it so we can use Collections.max/min on it.
            // We need ArrayList (not just List) because Collections utilities require it.
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(subject));

            // ── Step 3a: Sum marks and count failures ─────────────────────────
            int sum = 0;       // total marks for this subject
            int failCount = 0; // students who scored below 35 (pass mark is 35)

            for (int mark : list) {  // for-each: 'mark' takes each student's value in turn
                sum += mark;         // add to running total
                if (mark < 35) {     // below 35 = failed
                    failCount++;
                }
            }

            // ── Step 3b: Store stats for this subject ─────────────────────────

            // Integer division: 775 / 10 = 77 (decimal part dropped, not rounded).
            averages.add(sum / list.size());

            // Collections.max() scans the list and returns the largest value.
            // Collections.min() scans the list and returns the smallest value.
            highest.add(Collections.max(list));
            lowest.add(Collections.min(list));

            failures.add(failCount);
        }

        // ── Step 4: Combine all four lists into one 20-element result ─────────
        // Required output order:
        //   positions  0–4  → averages  (Tamil, English, Maths, Science, Social)
        //   positions  5–9  → highest marks
        //   positions 10–14 → lowest marks
        //   positions 15–19 → failure counts
        ArrayList<Integer> solution = new ArrayList<>();
        solution.addAll(averages);  // appends 5 values → positions 0–4
        solution.addAll(highest);   // appends 5 values → positions 5–9
        solution.addAll(lowest);    // appends 5 values → positions 10–14
        solution.addAll(failures);  // appends 5 values → positions 15–19

        return solution; // send the 20-element list back to main()
    }
}

// ── Entry-point class ─────────────────────────────────────────────────────────
// Every Java program starts from main() inside a public class.
public class ExamPerformance {

    public static void main(String[] args) throws IOException {

        // BufferedReader reads input a line at a time.
        // InputStreamReader connects it to System.in (keyboard / test runner input).
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        // ── Step 1: Read n (number of students) ──────────────────────────────
        // b.readLine() returns the next line as a String.
        // .trim() strips leading/trailing whitespace or newline characters.
        // Integer.parseInt() converts the String "10" into the integer 10.
        Integer n = Integer.parseInt(b.readLine().trim());

        // ── Step 2: Read each subject's marks into a fixed-size array ─────────
        // new Integer[n] creates an array with n slots (all null initially).
        // The loop reads one mark per line and fills each slot.

        Integer[] tamil = new Integer[n];
        for (int i = 0; i < n; i++) {
            tamil[i] = Integer.parseInt(b.readLine().trim());
        }

        Integer[] english = new Integer[n];
        for (int i = 0; i < n; i++) {
            english[i] = Integer.parseInt(b.readLine().trim());
        }

        Integer[] maths = new Integer[n];
        for (int i = 0; i < n; i++) {
            maths[i] = Integer.parseInt(b.readLine().trim());
        }

        Integer[] science = new Integer[n];
        for (int i = 0; i < n; i++) {
            science[i] = Integer.parseInt(b.readLine().trim());
        }

        Integer[] social = new Integer[n];
        for (int i = 0; i < n; i++) {
            social[i] = Integer.parseInt(b.readLine().trim());
        }

        b.close(); // close the reader once all input has been read

        // ── Step 3: Call the logic method and print all 20 results ───────────
        ArrayList<Integer> solution = ExamPerformanceResult.performance(
            tamil, english, maths, science, social
        );

        // System.out.println() prints the value then moves to the next line.
        // .get(i) retrieves the element at index i from the ArrayList.
        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i));
        }
    }
}
