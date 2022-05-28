/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.math.BigInteger;
import org.junit.Assert;

/**
 *
 * @author Amran Hossain
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807. Example 2:
 *
 * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Psuedocode:
 *
 * Create a dummy node which is the head of new linked list. Create a node
 * temp,initialise it with dummy. Initialize carry to 0. Loop through lists l1
 * and l2 until you reach both ends, and until carry is present. Set sum=l1.val+
 * l2.val + carry. Update carry=sum/10. Create a new node with the digit value
 * of(sum%10) and set it to temp node’s next, then advance temp node to next.
 * Advance both l1 and l2. Return dummy’s next node.
 */
public class AddTwoNumber {

    public AddTwoNumber() {
        test();
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        // After the last iteration, we will check if there is carry left
        // If it's left then we will create a new node and add it
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }

    void test() {

        Assert.assertEquals(new BigInteger("807"),
                toInt(addTwoNumbers(reverse(get(new int[]{3, 4, 2})), reverse(get(new int[]{4, 6, 5})))));

        Assert.assertEquals(new BigInteger("10009998"),
                toInt(addTwoNumbers(reverse(get(new int[]{9, 9, 9, 9, 9, 9, 9})), reverse(get(new int[]{9, 9, 9, 9})))));

        Assert.assertEquals(new BigInteger("10407"),
                toInt(addTwoNumbers(reverse(get(new int[]{9, 4, 2})), reverse(get(new int[]{9, 4, 6, 5})))));

    }

    ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }

    ListNode get(int[] data) {
        ListNode root = new ListNode(data[0]);
        ListNode node = root;
        for (int i = 1; i < data.length; i++) {
            node.next = new ListNode(data[i]);
            node = node.next;
        }
        return root;
    }

    // input: linked list of digits backwards
    BigInteger toInt(ListNode node) {
        BigInteger result = BigInteger.ZERO;
        int pow = 0;
        while (node != null) {
            BigInteger multiplier = BigInteger.valueOf(10);
            multiplier = multiplier.pow(pow);
            result = result.add(BigInteger.valueOf(node.val).multiply(multiplier));
            node = node.next;
            pow++;
        }
        return result;
    }

    void print(ListNode node, String title) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            if (sb.length() > 0) {
                sb.append("->");
            }
            sb.append(node.val);
            node = node.next;
        }
        log(title + sb);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new AddTwoNumber();
    }

    public static void l(Object obj) {
        System.out.print(obj);
    }

    public static void log(Object obj) {
        System.out.println(obj);
        System.out.flush();
    }

}

/**
 * Time Complexity: O(max(m,n)). Assume that m and n represent the length of l1
 * and l2 respectively, the algorithm above iterates at most max(m,n) times.
 *
 * Space Complexity: O(max(m,n)). The length of the new list is at most
 * max(m,n)+1.
 */
// Optimized Solution:
/**
 * public static final ListNode addTwoNumbers( ListNode l1, ListNode l2 ) { int
 * left = 0; ListNode sentinel = new ListNode(0); ListNode tail = sentinel;
 *
 * while (!(l1 == null && l2 == null && left == 0)) { final int add1 = l1 !=
 * null ? l1.val : 0; final int add2 = l2 != null ? l2.val : 0; final int sum =
 * add1 + add2 + left; left = sum / 10; final ListNode tempNode = new
 * ListNode(sum % 10); tail.next = tempNode; tail = tempNode;
 *
 * if (l1 != null) { l1 = l1.next; }
 *
 * if (l2 != null) { l2 = l2.next; }
 *
 * }
 *
 * return sentinel.next; }
 */
