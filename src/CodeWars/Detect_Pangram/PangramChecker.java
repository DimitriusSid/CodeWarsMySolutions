/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once.
 * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 */

package CodeWars.Detect_Pangram;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PangramChecker {

    public static void main(String[] args) {
        System.out.println(PangramChecker.check("The quick brown fox jumps over the lazy dog"));
        System.out.println(PangramChecker.check2("The quick brown fox jumps over the lazy dog"));
    }

    /*
    First Solution
     */
    public static boolean check(String sentence){
        char[] array = sentence.toUpperCase().toCharArray();
        List<Integer> integers = new ArrayList<>();
        for (char c : array) {
            integers.add((int) c);
        }
        integers = integers.stream()
                .distinct()
                .filter(n -> n > 64 && n < 91)
                .sorted()
                .collect(Collectors.toList());
        int startNum = 65;
        for (int num : integers) {
            if (startNum == num && startNum < 90) {
                startNum++;
            }
        }
        return startNum == 90;
    }

    /*
    Clever Solution
     */
    public static boolean check2(String sentence) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (!sentence.toLowerCase().contains("" + c)) {
                return false;
            }
        }
        return true;
    }



}
