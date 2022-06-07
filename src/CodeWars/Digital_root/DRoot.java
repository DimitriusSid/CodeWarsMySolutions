/**
 * Given n, take the sum of the digits of n.
 * If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
 * The input will be a non-negative integer.
 * https://www.codewars.com/kata/541c8630095125aba6000c00/
 */


package CodeWars.Digital_root;

import java.util.Arrays;

public class DRoot {
    public static void main(String[] args) {
        System.out.println(digital_root(132189));


    }

    public static int digital_root(int n) {
        String[] elements = Integer.toString(n).split("");
        int sum = Arrays.stream(elements).mapToInt(Integer::valueOf).sum();
        String value = String.valueOf(sum);
        while (value.length() > 1) {
            elements = value.split("");
            sum = Arrays.stream(elements).mapToInt(Integer::valueOf).sum();
            value = String.valueOf(sum);
        }
        return sum;
    }

}
