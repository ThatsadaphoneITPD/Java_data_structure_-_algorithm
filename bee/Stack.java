package com.bee;
import java.util.*;

public class Stack {
    int MAX;
    int top;
    int[] S;
    Stack(int M)
    {
        MAX = M;
        S = new int[MAX]; // Maximum size of Stack
        top = -1;
    }

    boolean isFull() {//check if stack is full.
        return top == MAX;// false if Top equal max
    }
    boolean isEmpty() {//check if stack is empty.
        return top == -1;//false if top less than
    }

    void push(int x)
    {
        if (top >= (MAX - 1)) {// Checks if the stack is full. top more equal max-1index as 9=(10-1)
            System.out.println("\nStack Overflow or Full");
        }
        else {//If the stack is not full,
            S[++top] = x;
            //increments top to point next empty space
            //adds element to the stack, where top is pointing.
            System.out.println(x + " = in pushed into stack");
        }
    }

    int pop() //
    {
        if (top < 0) {//Checks if the stack is empty.
            System.out.println("\nStack Underflow");
            return 0;
        }
        else {// If the stack is not empty,
            // accesses the data element at which top is pointing.
            return S[top--];//move or Decreases the value of top by 1.
        }
    }

    int peek() // display top index in stack
    {
        if (top < 0) {//check if top less than 0
            System.out.println("Stack Peek");
            return 0;
        }
        else {//if top not less than
            return S[top]; // get the Top element of the stack, without removing it.
        }
    }
    void Input(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter Array num n= ");
        n = sc.nextInt();
        for (int i = 1 ; i <=n; i++){
            System.out.println("\n:Enter element in array X=");
            int x = sc.nextInt();
            push(x); //add an item to the queue
        }
    }
    void output() {
        for (int i = 0; i < MAX; i++)
            System.out.print(S[i]+" ");
    }
    void Convert(){//convert n to binary number
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter decimal n= ");
        n = sc.nextInt();
        while(n>0)
        {
            int r = n%2;

            // pushing the remainder inside the stack
            push(r);
            n/=2;
        }
        System.out.print("Binary equivalent: ");
        while (!(isEmpty()))
        {
            // printing the resultant binary number stored in the
            // stack in LIFO manner
            System.out.print(pop());
        }
    }

    //application of stack
    public static void main (String[]args){
        Stack s = new Stack(6);
        s.push(10);
        s.push(20);
        s.push(30);
        //s.Input();
        System.out.println("-----------");
        System.out.println("Popped out from stack: " + s.pop());
        //s.output();
        System.out.println("Top Peek of the stack: "+ s.peek());
        s.output();
        System.out.println("\n--");
        //s.Convert();
        //System.out.println(s);
        System.out.println(" stack Empty? "+ s.isEmpty());
        System.out.println(" stack Full? "+ s.isFull());
        s.output();
    }
}

