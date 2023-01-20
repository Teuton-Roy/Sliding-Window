/*
    Max Sum Subarray of size K

    Input:
    N = 4, K = 2
    Arr = [100, 200, 300, 400]
    Output:
    700
    Explanation:
    Arr3  + Arr4 =700,
    which is maximum.
*/

import java.util.*;


public class Questions1{

    public static int Max_Sum(int[] arr, int n, int k){
        int start = 0;
        int end = 0;
        int sum = 0;
        int maximum = Integer.MIN_VALUE;
    
        while(end < n){
            sum += arr[end];
    
            if(end - start + 1 < k){
                end++;
            } 
            else if(end - start + 1 ==k){
                maximum = Math.max(maximum, sum);
                sum -= arr[start];
    
                end++;
                start++;
            }
        }
        return maximum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
            int n;
            System.out.println("Enter how many number you want");
            n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter array elements: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int k;
            System.out.println("Enter window sixe: ");
            k = sc.nextInt();

            n = Max_Sum(arr, n, k);
            System.out.println("Max Sum Subarray of size K: "+n);
        }
    }
//}
