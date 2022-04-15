/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

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
 * Create a dummy node which is the head of new linked list. 
 * Create a node temp,initialise it with dummy. 
 * Initialize carry to 0. 
 * Loop through lists l1 and l2 until you reach both ends, and until carry is present. 
 *  Set sum=l1.val+ l2.val + carry. 
 *  Update carry=sum/10. 
 *  Create a new node with the digit value of(sum%10) and set it to temp node’s next, then advance temp node to next.
 *  Advance both l1 and l2. 
 * Return dummy’s next node.
 */
public class AddTwoNumber {

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
 * public static final ListNode addTwoNumbers(
        ListNode l1, 
        ListNode l2
    ) {
        int left = 0;
        ListNode sentinel = new ListNode(0);
        ListNode tail = sentinel;

        while (!(l1 == null && l2 == null && left == 0)) {
            final int add1 = l1 != null ? l1.val : 0;
            final int add2 = l2 != null ? l2.val : 0;
            final int sum = add1 + add2 + left;
            left = sum / 10;
            final ListNode tempNode = new ListNode(sum % 10);
            tail.next = tempNode;
            tail = tempNode;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }

        return sentinel.next;
    }
 */
