package com.bee;

import java.util.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class LinkList {//ADT Alist
    LinkedList<Integer> LL = new LinkedList<Integer>();
    int n; 			//Number of elements
    LinkList(){}
    LinkList(int size)		//Create a list with size elements
    {
        n = size;
    }

    //operation
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter E number N= ");
        int n = sc.nextInt();
        Random rd = new Random();
        for (int i = 0; i < n; i++) {//generate random number
            int x = rd.nextInt(100);
            LL.addFirst(x); //add random numbers to the list
        }
    }

    void output() {
        for (int i = 0; i < LL.size(); i++)
            System.out.print(LL.get(i) + ", ");
    }

    void Add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A number N= ");
        int ad = sc.nextInt();
        LL.add(ad);
        System.out.println("Size of ArrayList = " + LL.size());
    }

    void Del() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter delete x= ");
        int DE = sc.nextInt();
        LL.remove(DE);
        System.out.println("Size of ArrayList = " + LL.size());
    }

    void DelAll() {
        LL.removeAll(LL);
        // printing ArrayList
        System.out.println("\nAfter clear" + LL);
        // print size of ArrayList after clear list
        System.out.println("Size of ArrayList = " + LL.size());
    }

    public double sum(){
        double sum = 0;
        for(int i = 0; i < LL.size(); i++)
        {
            sum = sum + LL.get(i);
        }
        return sum;
    }

    void Max_Min(){
        System.out.println("Max element : " + Collections.max(LL));
        System.out.println("Min element : " + Collections.min(LL));
    }

    public static void main (String[]args){
        LinkList LL = new LinkList(10);
        LL.input();
        LL.output();
        LL.LL.addFirst(99);
        System.out.println("\nAfter adding 99 to the head: ");
        LL.output();
        LL.LL.addLast(98);
        System.out.println("\nAfter adding 98 to the head: ");
        LL.output();
        LL.LL.sort(null);
        System.out.println("\nAfter sorting: ");
        LL.output();
        LL.LL.sort(Comparator.reverseOrder());
        System.out.println("\nAfter sorting in Reverse Order: ");
        LL.output();
        LL.LL.sort(null);
        System.out.println("");
        System.out.println("Sorting E list: ");
        LL.Add();
        LL.output();
        LL.Del();
        LL.output();
        System.out.println("");
        System.out.println("Sum: "+ LL.sum());
        LL.Max_Min();
        LL.DelAll();
        LL.output();
    }
}

