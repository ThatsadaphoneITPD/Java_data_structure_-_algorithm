package com.bee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.bee.MergeSort.mergesort;
import static com.bee.QuickSort.quickSort;


public class SeletionSorte {
    int n;			//Size of array
    int A[];		//elements need to be sorted
    SeletionSorte(){}
    SeletionSorte(int size)
    {
        n = size;
        A= new int[n];	//Create array A size n
    }
    void Input()
    {
        Random rd = new Random();

        for(int i = 0; i< n; i++) {
            A[i] = rd.nextInt(100);    //generate random numbers from 0-99
        }
    }
    void Selection()
    {
        for(int i=0; i<n; i++)// 1st time loop n selection
        {
            //select min Element and swap with A[i]
            int min =i; //get min E position
            for (int j = i; j<n; j++)//2nd time  loop n
                if(A[j] < A[min])
                    min = j;		//min is element j
            if(min != i)
            { //Swap A[i] and A[min]
                int tmp = A[i];
                A[i] = A[min];
                A[min] = tmp;
            }
        }

    }

    public static void insertionSort(int A[]) {
        int n = A.length;
        for (int j = 1; j < n; j++) {
            int key = A[j];
            int i = j-1;
            while ( (i > -1) && ( A [i] > key ) ) {
                A[i+1] = A [i];
                i--;
            }
            A[i+1] = key;
        }
    }
    static void bubbleSort(int A[])
    {
        int n = A.length;
        for (int i = 0; i < n-1; i++)// select first index 0 in array i
            for (int j = 0; j < n-i-1; j++) // select next index 0 as index 1 in array j
                if (A[j] > A[j+1]) //compare if second item more than first
                {
                    // swap arr[j+1] and arr[j]
                    //temp is The temporary variable as the "parking space".
                    int temp = A[j];//second item exchange so formatting might not be great
                    A[j] = A[j+1];
                    A[j+1] = temp; // first item exchange so formatting might be great
                    /*The temp variable is used for switching between array[i] and array[j]
                    -we save array[i] to a temporary location,
                    overwrite it with array[j],
                    and then assign the value we set aside (in temp) to array[j].*/
                }
    }


    public static void main(String[] args) {
        SeletionSorte SS = new SeletionSorte(10000);//create new array
       double start, finish, time;
       double before, after, space;

       /*selection sort*/
        SS.Input();
        System.out.println("_______selection__sort______");
        //System.out.println("before selection");
        // System.out.println(Arrays.toString(SS.A));
        before =Runtime.getRuntime().freeMemory();//get free space in RAM before running
        start =System.currentTimeMillis();//get the system time at start
        SS.Selection();
        finish =System.currentTimeMillis();//get the system time at End
        after =Runtime.getRuntime().freeMemory(); //get free space in RAM after RUn
        time = finish -start;
        space = before - after;
        //System.out.println("after selection");
        //System.out.println(Arrays.toString(SS.A));
        System.out.printf("Time: %.1f ms", time);
        System.out.printf("\nSpace: %.1f byte", space);
        /// generate new array
        SS.Input();
        System.out.println(" ");
        System.out.println("_______Quick__sort______");
        //System.out.println("before Quicksort");
        //System.out.println(Arrays.toString(SS.A));
        before =Runtime.getRuntime().freeMemory();//get free space in RAM before running
        start =System.currentTimeMillis();//get the system time at start
        quickSort(SS.A, 0, SS.n - 1);
        finish =System.currentTimeMillis();//get the system time at End
        after =Runtime.getRuntime().freeMemory(); //get free space in RAM after RUn
        time = finish -start;
        space = before - after;
        //System.out.println("after selection");
        //System.out.println(Arrays.toString(SS.A));
        System.out.printf("Time: %.1f ms", time);
        System.out.printf("\nSpace: %.1f byte", space);
        /// generate new array
        System.out.println("__Given 100000 size of Elements_comparision Tome_____");
        SS.Input();
        System.out.println(" ");
        System.out.println("_______Merge__sort______");
        //System.out.println("before Mergesort");
        //System.out.println(Arrays.toString(SS.A));
        before =Runtime.getRuntime().freeMemory();//get free space in RAM before running
        start =System.currentTimeMillis();//get the system time at start
        mergesort(SS.A, 0, SS.n - 1);
        finish =System.currentTimeMillis();//get the system time at End
        after =Runtime.getRuntime().freeMemory(); //get free space in RAM after RUn
        time = finish -start;
        space = before - after;
        System.out.println("after Mergesort");
        System.out.println(Arrays.toString(SS.A));
        System.out.printf("Time: %.1f ms", time);
        System.out.printf("\nSpace: %.1f byte", space);
        //generate new
        SS.Input();
        System.out.println(" ");
        System.out.println("_______insertion__sort______");
        //System.out.println("before insertion sort");
        //System.out.println(Arrays.toString(SS.A));
        before =Runtime.getRuntime().freeMemory();//get free space in RAM before running
        start =System.currentTimeMillis();//get the system time at start
        insertionSort(SS.A);//sorting array using insertion sort
        finish =System.currentTimeMillis();//get the system time at End
        after =Runtime.getRuntime().freeMemory(); //get free space in RAM after RUn
        time = finish -start;
        space = before - after;
        //System.out.println("after insertion sort");
        //System.out.println(Arrays.toString(SS.A));
        System.out.printf("Time: %.1f ms", time);
        System.out.printf("\nSpace: %.1f byte", space);
        //generate new
        SS.Input();
        System.out.println(" ");
        System.out.println("_______bubble__sort______");
       // System.out.println("before bubble sort");
       // System.out.println(Arrays.toString(SS.A));
        before =Runtime.getRuntime().freeMemory();//get free space in RAM before running
        start =System.currentTimeMillis();//get the system time at start
        bubbleSort(SS.A);//sorting array using insertion sort
        finish =System.currentTimeMillis();//get the system time at End
        after =Runtime.getRuntime().freeMemory(); //get free space in RAM after RUn
        time = finish -start;
        space = before - after;
        //System.out.println("after bubble sort");
        //System.out.println(Arrays.toString(SS.A));
        System.out.printf("Time: %.1f ms", time);
        System.out.printf("\nSpace: %.1f byte", space);
    }
}
