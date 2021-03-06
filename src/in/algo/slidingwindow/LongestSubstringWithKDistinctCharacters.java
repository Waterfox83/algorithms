package in.algo.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String str = "cbbebi";
        int k = 3;
        System.out.println(_getLongestSubstring(str, k));
    }

    /*Input: String="araaci", K=2
    Output: 4
    Explanation: The longest substring with no more than '2' distinct characters is "araa".*/

    private static String _getLongestSubstring(String str, int k) {
        int windowStartIndex = 0;
        int maxSubstringSize = 0;
        String longestSubstring = "";

        for (int windowEndIndex = 0; windowEndIndex <= str.length(); windowEndIndex++) {
            String windowSubString = str.substring(windowStartIndex, windowEndIndex);
            System.out.println("WindowSubString: " + windowSubString);

            if (_getNumberOfDistinctCharactersInString(windowSubString) > k) {
                windowSubString = str.substring(windowStartIndex, windowEndIndex-1);
                System.out.println("WindowSubString: " + windowSubString + " maxSubstringSize:  " + maxSubstringSize);
                if (windowSubString.length() > maxSubstringSize) {
                    maxSubstringSize = windowSubString.length();
                    longestSubstring = windowSubString;
                    System.out.println("longestSubstring: " + longestSubstring);
                }
                windowStartIndex++;
                windowEndIndex = windowStartIndex + k; //resetting window size
            }
        }
        return longestSubstring;
    }

    private static int _getNumberOfDistinctCharactersInString(String str) {
        Set<Character> uniqueChars = new HashSet<>();
        str.chars().forEach(c -> uniqueChars.add((char)c));
        return uniqueChars.size();
    }
}
