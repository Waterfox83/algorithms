package in.algo.random;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("SILENT", "LISTEN"));
        System.out.println(isAnagram("TRIANGLE", "INTEGRAL"));
        System.out.println(isAnagram("abcdba", "aabbcd"));
    }

    private static boolean isAnagram(String originalString, String anagramString) {
        //check length
        if (originalString.length() != anagramString.length()) {
            return false;
        } else {
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
            for (Character ch: characterCountMap.keySet()) {
                System.out.println(ch + " : " + characterCountMap.get(ch));
            }
//            Map<Character, Integer> characterCountMapForAnagram = new HashMap<>();
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
}
