package com.bee;

import java.util.*;

public class QueueMessage {
    //Data = properties
    //Data Queue,
    char[] QM;
    int MAX ;
    int f,r; // front and rear// head, tail of queue
    QueueMessage(int M){
        MAX = M;  //Maxsize
        QM = new char[MAX];// new Array Queue base on max inside
        f = -1;// mark the front point of Q
        r = 0; // mark the rear last point of Q
    }

    int CountNum(){//this method way hase return
        if (f == r)
            return 0; // No element
        else
            return ((MAX - f)+ r) % MAX;// actual E quantity
    }

    void Enqueue(char x){ //add x to rear
        if (CountNum() == MAX -1)
            System.out.println("Queue is Full");
        else
        {
            QM[r] = x;//sing into last position then append rear
            //r++;
            //new feature
            r =(r+1) % MAX ;
            if (f == -1)
                f=0;
        }
    }

    char Dequeue(){ // remove
        char x = ' ';
        if(CountNum() == 0)
            System.out.println("Queue is Empty");
        else
        {
            x = QM[f]; // grape element at front
            f = (f + 1 ) %MAX;
        }
        return x;
    }

    int TranferText(String S){//send 250 element from S to D
        String D = "";
        int i = 0;
        int count =0;
        int space = 0;
        int word =0;
        int whitespaceCount = 0;
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
                while (i < S.length()){ //condition all case
                    //move elements from Source to Q respectively
                    while (CountNum() < MAX-1){//case1 keep moving element if Q is not Full
                        char c = S.charAt(i); //Grape element at I pos into Q
                        i = i +1;
                        Enqueue(c);//add C on array QM
                        if (i >= S.length())// All elements from Q are taken
                            break;
                    }
                    //after S is done but has some element left in Q
                    while (CountNum() > 0){//case2 Q is empty
                        char C = Dequeue();//remove all from QM message into temp C
                        D = D + C; //move element from C into D
                    }
                    count++;
                }
                System.out.println("\nDestination message1: \n"+ D);
                System.out.println("\nGive Q[Maximum]: " + MAX + " Size.");
                System.out.println("The buffer usage under given Max: " + count + " times.");
                //s+ is the space delimiter in java
                String[] wordList = S.split("\\s+");
                space += wordList.length;
                whitespaceCount += space -1; //get space as value -1
                word += S.length() - whitespaceCount;
                // char count= total num index - total space
                //System.out.println("Word's char no space: "+ word);
                // Check length, in characters
                System.out.println("Word's char length: " + S.length());

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
        QueueMessage QL = new QueueMessage(35);
        double start, finish, time, space2;
        double before, after, space;
        String S = "Firstly, for sending source message 1(SM1) to Destination message1, we has provided the input text’s data more than 250 chars, while overload the set up MAX of new QueueMessage(250); by this too much data kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkke";
        System.out.println("insert Source Message1: " + S);
        ///Scanner sc = new Scanner(System.in);p'
        //S = sc.nextLine();
        before =Runtime.getRuntime().freeMemory();//get free space in RAM before running
        start =System.currentTimeMillis();//get the system time at start
        //int count = QL.SendText(S);
        int count = QL.TranferText(S);//method being ren or execution
        finish =System.currentTimeMillis();//get the system time at End
        after =Runtime.getRuntime().freeMemory(); //get free space in RAM after RUn
        time = (finish -start)/ QL.MAX;
        space = before - after;
        space2 = QL.MAX*2;
        if(count > 0)//if number of buffer > 0
        {
            System.out.print("\nThe message is sent successfully.");
            System.out.printf("\nTime: %.10f ms", time);
            System.out.printf("\nSpace: %.10f byte", space);
            System.out.printf("\nSpace Buffer: %.1f byte", space2);
        }
        else System.out.print("\nThe message is not sent successfully.");

    }
}
