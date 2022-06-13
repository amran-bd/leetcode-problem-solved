package com.amran.solution;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Amran Hossain
 */
public class PalindromeLinkedList {

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack stack = new Stack();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        
        while (head != null) {
            if (head.val != (int)stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
