/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.sorting;

import java.util.Arrays;

/**
 *
 * @author Amran
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    // Merge two sub arrays L and M into array
    void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        // fill the left and right array
        for (int i = 0; i < n1; i++) {
            L[i] = array[p + i];
        }
        for (int j = 0; j < n2; j++) {
            M[j] = array[q + 1 + j];
        }

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        // for sorting in descending
        // use if(L[i] >= <[j])
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two sub arrays, sort them and merge them
    void mergeSort(int array[], int left, int right) {
        if (left < right) {

            // m is the point where the array is divided into two sub arrays
            int mid = (left + right) / 2;

            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
    }

    public static void main(String[] args) {
        // created an unsorted array
        int[] array = {6, 5, 12, 10, 9, 1};

        MergeSort mergeSort = new MergeSort();

        // call the method mergeSort()
        // pass argument: array, first index and last index
        mergeSort.mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(array));
    }

}


//When to use Merge Sort
//Merge sort is used when the data structure doesn’t support random access, since it works with pure sequential access (forward iterators, rather than random access iterators). 
//It’s also widely used for external sorting, where random access can be very, very expensive compared to sequential access.
//For example, When sorting a file which doesn’t fit into memory, you might break it into chunks which fit into memory, 
//sort these using independently, writing each out to a file, then merge sort the generated files.
//
//Also, you can use merge sort when you need a stable sort. It’s very important feature of merge sort.
//Mergesort is quicker when dealing with linked lists. This is because pointers can easily be changed when merging lists. It only requires one pass (O(n)) through the list.
//If there is a lot of parallelization occurs then parallelizing Mergesort is simpler than other sort algorithms.