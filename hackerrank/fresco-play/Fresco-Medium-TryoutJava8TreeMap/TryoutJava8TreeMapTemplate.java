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
    // FUNCTION FOR FILTER 1 - filterByRatings
    TreeMap<String, Web_Series> filterByRatings(TreeMap<String, Web_Series> tmap, String query) {
        // Type your code here
        return new TreeMap<>();
    }

    // FUNCTION FOR FILTER 2 - filterByStatusAndGenre
    TreeMap<String, Float> filterByStatusAndGenre(TreeMap<String, Web_Series> tmap, String query) {
        // Type your code here
        return new TreeMap<>();
    }

    // FUNCTION FOR FILTER 3 - mostPopularGenre
    TreeMap<String, Integer> mostPopularGenre(TreeMap<String, Web_Series> tmap, String query) {
        // Type your code here
        return new TreeMap<>();
    }
}

// DERIVED CLASS - CALL THE 3 FUNCTIONS ACCORDINGLY AND PRINT THEIR OUTPUTS
class Web_SeriesDerived extends Web_SeriesBase {
    void printResults(TreeMap<String, Web_Series> tmap, String query) {
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
                if (size == 1) {
                    System.out.println("The Most Popular Genre is " + gen + " and it has " + noOfWebSeries + " Web Series.");
                } else {
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
public class TryoutJava8TreeMapTemplate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String str;
        String name;
        String query;
        TreeMap<String, Web_Series> tmap = new TreeMap<>();

        n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            String[] strarr = str.split(" - ");
            Web_Series ws = new Web_Series(Float.parseFloat(strarr[1]), strarr[2], strarr[3]);
            name = strarr[0];
            tmap.put(name, ws);
        }

        query = br.readLine();

        Web_SeriesDerived wsd = new Web_SeriesDerived();
        wsd.printResults(tmap, query);
    }
}
