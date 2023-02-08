/*
    Longest subarray of sum k

    Input:
    n=7;
    k=5;
    arr = {4, 1, 1, 1, 2, 3, 5};

    output:
    4

    Explalation
    4+1 = 5  size=2,
    1+1+1+2 = 5  size=4,
    2+3 = 5  size=2,
    5 = 5  size=1,

    largest = 4.
*/


import java.util.*;
public class Question5 {
    public static int Longest_Subarray(int[] arr, int n, int k){
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while(end < n){

            sum += arr[end];

            if(sum < k){
                end++;
            }
            
            else if(sum == k){
                // if(end-start+1 > max){
                //     max = end-start+1;
                // }

                max = Math.max(end-start+1, max);

                end++;
            }

            else if(sum > k){
                while(sum > k){
                    sum -= arr[start];
                    start++;
                }
                end++;
            }
        }
        return max;
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            System.out.println("Enter the size of array: ");
            n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter the array elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int k;
            System.out.println("Enter the sum as k:");
            k = sc.nextInt();

            n = Longest_Subarray(arr, n, k);
            System.out.println("Longest subarry of sum k is: "+n);
        }
    }
}
