package com.bee;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    void Fequal(float a, float b)// ax + b= 0
    {
        if (a ==0)
            if (b == 0)
                System.out.printf("\n%.1fx + %.1f = 0 has un-countatable solution. ", a, b);
            else
                System.out.printf("\n%.1fx + %.1f = 0 has no solution.", a, b);
        else
            System.out.printf("\n%.1fx + %.1f = 0 has a solution. x = %.1f", a, b ,(-b/a));
    }
    void Sequal(float a, float b, float c)
    {
        if (a==0)
            Fequal(b,c);
        else
        {
            float delta = b*b - 4*a*c;
            if(delta < 0)
                System.out.printf("\n%.1fx2 + %.1f + %.1f = 0 NO solution", a , b, c);
            else
                if(delta == 0)
                {
                    System.out.printf("\n%.1fx2 + %.1f + %.1f = 0 NO 1 solution", a , b, c);
                    System.out.printf("\n x1 = x2 %.1f", (-b)/(2*a));
                }
                else
                {
                    System.out.printf("\n%.1fx2 + %.1f + %.1f = 0 NO 2 solution", a , b, c);
                    System.out.printf("\n x1 = %.1f ", (-b - Math.sqrt(delta))/(2*a));
                    System.out.printf("\n x1 = %.1f ", (-b + Math.sqrt(delta))/(2*a));
                }
        }

    }
    int Max(int a, int b, int c){
        int max = a;
        if(b >max)
            max =b;
        if(c >max)
            max = c;
        return max;
    }
    public static void main(String[] args) {
        Main2 P = new Main2();// create an object belonging to Main class
        float a, b, c;
        Scanner sc = new Scanner(System.in);//input libary
        System.out.printf("input a: ");
        a = sc.nextInt();
        System.out.printf("input b: ");
        b = sc.nextInt();
        System.out.printf("input c: ");
        c = sc.nextInt();
       // P.Fequal(a, b); //call Fequal operation of object
        P.Sequal(a, b, c);//call Sequal operation of object
        int x =4 , y= 8 , z =2;
        System.out.printf("\nMax(%d + %d + %d) = %d", x, y ,z , P.Max(x,y,z));
    }
}
