package com.bee;

import java.util.*;

public class queue {
    int[] Q;
    int MAX ;
    int f,r; // front and rear// head, tail of queue
    queue(int M){
        MAX = M;
        Q = new int [MAX];
        f = r = 0;// head as f and tail as r
    }

    int CountNum(){//this method way hase return condition of available n in Q
        if (f == r)
            return 0;//get 0
        else
            return ((MAX - f)+ r) % MAX;
        //removes one and returns that element from the head of queue
        //then Count gives the number of actual elements present in queue.
    }

    void Enqueue(int x){ //add x to rear
        if (CountNum() == MAX -1)//if the queue is full nor front is greater than rear or MAX
            System.out.println("Queue is Full");
        else
        {
            Q[r] = x;//append rear or Add element to Q, where the rear is pointing.
            r ++;// increment rear pointer to point the next empty space.
        }
    }

    int Dequeue(){ // remove
        int x = -1;
        if(CountNum() == 0)//Check if the queue is empty
            System.out.println("Queue is Empty");
        else//If the queue is not empty
        {
            x = Q[f]; //access the data where front is pointing
            f = f + 1;//Increment front pointer to point to the next available data element.
        }
        return x;
    }
    void Input(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter Array num n= ");
        n = sc.nextInt();
        for (int i = 1 ; i <=n; i++){
            System.out.print("Enter element in array X= ");
            int x = sc.nextInt();
            Enqueue(x); //add an item to the queue
        }
    }
    void  output(){
        for(int i = f; i< r; i ++)
            System.out.print(Q[i] + " ");
    }
    boolean isFull() {//if rear equals to MAXSIZE return T&F
        return r == MAX - 1;
    }

    // Queue is empty when size is 0
    boolean isEmpty() {//if front is less than MIN  OR front is greater than rear return T&F
        return f < 0 || f > r;
    }

    // Method to get front of queue
    int front()
    {
        if (isFull())
            return Integer.MAX_VALUE; //get available head index in Q

        return Q[f];
    }

    // Method to get rear of queue
    int rear()
    {
        if (isEmpty())
            return Integer.MIN_VALUE;//get available Tail index in Q

        return Q[r-1];
    }

    public static void main (String[]args){
        queue QL = new queue(10);
        QL.Enqueue(1);
        QL.Enqueue(2);
        QL.Enqueue(3);
        QL.Enqueue(4);
        QL.output();
        QL.Input();
        QL.output();
        System.out.println("\n--");
        System.out.println("Dequeue is "+ QL.Dequeue());
        QL.output();
        System.out.println("\nFront Head item is " + QL.front());
        System.out.println("Rear Tail item is " + QL.rear());
        System.out.println(" Queue Empty? "+ QL.isEmpty());
        System.out.println(" Queue Full? "+ QL.isFull());
        QL.output();
    }
}
