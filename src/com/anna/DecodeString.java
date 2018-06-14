package com.anna;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
*  * Question 2 -- decodeString(s): Given an encoded string, return its corresponding decoded string.
 *
 * The encoding rule is:
 * k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times.
 * Note: k is guaranteed to be a positive integer.
 *
 * For s = "4[ab]", the output should be decodeString(s) = "abababab"
 * For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
 *
* */

public class DecodeString {

    public static String ans;

    public static String decoder(String s) {
        ans = "";
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch > '0' && ch < '9') repeater(Character.getNumericValue(ch), s, i + 2);
            else if( ch == '[' || ch == ']') {}

            else {
                ans += Character.toString(ch);
                System.out.println("ans " + ans);
            }

        }
   //     repeater(s.length(), s, 0);
        return ans;
    }


    private static void repeater (int amount, String s, int start){
        char ch = s.charAt(start);
        System.out.println("amount " + amount);
        System.out.println(ch + " from " + start);

        for (int i = 0; i < amount; i ++) {
            int j = start;
            System.out.println("j = start = " + j);

            while(ch != ']') {
                System.out.println(ch + "="+ j);
                j++;

                if (ch > '0' && ch < '9') {
                    int numeric = Character.getNumericValue(ch);
                    System.out.println("numeric " + numeric);

                    repeater(numeric, s, j + 1);
                }
                else if(ch == '[') j++;
                else {
                    ans += Character.toString(ch);
                    System.out.println("ans " + ans);
                }
                ch = s.charAt(j);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(decoder("2[b3[a]]"));
    }
}
