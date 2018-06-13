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

    public static String decoder(String s) {
        String answer = "";
    //    String[] a = s.split("/[/]");
    //    System.out.println(Arrays.toString(a));
//        int i = 0;
//        while (i < s.length()){
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch > '0' && ch < '9') {
                int j = Character.getNumericValue(ch);
                System.out.println(j);
              //  while ()
                i+=2;
                System.out.println(i);
                int k = i;
                while (j > 0) {
                    char c = s.charAt(i);
                    k = i;
                    while (c != ']') {
                        System.out.println(c);
                        answer += c;
                        k++;
                        c = s.charAt(k);
                    }
                    System.out.println(answer);
                    System.out.println("j" + j);
                    j--;
                }
                    i = k;
            }
        //    i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(decoder("2[b3[a]]"));
    }
}
