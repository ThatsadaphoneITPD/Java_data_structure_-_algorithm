package com.bee;

import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    int Arr[] = new int [size];
    static final int size = 10;
    int n;

    void Sum() {
        System.out.println("Enter the required size of the array :: ");
        Scanner N = new Scanner(System.in);
        int size = N.nextInt();
        int sum = 0;
        System.out.println("Enter the elements of the array one by one ");
        //sum method
        for (int i = 0; i < size; i++) {
            Arr[i] = N.nextInt();
            sum = sum + Arr[i];
        }
        output();
        System.out.print("\n--- ");
        System.out.println("Sum "+ sum);
    }

    static int Rsum(int n)
    {// Stop condition
        if (n == 0)
            return 0;
        // Stop condition
        if (n == 1 || n == 2)
            return 1;
            // Recursion function
        else
            return (Rsum(n - 1) + Rsum(n - 2));
    }
    int pop() //
    {
        int x = Arr[n--];// remove the top
        return x;
    }
    boolean push(int x)
    {
            Arr[++n] = x; //put x to the top of stack
            return true;
    }
    static int find(int decimal_number)//find binary by recursion method
    {
        if (decimal_number == 0)
            return 0;

        else
            return (decimal_number % 2 + 10 *
                    find(decimal_number / 2));
    }

    void output() {
        for (int i = 0; i < size; i++)
            System.out.print(Arr[i] + " ");
    }

    public static void main(String args[]) {
        Recursion Rec = new Recursion();
        Rec.Sum();
        System.out.print("Fibonacci series of 5 numbers is: ");
        // for loop to print the Rsum series.
        int n = 5;
        int s = 0;
        for (int i = 0; i < n; i++)
        {
            s = s + Rsum(i);
            System.out.print(Rsum(i)+" ");
        }
        System.out.println("\n Sum Recursion: "+ s);
        System.out.println("\nBinary equivalent: "+ find(s));
    }
}
