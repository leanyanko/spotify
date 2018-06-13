package com.anna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
