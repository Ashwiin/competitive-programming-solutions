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

class Web_SeriesBase {
    // BEGINNER NOTE: Comments starting with "BEGINNER NOTE" are added for explanation.
    // BEGINNER NOTE: Existing template comments are kept unchanged so you can differentiate them.

    // FUNCTION FOR FILTER 1 - filterByRatings
    TreeMap<String, Web_Series> filterByRatings(TreeMap<String, Web_Series> tmap, String query) {
        // BEGINNER NOTE: Query format is "1, <rating>", so split by comma + optional spaces.
        String[] parts = query.split(",\\s*");
        float q1Rating = Float.parseFloat(parts[1]);

        // BEGINNER NOTE: TreeMap keeps keys sorted alphabetically.
        TreeMap<String, Web_Series> result = new TreeMap<>();
        for (Map.Entry<String, Web_Series> entry : tmap.entrySet()) {
            // BEGINNER NOTE: Keep only entries whose rating is >= requested minimum.
            if (entry.getValue().rating >= q1Rating) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    // FUNCTION FOR FILTER 2 - filterByStatusAndGenre
    TreeMap<String, Float> filterByStatusAndGenre(TreeMap<String, Web_Series> tmap, String query) {
        // BEGINNER NOTE: Query format is "2, <status>, <genre>".
        String[] parts = query.split(",\\s*");
        String q2Status = parts[1];
        String q2Genre = parts[2];

        // BEGINNER NOTE: Value type is Float because this filter outputs only rating, not full object.
        TreeMap<String, Float> result = new TreeMap<>();
        for (Map.Entry<String, Web_Series> entry : tmap.entrySet()) {
            Web_Series ws = entry.getValue();
            // BEGINNER NOTE: Both conditions must match at the same time.
            if (ws.status.equals(q2Status) && ws.genre.equals(q2Genre)) {
                result.put(entry.getKey(), ws.rating);
            }
        }
        return result;
    }

    // FUNCTION FOR FILTER 3 - mostPopularGenre
    TreeMap<String, Integer> mostPopularGenre(TreeMap<String, Web_Series> tmap, String query) {
        // BEGINNER NOTE: First pass -> count how many series belong to each genre.
        HashMap<String, Integer> countByGenre = new HashMap<>();

        for (Web_Series ws : tmap.values()) {
            countByGenre.put(ws.genre, countByGenre.getOrDefault(ws.genre, 0) + 1);
        }

        // BEGINNER NOTE: Second pass -> find the largest frequency.
        int maxCount = 0;
        for (int c : countByGenre.values()) {
            maxCount = Math.max(maxCount, c);
        }

        // BEGINNER NOTE: Third pass -> collect all genres tied at maxCount.
        TreeMap<String, Integer> result = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : countByGenre.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}

// DERIVED CLASS - CALL THE 3 FUNCTIONS ACCORDINGLY AND PRINT THEIR OUTPUTS
class Web_SeriesDerived extends Web_SeriesBase {
    void printResults(TreeMap<String, Web_Series> tmap, String query) {
        // BEGINNER NOTE: First character in query is filter number: 1, 2, or 3.
        int q = Character.getNumericValue(query.charAt(0));

        if (q == 1) {
            TreeMap<String, Web_Series> q1 = filterByRatings(tmap, query);
            if (q1.isEmpty()) {
                System.out.println("There are no TV Series that are rated above or equal to the given Rating.");
            } else {
                Set<Map.Entry<String, Web_Series>> entries = q1.entrySet();
                for (Map.Entry<String, Web_Series> entry : entries) {
                    String key = entry.getKey();
                    Web_Series ws = entry.getValue();
                    // BEGINNER NOTE: Output format required by the problem statement.
                    System.out.println(key + " - " + ws.rating + " - " + ws.status + " - " + ws.genre);
                }
            }
        } else if (q == 2) {
            TreeMap<String, Float> q2 = filterByStatusAndGenre(tmap, query);
            if (q2.isEmpty()) {
                System.out.println("There are no TV Series with the given status under the given genre.");
            } else {
                Set<Map.Entry<String, Float>> entries = q2.entrySet();
                for (Map.Entry<String, Float> entry : entries) {
                    String key = entry.getKey();
                    Float r = entry.getValue();
                    // BEGINNER NOTE: Filter 2 prints only name and rating.
                    System.out.println(key + " - " + r);
                }
            }
        } else {
            int size;
            int flagq3 = 1;
            TreeMap<String, Integer> q3 = mostPopularGenre(tmap, query);
            size = q3.size();
            Set<Map.Entry<String, Integer>> entries = q3.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                String gen = entry.getKey();
                int noOfWebSeries = entry.getValue();
                // BEGINNER NOTE: If only one top genre, print singular sentence.
                if (size == 1) {
                    System.out.println("The Most Popular Genre is " + gen + " and it has " + noOfWebSeries + " Web Series.");
                } else {
                    // BEGINNER NOTE: Build a natural language list for multiple genres.
                    if (flagq3 == 1) {
                        System.out.print("The Most Popular Genres are " + gen);
                        flagq3++;
                    } else if (flagq3 == size) {
                        System.out.print(" and " + gen + " as they each have " + noOfWebSeries + " Web Series.\n");
                    } else {
                        System.out.print(", " + gen);
                        flagq3++;
                    }
                }
            }
        }
    }
}

// CONSTRUCTOR CLASS - TO PASS VALUES TO TREEMAP
class Web_Series {
    float rating;
    String status;
    String genre;

    public Web_Series(float rating, String status, String genre) {
        this.rating = rating;
        this.status = status;
        this.genre = genre;
    }
}

// MAIN CLASS - TO GET INPUTS AND CALL FUNCTIONS FROM OTHER CLASSES
public class TryoutJava8TreeMapSolution {
    public static void main(String[] args) throws Exception {
        // BEGINNER NOTE: BufferedReader is fast input for competitive programming.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String str;
        String name;
        String query;
        TreeMap<String, Web_Series> tmap = new TreeMap<>();

        n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            // BEGINNER NOTE: Each line format: "name - rating - status - genre".
            str = br.readLine();
            String[] strarr = str.split(" - ");
            Web_Series ws = new Web_Series(Float.parseFloat(strarr[1]), strarr[2], strarr[3]);
            name = strarr[0];
            tmap.put(name, ws);
        }

        // BEGINNER NOTE: Query decides which filter runs.
        query = br.readLine();

        Web_SeriesDerived wsd = new Web_SeriesDerived();
        wsd.printResults(tmap, query);
    }
}
