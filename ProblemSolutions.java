/******************************************************************
 *
 *   Aidan Heilman / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset of array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n + m), where
     * n and m are the lengths of arrays A and B respectively.
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    /* PutIfAbsent returns null if the key is not in the map, value otherwise.
     * Add list1 to hashmap, add list2 if not in hashmap.
     * Increment count var when duplicate value in list2. 
     * If count == length of list2, list2 is a subset of list1.
     */
        public boolean isSubset(int list1[], int list2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int value : list1) {
            map.put(value, 0); 
        }
        for (int value : list2) {
            if (map.putIfAbsent(value, 0) != null) {
                count++;
            }
        }
        return (count == list2.length);
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * You may assume that 1 <= k <= array.length. Duplicate values are
     * counted separately, e.g., for [5,5,3] and k = 2, the output is 5.
     * For the solution, use a Priority Queue.
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    /* Add array to max heap, remove k times */
    public int findKthLargest(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int maxk = 0;

        for (int value : array) {maxHeap.add(value);}
        for (int i = 0; i < k; i++) {maxk = maxHeap.remove();}

        return maxk;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * Either array may be empty. Duplicate values are kept in the output.
     * For the solution, use a Priority Queue.
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    /* Add both lists' vals to heap, remove from heap and add to array */
    public int[] sort2Arrays(int[] array1, int[] array2) {
        int arraysize = array1.length + array2.length;
        int[] array = new int[arraysize];
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        if (array1.length != 0) {for (int value : array1) {heap.add(value);}}
        if (array2.length != 0) {for (int value : array2) {heap.add(value);}}
        for (int i = 0; i < arraysize; i++) {array[i] = heap.remove();}

        return array;
    }

}