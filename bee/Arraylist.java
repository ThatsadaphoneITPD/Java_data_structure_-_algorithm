package com.bee;

import java.util.*;

public class Arraylist {//ADT Alist
    //Data = properties
    ArrayList<Integer> E = new ArrayList<Integer>();

    //operation
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter E number N= ");
        int n = sc.nextInt();
        Random rd = new Random();
        for (int i = 0; i < n; i++) {//generate random number
            E.add(rd.nextInt(n));
        }
    }

    void output() {
        for (int i = 0; i < E.size(); i++)
            System.out.print(E.get(i) + ", ");
    }

    void Add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A number N= ");
        int ad = sc.nextInt();
        E.add(ad);
        System.out.println("Size of ArrayList = " + E.size());
    }

    void Del() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter delete x= ");
        int DE = sc.nextInt();
        E.remove(DE);
        System.out.println("Size of ArrayList = " + E.size());
    }

    void DelAll() {
        E.removeAll(E);
        // printing ArrayList
        System.out.println("\nAfter clear" + E);
        // print size of ArrayList after clear list
        System.out.println("Size of ArrayList = " + E.size());
    }

    public double sum(){
        double sum = 0;
        for(int i = 0; i < E.size(); i++)
        {
            sum = sum + E.get(i);
        }
        return sum;
    }

    void Max_Min(){
        System.out.println("Max element : " + Collections.max(E));
        System.out.println("Min element : " + Collections.min(E));
    }

    public static void main (String[]args){
        Arraylist EL = new Arraylist();
        EL.input();
        EL.output();
        EL.E.sort(null);
        System.out.println("");
        System.out.println("Sorting E list: ");
        /*EL.output();
        EL.E.sort(Comparator.reverseOrder());
        System.out.println("");
        System.out.println("reverse order: ");
        EL.output();*/
        EL.Add();
        EL.output();
        EL.Del();
        EL.output();
        System.out.println("");
        System.out.println("Sum: "+ EL.sum());
        EL.Max_Min();
        EL.DelAll();
        EL.output();
    }
}

