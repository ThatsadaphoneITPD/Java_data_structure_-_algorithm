package com.bee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LB {
    public static int getMax(int[] inputArray){
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    // Method for getting the minimum value
    public static int getMin(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }


    public static void main(String args[]){
        System.out.println("Enter the required size of the array :: ");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int myArray[] = new int [size];
        int sum = 0;
        System.out.println("Enter the elements of the array one by one ");
        //sum method
        for(int i=0; i<size; i++){
            myArray[i] = s.nextInt();
            sum = sum + myArray[i];
        }
        //average method
        double average = sum / size;
        System.out.println("Elements of the array are: "+ Arrays.toString(myArray));
        int max = getMax(myArray);
        System.out.println("Maximum Value is: "+max);
        // Calling getMin() method for getting min value
        int min = getMin(myArray);
        System.out.println("Minimum Value is: "+min);
        System.out.println("Sum of the elements of the array ::"+sum);
        System.out.format("The average is: %.1f", average);
    }
}
