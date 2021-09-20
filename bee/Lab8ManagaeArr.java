package com.bee;


import java.util.*;

public class Lab8ManagaeArr {

    static int[] arr = new int[10];
    //operation
    void input() {

        System.out.println("Random N into Array :: ");
        Random rd = new Random();
        //sum method
        for(int i=0; i< arr.length; i++){
            arr[i] = rd.nextInt(100);
        }
    }
    void output() {
        for (int i = 0; i < arr.length ; i++)
            System.out.print(arr[i] + " " );
    }
    //sequential search is made over all items one by one.
    // Every item is checked and if a match is found
    // then that particular item is returned,
    // this method makes a linear search.
    static int Linearfind(int data) {
        int comparisons = 0;
        int index = -1;
        int i;
        // navigate through all items
        for(i = 0;i< arr[i];i++) {
            // count the comparisons made
            comparisons++;
            // if data found, break the loop
            if(data == arr[i]) {
                index = i;
                break;
            }
        }
        System.out.printf("Total comparisons made: %d", comparisons);
        return index;
    }
    void SearchLoop(){
        Scanner scan=new Scanner(System.in);
        System.out.println("\nEnter Key Binary loop search:");
        int key=scan.nextInt();
        int flag=0;
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(key<arr[mid])
            {
                high=mid-1;
            }
            else if(key>arr[mid])
            {
                low=mid+1;
            }
            else if(key==arr[mid])
            {
                flag++;
                System.out.println("Loop found at index:"+mid);
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("Loop Not found");
        }

    }

    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int RecursiveBinarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return RecursiveBinarySearch(arr, l, mid - 1, x);
            // Else the element can only be present
            // in right subarray
            return RecursiveBinarySearch(arr, mid + 1, r, x);
        }
        // element is not present in array
        return -1;
    }


    public static void main (String[]args){
        Lab8ManagaeArr A = new Lab8ManagaeArr();
        A.input();
        A.output();
        //find location of 1
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter X Linear search in index= ");
        int X = sc.nextInt();
        int location = Linearfind(X);

        // if element was found
        if(location != -1)
            System.out.printf("\nLinear found at location: %d" ,(location+1));
        else
            System.out.printf("Linear not found.");
        //sort array
        Arrays.sort(arr);
        System.out.println("\nSorting Arr: ");
        A.output();
        //binary loop search
        A.SearchLoop();
        //recursive search
        int N = arr.length;
        System.out.print("Enter X recursive search= ");
        int x = sc.nextInt();
        int index = A.RecursiveBinarySearch(arr, 0, N - 1, x);
        if (index == -1)
            System.out.println("Recursive not present");
        else
            System.out.println("Recursive found at index " + index);

    }

}
