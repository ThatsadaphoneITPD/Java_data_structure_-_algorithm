package com.bee;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    // A utility function to swap two elements
    int n;		//Size of array
    int A[]; // for reading time
    QuickSort(){}
    QuickSort(int size) //for reading time
    {
        n = size;
        A = new int[n];
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {
        // pivot
        int pivot = arr[high];
        // Index of smaller element and // indicates the right position // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            // If current element is smaller // than the pivot
            if (arr[j] < pivot)
            {
                // Increment index of // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            // pi is partitioning index, arr[p]// is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before// partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array

    void Input()
    {
        Random rd = new Random();
        for(int i = 0; i<n; i++)
            A[i] = rd.nextInt(100);/// will random number 0-99 into array
    }

    // Driver Code
    public static void main(String[] args)
    {
        QuickSort S = new QuickSort(10);
        S.Input();
        System.out.println("\n---");
        System.out.println("Sorted array: " );
        System.out.println(Arrays.toString(S.A));
        quickSort(S.A, 0, S.n - 1);
        System.out.println("affter Sorted array: " );
        System.out.println(Arrays.toString(S.A));
        // get time
        double start,finish, duration;
        //Memory consumption // and time
        System.out.println("RAM needed (KB): " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        start = System.currentTimeMillis();//Get time at start point to count or read begin timer
        //every function must stay in middle start and finish
        quickSort(S.A, 0, S.n - 1);// away should in middle of start and finish
        finish = System.currentTimeMillis();//Get time at end point// end reading run function timer
        System.out.println("RAM needed (KB): " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        duration = finish - start;			//Running time
        System.out.printf("Quick sort takes: %.1f ms.", duration);
    }
}
