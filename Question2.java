/* 
    First negative integer in every window of size k
    Input : 
    N = 5
    A[] = {-8, 2, 3, -6, 10}
    K = 2
    Output : 
    -8 0 -6 -6
    Explanation :
    First negative integer for each window of size k
    {-8, 2} = -8
    {2, 3} = 0 (does not contain a negative integer)
    {3, -6} = -6
    {-6, 10} = -6
*/

import java.util.*;
public class Question2 {
    public static int[] FirstNegativeNumber(int[] arr, int n, int k){
        int start = 0;
        int end = 0;
        List<Integer> li = new ArrayList<>();

        while(end < n){
                if(arr[end] < 0){
                    li.add(arr[end]);
                }
                
                if(end-start+1 < k){
                    end++;
                }
                else if(end-start+1 == k){
                    //handel edge case//
                    if(li.isEmpty()){
                        System.out.print(" 0  ");
                    }
                    else{
                        System.out.print(li.get( 0 ));
                        if(arr[start] == li.get(0)){
                            li.remove(0);
                        }
                    }
                    start++;
                    end++;
                }
            }
        return arr;
        }
        public static void main(String[] args) {
            int[] arr = {-8, 2, 3, -6, 10};
            int n = arr.length;
            int k = 2;
            FirstNegativeNumber(arr, n, k);
        }
    }


    //add two//
    