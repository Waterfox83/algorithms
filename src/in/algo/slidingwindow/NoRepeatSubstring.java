package in.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.println("Max length: " + findLength(str));
    }

    /*public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }*/
    private static int findLength(String str) {
        Map<Character, Integer> characterIndexMap = new HashMap<>();
        int windowStartIndex = 0; int maxLength = 0;
        for (int windowEndIndex = 0; windowEndIndex < str.length(); windowEndIndex++) {
            //Kept the index of character
            Character rightChar = str.charAt(windowEndIndex);
//            System.out.println("Current character: " + rightChar);

            if(characterIndexMap.containsKey(str.charAt(windowEndIndex))) {
                int length = windowEndIndex - windowStartIndex;
//                System.out.println("Current length: " + length);
                maxLength = Math.max(maxLength, length);
//                System.out.println("Max Length: " + maxLength);
                windowStartIndex = characterIndexMap.get(rightChar) + 1;
            }
            characterIndexMap.put(str.charAt(windowEndIndex), windowEndIndex);
//            System.out.println("Substring: " + str.substring(windowStartIndex, windowEndIndex+1));
        }
        return maxLength;
    }
}
