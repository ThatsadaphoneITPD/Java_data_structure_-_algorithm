package com.bee;

public class MergeSort {
    // Merges two sub-arrays of arr[].
    // First sub-array is arr[l..m]
    // Second sub-array is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find divide sizes of two sub-arrays to be merged
        int n1 = r - m; // n1 from right start to mid(start of left)
        int n2 = m - l + 1; // n2 from mid+1, to left end
        /* Create temp arrays or divide original arr into halve n1 arr and arr n2*/
        int L[] = new int[n1];
        int R[] = new int[n2];
        /*final merge sort Copy data to temp arrays*/
        // copy left temp arr to original arr interval
        for (int i = 0; i < n1; ++i)// get first item in n1 arr
            L[i] = arr[l + i];// add left item into main arr
        // copy right temp arr to original arr interval
        for (int j = 0; j < n2; ++j)// get second item in n2 arr
            R[j] = arr[m + 1 + j];// add right item into main arr
        /* Merge the temp arrays */
        // Initial vale indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-arrays
        //how to sort small to greater data
        // traverse both arrays and in each iteration add smaller of both elements in temp
        int k = l;
        //loop sort
        while (i < n1 && j < n2) {//while traverse both arrays and in each iteration
            if (L[i] <= R[j]) {// if Left item equal or less than right item
                arr[k] = L[i]; i++;//add smaller of both elements in temp
            }
            else {
                arr[k] = R[j]; j++;
                //nor left greater or equal right then move on
            }
            k++;//elements in temp
        }

        /* Copy remaining elements of L[] if any */
        //loop sort in each halve n1 amd n2
        while (i < n1) {// while i item less than temp n1 arr
            arr[k] = L[i]; i++; k++;// add elements left in the first n1 interval
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {//while item less than temp n2 arr
            arr[k] = R[j]; j++; k++; // add elements right in the second n2 interval
        }
    }
    // merge()
    // Arr is an array of integer type
    // int l and r  are the starting and ending index of current original Arr
    static void mergesort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
            // Sort first left and second right halves
            mergesort(arr, l, m);//sort arr1 half form left to mid
            mergesort(arr, m + 1, r);//sort arr2 half from mid to right
            //Merge the sorted halves
            //use merge function to merge smaller to greater int form arr halve left-mid-right
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 38, 27, 43, 9, 9, 82, 10 };
        System.out.println("Given Array");
        printArray(arr);
        MergeSort ob = new MergeSort();
        ob.mergesort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array");
        printArray(arr);
        /*Given Array
            38 27 43 3 9 82 10

          Sorted array
           3 9 10 27 38 43 82 */
    }
}
