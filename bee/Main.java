package com.bee;

import java.util.Scanner;

public class Main {
    //OOP = property and method

    int Sum(int x, int y)//claculate x + y // Operation = method
    {
        return x+y;
    }

    public static void main(String[] args) {
	// write your code here
        Main P = new Main();
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.printf("input a: ");
        a = sc.nextInt();
        System.out.printf("input b: ");
        b = sc.nextInt();
        System.out.printf("\nsum(%d, %d = %d) Good job dude", a, b,  P.Sum(a,b));
    }
}
