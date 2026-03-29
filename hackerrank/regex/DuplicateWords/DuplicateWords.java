import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HackerRank - Java Regex 2 (Duplicate Words)
 * https://www.hackerrank.com/challenges/duplicate-word/
 * 
 * Pattern Explanation:
 * \b(\w+)(?:\W+\1\b)+
 * 
 * \b          - Word boundary (start)
 * (\w+)       - Capture group 1: matches one or more word characters
 * (?:...)     - Non-capturing group for the duplicate pattern
 * \W+         - One or more non-word characters (whitespace, punctuation, etc.)
 * \1          - Backreference to group 1 (the captured word)
 * \b          - Word boundary (end)
 * +           - One or more occurrences of the duplicate pattern
 * 
 * Note: Using \W+ instead of \s+ makes the pattern more robust as it matches
 * any non-word characters between duplicate words, not just whitespace.
 * 
 * Example: "hello hello hello" 
 * - Captures "hello" in group 1
 * - Matches " hello hello" as duplicates
 * - Replaces entire match with group(1) (just "hello")
 */

public class DuplicateWords {

    public static void main(String[] args) {
        // Regex pattern to match duplicate words
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        
        // Compile pattern with CASE_INSENSITIVE flag
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
}

/*
 * Alternative Solution (More Efficient):
 * 
 * This approach uses a single replaceAll call instead of a loop:
 * 
 * String regex = "\\b(\\w+)(?:\\s+\\1\\b)+";
 * Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
 * Matcher m = p.matcher(input);
 * String output = m.replaceAll("$1");
 * 
 * The replaceAll method automatically replaces all matches with "$1"
 * (the first captured group).
 */

/*
 * Test Cases:
 * 
 * Input: "Goodbye bye bye world world world"
 * Output: "Goodbye bye world"
 * 
 * Input: "Sam went went to to to his business"
 * Output: "Sam went to his business"
 * 
 * Input: "Reya is is the the best player in eye eye game"
 * Output: "Reya is the best player in eye game"
 * 
 * Input: "in inthe"
 * Output: "in inthe"
 * Explanation: "in" and "inthe" are different words due to word boundaries
 * 
 * Input: "Hello hello Ab aB"
 * Output: "Hello Ab"
 * Explanation: Case-insensitive matching, but preserves first occurrence case
 */
