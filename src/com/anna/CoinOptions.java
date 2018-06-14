package com.anna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Question 3 -- changePossibilities(amount,amount):
 * Your quirky boss collects rare, old coins.
 * They found out you're a programmer and asked you to
 * solve something they've been wondering for a long time.
 *
 *  Write a function that, given an amount of money and
 *  an array of coin denominations, computes the number of
 *  ways to make the amount of money with coins of the available denominations.
 *
 *  Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢),
 *  your program would output 4—the number of ways to make 4¢ with those denominations:
 *
 *  1¢, 1¢, 1¢, 1¢
 *  1¢, 1¢, 2¢
 *  1¢, 3¢
 *  2¢, 2¢
 */

public class CoinOptions {

    public static List<List<Integer>> changePossibilities(int amount, int[] denominations) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(denominations);
        getOptions(results, new Stack<Integer>(), denominations, amount, 0);
        return results;
    }

    private static void getOptions (List<List<Integer>> results, Stack<Integer> result, int[] denominations, int remaining, int start) {
        if (remaining < 0) {
            return;
        }
        else if (remaining == 0) {
            results.add(new ArrayList<Integer>(result));
        }
        for (int i = start; i < denominations.length; i++) {
            result.push(denominations[i]);
            getOptions(results, result, denominations, remaining - denominations[i], i);
            result.pop();
        }
    }
    public static void main(String[] args) {
	// write your code here
        int amount = 4;
        int[] denominations = {1, 2, 3};
        List<List<Integer>> result = changePossibilities(amount, denominations);
        System.out.println(result);
    }
}
