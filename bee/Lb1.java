package com.bee;
import java.util.Scanner;
public class Lb1 {
    // Method for getting the maximum value
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

    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of interger you want to store: ");
        //reading the number of elements from the that we want to enter
        n=sc.nextInt();
        //creates an array in the memory of length 10
        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++)
        {
        //reading array elements from the user
            array[i]=sc.nextInt();
        }
        System.out.println("Array elements are: ");
        // accessing array elements using the for loop
        for (int i=0; i<n; i++)
        {
            System.out.println(array[i]);
        }
        int max = getMax(array);
        System.out.println("Maximum Value is: "+max);

        // Calling getMin() method for getting min value
        int min = getMin(array);
        System.out.println("Minimum Value is: "+min);
    }

}
