import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HackerRank - Tag Content Extractor
 * https://www.hackerrank.com/challenges/tag-content-extractor/
 * 
 * Pattern Explanation:
 * <(.+?)>([^<]+)</\1>
 * 
 * <           - Match opening bracket
 * (.+?)       - Capture group 1: tag name (non-greedy, matches any character)
 * >           - Match closing bracket of start tag
 * ([^<]+)     - Capture group 2: content (matches anything except '<')
 * </          - Match start of closing tag
 * \1          - Backreference to group 1 (ensures closing tag matches opening tag)
 * >           - Match closing bracket of end tag
 * 
 * The pattern ensures:
 * - Start and end tags match exactly (case-sensitive)
 * - Content doesn't contain any tags (no nested tags in content)
 * - Tags can contain any printable characters including spaces
 */

public class TagContentExtractor {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        
        // Regex pattern to match valid tag pairs with content
        String regex = "<(.+?)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        
        while (testCases > 0) {
            String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            
            boolean found = false;
            
            // Find all matches in the line
            while (matcher.find()) {
                // Print the content (group 2)
                System.out.println(matcher.group(2));
                found = true;
            }
            
            // If no valid content found, print None
            if (!found) {
                System.out.println("None");
            }
            
            testCases--;
        }
        
        in.close();
    }
}

/*
 * Test Cases:
 * 
 * Input: "<h1>Nayeem loves counseling</h1>"
 * Output: "Nayeem loves counseling"
 * Explanation: Simple matching tags with content
 * 
 * Input: "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>"
 * Output: 
 * "Sanjay has no watch"
 * "So wait for a while"
 * Explanation: Multiple valid tag pairs found. The inner <h1> tags are matched,
 * and the <par> tags are matched. The outer <h1> tags don't match because they
 * contain nested tags (not just plain content).
 * 
 * Input: "<Amee>safat codes like a ninja</amee>"
 * Output: "None"
 * Explanation: Tags are case-sensitive. "Amee" != "amee"
 * 
 * Input: "<SA premium>Imtiaz has a secret crush</SA premium>"
 * Output: "Imtiaz has a secret crush"
 * Explanation: Tag names can contain spaces and special characters
 * 
 * Additional Edge Cases:
 * 
 * Input: "<a><b>content</b></a>"
 * Output: "content"
 * Explanation: Only the innermost content with matching tags is extracted
 * 
 * Input: "<tag></tag>"
 * Output: "None"
 * Explanation: No content between tags (or empty content)
 * 
 * Input: "<h1>Hello World</h2>"
 * Output: "None"
 * Explanation: Tags don't match (h1 vs h2)
 */
