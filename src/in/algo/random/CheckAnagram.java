package in.algo.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("SILENT", "LISTEN"));
        System.out.println(isAnagram("TRIANGLE", "INTEGRAL"));
        System.out.println(isAnagram2("TRIANGLE", "INTEGRAL"));
        System.out.println(isAnagram2("abcdba", "aabbcd"));
        System.out.println(isAnagram2("abcdbb", "aabbcd"));
    }

    private static boolean isAnagram(String originalString, String anagramString) {
        //check length. For two strings to be anagrams, they should be same length
        if (originalString.length() != anagramString.length()) {
            return false;
        } else {
            //ok lengths are same. Make a map of characters and the number of times they occur in base string
            Map<Character, Integer> characterCountMap = new HashMap<>();
            for (int i = 0; i < originalString.length(); i++) {
                Character currentChar = originalString.charAt(i);
                if(!characterCountMap.containsKey(currentChar)) {
                    characterCountMap.put(currentChar, 1);
                } else {
                    characterCountMap.replace(currentChar,
                        characterCountMap.get(currentChar) + 1);
                }
            }
            //print the map
            /*for (Character ch: characterCountMap.keySet()) {
                System.out.println(ch + " : " + characterCountMap.get(ch));
            }*/
            //Now check that the characters in the 'anagram' occur same number of times as base string
            for (int i = 0; i < anagramString.length(); i++) {
                Character currentChar = anagramString.charAt(i);
                if (!characterCountMap.containsKey(currentChar)) {
                    return false;
                }
                else {
                    characterCountMap.replace(currentChar, characterCountMap.get(currentChar) - 1);
                    if (characterCountMap.get(currentChar) == 0) {
                        characterCountMap.remove(currentChar);
                    }
                }
            }
            return true;
        }
    }

    private static boolean isAnagram2(String originalString, String anagramString) {
        if (originalString.length() != anagramString.length()) {
            return false;
        } else {
            int[] arr1 = new int[256];
            int[] arr2 = new int[256];

            for (char ch : originalString.toCharArray()){
                arr1[ch]++;
                System.out.println(ch+" = "+arr1[ch]);
            }
            for (char ch : anagramString.toCharArray()){
                arr2[ch]++;
                System.out.println(ch+" = "+arr2[ch]);
            }
            return Arrays.equals(arr1, arr2);
        }
    }
}
