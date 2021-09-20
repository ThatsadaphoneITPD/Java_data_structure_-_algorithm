package com.bee;
///import java.util.ArrayList;
///import java.util.Collections;
///import java.util.LinkedList;
///import java.util.Queue;
import java.util.*;

public class Arraylistmessage {
    //Data = properties
    ArrayList<Character> A = new ArrayList<Character>();//sending buffer
    Queue<Character> Q = new LinkedList<Character>();//Receiving Buffer
    int MAX;
    Arraylistmessage (){};
    public Arraylistmessage(int size) //Create a list with size elements
    {
        MAX = size;

    }

    /*int CountNum(){//this method way hase return
        int Size =A.size();
        if (Size == 0)
            return 0; // No element
        else
            return A.size() % MAX;// actual E quantity
    }*/

    int sendText(String S){//send 250 element from S to D
        String D = "";
        //StringBuilder D = new StringBuilder();// same String = "" ToString as D = D +DM
        int i = 0;
        int j =0;
        char C;
        int count = 0;
        if (S.length() <= 0){
            System.out.println("Queue in Empty. insert more");
            return 0;
        }
        else if (S.length() >250){
            System.out.println("too much than 250 element, can't send, try again");
            return 0;
        }

        else{
            try {
                while (i < S.length()) { //condition all case
                    //move elements from Source to Q respectively
                    while (!S.isEmpty()) {//(true or CountNum() < Max) case1 keep moving element if A is not Full
                        C = S.charAt(i); // get all i item char from String S into temp C
                        i++;//increase all item index
                        A.add(C);//add temp C into arraylist A
                        if (i >= S.length())// All elements from S are taken
                            break;
                    }
                    //after S is done but has some element left in A
                    while (!A.isEmpty()) {//(CountNum() < Max)case2 A is empty
                        char X = A.get(0);//get all char item index at first Element into temp X
                        A.remove(0);//remove and delete all item index 0
                        //old way
                        Q.add(X);//add X into Q
                        //System.out.print(X);
                    }
                    while (!Q.isEmpty()) {//case3 Q is more than 0 (CountNum > 0)or not empty
                        char DM = Q.poll();//poll() as get item out and delete element all from Q link list then Q have not thing
                        D = D + DM;//D.append(DM);//add data to string destination Message
                        //System.out.print(DM);
                    }
                    count++;// buffer is sent of D as count = 1 as working trigger
                }

                System.out.print("\nA: isEmpty A's item send by temp X to Q ");
                for (Character DA : A) { System.out.print(DA);}
                System.out.print("\nQ: IsEmpty Q's item send by temp DM to D ");
                for (Character DE : Q) { System.out.print(+ DE);}
                System.out.println("\n\nDestination message1: \n"+ D);
            }
            catch (Exception e)
            {
                System.out.println("\nQueue Error: "+ e);
                //get report text by println except of q is Empty or much than 250
                return 0;
            }
            return count;
        }
    }
    public static void main (String[]args){
        Arraylistmessage EL = new Arraylistmessage( 10);
        double start, finish, time, space2;
        double before, after, space;
        String S = "Firstly, for sending source message 1(SM1) to Destination message1, we has provided the input text’s data more than 250 chars, while overload the set up MAX of new QueueMessage(250); by this too much data kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkke";
        System.out.println("insert Source Message1: \n" + S);
        ///Scanner sc = new Scanner(System.in);
        //S = sc.nextLine();
        before =Runtime.getRuntime().freeMemory();//get free space in RAM before running
        start =System.currentTimeMillis();//get the system time at start
        //int count = EL.SendText(S);
        int count = EL.sendText(S);//method being run or execution
        finish =System.currentTimeMillis();//get the system time at End
        after =Runtime.getRuntime().freeMemory(); //get free space in RAM after RUn
        time = (finish -start)/ EL.MAX;
        space = before - after;
        space2 = EL.MAX*2;
        // Check length, in characters
        if(count > 0)//if number of buffer > 0
        {
            System.out.print("\nThe message is sent successfully.");
            System.out.print("\nThe buffer usage under given Max: " + count + " times.");
            System.out.print("\nWord's char length: " + S.length());
            System.out.printf("\nTime: %.1f ms", time);
            System.out.printf("\nSpace: %.1f byte", space);
            System.out.printf("\nSpace Buffer: %.1f byte", space2);
        }
        else
            System.out.println("\nThe message is not sent successfully.");
    }
}
