/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain You are given an array prices where prices[i] is the
 * price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
 * and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
 * transactions are done and the max profit = 0.
 */
public class BestTimeBuySell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        int[] input2 = {7,6,4,3,1};
        System.out.println("MaxProfit" + maxProfit(input));
        System.out.println("MaxProfit" + maxProfit(input2));
    }

    public static int maxProfit(int[] prices) {
        int left = 0, right = 1, maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Integer.max(maxProfit, profit);
            } else {
                left = right;
            }
            right += 1;
        }
        return maxProfit;
    }

}
