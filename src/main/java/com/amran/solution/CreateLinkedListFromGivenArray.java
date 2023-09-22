/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author amranhossain Given an array arr[] of size N. The task is to create
 * linked list from the given array. Examples: *
 *
 * Input : arr[]={1, 2, 3, 4, 5} Output : 1->2->3->4->5
 *
 * Input :arr[]={10, 11, 12, 13, 14} Output : 10->11->12->13->14
 */
public class CreateLinkedListFromGivenArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        Node root = arrayToList(arr, n);
        display(root);
    }

    static class Node {

        int data;
        Node next;
    };

    static Node insert(Node root, int item) {
        Node temp = new Node();
        Node ptr;
        temp.data = item;
        temp.next = null;

        if (root == null) {
            root = temp;
        } else {
            ptr = root;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return root;
    }

    static void display(Node root) {
        while (root != null) {
            System.out.print(root.data + "->");
            root = root.next;
        }
    }

    static Node arrayToList(int arr[], int n) {
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

}
