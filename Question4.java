/*
    Maximum of all sub-array of size k

    Input:
    N=8, K=3
    arr[] = (1, -3, -1, 3, 5, 3, 6, 7)
    Output:
    3, 3, 5, 5, 6, 7
*/


import java.util.*;

public class Question4 {

    public static int[] Max_subarray(int[] arr, int n, int k){
        int start = 0;
        int end = 0;
        int ans[] =  new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        while(end < n){
            if(dq.size() == 0){
                dq.add(arr[end]);
            }
            else{
                while(dq.size() > 0 && dq.peekLast() < arr[end]){
                    dq.removeLast();
                }
                dq.add(arr[end]);
            }

            if(end - start + 1 <k){
                end++;
            }
            else if(end - start + 1 == k){
                ans[start] = dq.peek();
                if(arr[start] == dq.peek()){
                    dq.removeFirst();
                }
                start++;
                end++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 4, 5, 6, 7, 8};
        int n = arr.length;
        int k = 3;
        int ans[] = Max_subarray(arr, n, k);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
