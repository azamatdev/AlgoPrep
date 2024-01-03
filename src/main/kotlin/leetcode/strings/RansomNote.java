package leetcode.strings;

import java.util.HashMap;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstructBest("aab", "baa"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (magazineMap.containsKey(magazine.charAt(i))) {
                magazineMap.put(magazine.charAt(i), magazineMap.get(magazine.charAt(i)) + 1);
                continue;
            }
            magazineMap.put(magazine.charAt(i), 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character currentChar = ransomNote.charAt(i);
            if (magazineMap.containsKey(currentChar)) {
                int currentCount = magazineMap.get(currentChar);
                if (currentCount == 1)
                    magazineMap.remove(currentChar);
                else
                    magazineMap.put(currentChar, currentCount - 1);
            } else
                return false;

        }
        return true;
    }

    //TODO Learn how to index with letters in Ascii values
    public static boolean canConstructBest(String ransomNote, String magazine) {
        int[] nextIndexToStartLooking = new int[26]; // we have 26 letters in English Alphabet
        for (char curr : ransomNote.toCharArray()) { // loop through each item of the ransomNote string
            int index = magazine.indexOf(curr, nextIndexToStartLooking[curr - 97]);
            if (index == -1)
                return false;
            nextIndexToStartLooking[curr - 97] = ++index;
        }
        return true;
    }
}
