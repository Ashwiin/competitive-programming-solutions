import java.util.Scanner;

/**
 * HackerRank - Java Regex (IP Address Validation)
 * https://www.hackerrank.com/challenges/java-regex/
 * 
 * Pattern Explanation:
 * - Each segment can be:
 *   [0-1]?[0-9]{1,2} : Matches 0-199 (optional 0 or 1, followed by 1-2 digits)
 *   2[0-4][0-9]      : Matches 200-249
 *   25[0-5]          : Matches 250-255
 */

// MyRegex class MUST NOT be public (as per problem requirements)
class MyRegex {
    // Regular expression pattern to validate IP addresses
    String pattern = "(([0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.){3}([0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";
    
    /*
     * Pattern Breakdown:
     * 
     * (                                     : Start of group for first 3 segments
     *   (                                   : Start of segment pattern
     *     [0-1]?[0-9]{1,2}                  : Match 0-199
     *                                       :   - [0-1]? is optional 0 or 1
     *                                       :   - [0-9]{1,2} is 1-2 digits
     *                                       :   - Together: 0-99 or 00-199
     *     |2[0-4][0-9]                      : OR match 200-249
     *     |25[0-5]                          : OR match 250-255
     *   )                                   : End of segment pattern
     *   \\.                                 : Match literal dot (escaped)
     * ){3}                                  : Repeat 3 times (for first 3 segments)
     * (                                     : Start of final segment (same pattern)
     *   [0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5]
     * )                                     : End of final segment
     * 
     * Note: No need for ^ and $ anchors because .matches() in Java
     *       already requires a full string match (implicit anchors)
     */
}

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Test with multiple inputs
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

/*
 * Test Cases:
 * 
 * Input: 000.12.12.034
 * Output: true
 * Explanation: All segments are valid (0, 12, 12, 34)
 * 
 * Input: 121.234.12.12
 * Output: true
 * Explanation: All segments are valid (121, 234, 12, 12)
 * 
 * Input: 23.45.12.56
 * Output: true
 * Explanation: All segments are valid (23, 45, 12, 56)
 * 
 * Input: 000.12.234.23.23
 * Output: false
 * Explanation: Has 5 segments instead of 4
 * 
 * Input: 666.666.23.23
 * Output: false
 * Explanation: 666 > 255 (invalid)
 * 
 * Input: .213.123.23.32
 * Output: false
 * Explanation: Starts with a dot
 * 
 * Input: 23.45.22.32.
 * Output: false
 * Explanation: Ends with a dot
 * 
 * Input: I.Am.not.an.ip
 * Output: false
 * Explanation: Contains non-numeric characters
 * 
 * Input: 122.23
 * Output: false
 * Explanation: Only 2 segments instead of 4
 * 
 * Input: 00.12.123.123123.123
 * Output: false
 * Explanation: "123123" has more than 3 digits
 */
