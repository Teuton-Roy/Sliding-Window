/*
    Longest K unique characters substring.

    Input:
    S = "aabacbebebe", K = 3

    Output: 7
    
    Explanation: "cbebebe" is the longest 
    substring with K distinct characters.

*/


import java.util.*;

public class Question6 {
    public static int Unique_Char(String str,int k){
        
        int l = str.length();
        int start = 0;
        int end = 0;
        int count = -1; //if there is no unique character//

        HashMap<Character, Integer> map = new HashMap<>();

        while(end < l){

            Integer temp = map.get(str.charAt(end));

            map.put(str.charAt(end), (temp==null)?1 : temp+1);

            if(map.size() < k){
                end++;
            }

            else if(map.size() == k){
                count = Math.max(count, end-start+1);
                end++;
            }

            else if(map.size() > k){
                while(map.size() > k){
                    map.put(str.charAt(start), map.get(str.charAt(start))-1);
                    if(map.get(str.charAt(start))==0){
                        map.remove(str.charAt(start));
                    }
                    start++;
                }
                end++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Enter string: ");
        str = sc.nextLine();

        int k;
        System.out.println("Enter k: ");
        k = sc.nextInt();

        int n = Unique_Char(str, k);
        System.out.println("Longest K unique characters substring: "+n);
    }
}
