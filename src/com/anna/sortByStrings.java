package com.anna;

import java.util.HashMap;
import java.util.Map;

/**
 * Question 1 -- sortByStrings(s,t):
 * Sort the letters in the string s by the order they occur in the string t.
 * You can assume t will not have repetitive characters.
 * For s = "weather" and t = "therapyw", the output should be sortByString(s, t) = "theeraw".
 * For s = "good" and t = "odg", the output should be sortByString(s, t) = "oodg".
 */

public class sortByStrings {

    public static String sort(String s, String t) {
        String answer = "";

        Map<Character, Integer> map= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch)+ 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch))
                for (int j = 0; j < map.get(ch); j++)
                    answer += ch;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(sort("weather", "therapyw"));
        System.out.println(sort("good", "odg"));
    }
}
