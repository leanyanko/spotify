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

    static class Pointer {
        int val;
    }

    int pointer;

    public static String decodeString(String s) {

        int len = s.length();
        Pointer pointer = new Pointer();
        pointer.val = 0;

        StringBuilder sb = new StringBuilder();

        while(pointer.val < len) {
            char c = s.charAt(pointer.val++);
            if (c >= '0' && c <= '9') {
                sb.append(parseCount(c, pointer, s));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String parseCount(char c, Pointer pointer, String s) {
        StringBuilder numBuilder = new StringBuilder();
        numBuilder.append(c);

        while(pointer.val < s.length()) {
            char next = s.charAt(pointer.val++);
            if (next >= '0' && next <= '9') {
                numBuilder.append(next);
            } else {
                pointer.val--;
                break;
            }
        }
        int count = Integer.valueOf(numBuilder.toString());
        return(multiply(count, getTextBetweenBrackets(pointer, s)));
    }

    private static String getTextBetweenBrackets(Pointer pointer, String s) {
        StringBuilder sb = new StringBuilder();

        while(pointer.val < s.length()) {
            char next = s.charAt(pointer.val++);

            if (next == '[') {    
                continue;
            } else if (next == ']') {  
                return sb.toString();

            } else {     
                if (next >= '0' && next <= '9') {
                    sb.append(parseCount(next, pointer, s));
                } else {
                    sb.append(next);
                }
            }
        }
        return sb.toString();
    }

    private static String multiply(int count, String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(decoder("2[b3[a]]"));
    }
}
