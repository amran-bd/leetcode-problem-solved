/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.PriorityQueue;

/**
 *
 * @author Amran Hossain
 */
public class KthLargestElementInAnArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2; // k is the index of the array
        System.out.println("" + findKthLargest(nums, k));
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4; // k is the index of the array
        System.out.println("" + findKthLargest(nums2, k2));
    }

    public static int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums);
        //Insertion Sort
        for (int i = 1; i < nums.length; i++) {
            int valueToSort = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > valueToSort) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = valueToSort;
        }
        return nums[nums.length - k];
        //Time is O(nlog(n)). The problem of this solution is that sorting all elements is not necessary and is a overkill for getting just one element.
    }

    //Java Solution 2 - Heap
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();//Time complexity is O(nlog(k)). Space complexity is O(k) for storing the top k numbers.
    }
    
    //Java Solution 3 - Quick Sort // Average case time is O(n), worst case time is O(n^2).
    public int findKthLargest3(int[] nums, int k) {
        if (k < 1 || nums == null) {
		return 0;
	}
	return getKth(nums.length - k +1, nums, 0, nums.length - 1);
    }
    
    public int getKth(int k, int[] nums, int start, int end) {
 
	int pivot = nums[end];
 
	int left = start;
	int right = end;
 
	while (true) {
 
		while (nums[left] < pivot && left < right) {
			left++;
		}
 
		while (nums[right] >= pivot && right > left) {
			right--;
		}
 
		if (left == right) {
			break;
		}
 
		swap(nums, left, right);
	}
 
	swap(nums, left, end);
 
	if (k == left + 1) {
		return pivot;
	} else if (k < left + 1) {
		return getKth(k, nums, start, left - 1);
	} else {
		return getKth(k, nums, left + 1, end);
	}
}
 
public void swap(int[] nums, int n1, int n2) {
	int tmp = nums[n1];
	nums[n1] = nums[n2];
	nums[n2] = tmp;
}
}
