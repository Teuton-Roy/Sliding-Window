/*  
    Longest Substring Without Repeating Characters

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
*/

import java.util.*;

public class Question7 {

    public static int All_Unique_Char(String str){
        
        int l = str.length();
        int start = 0;
        int end = 0;
        int count = -1; //if there is no unique character//

        HashMap<Character, Integer> map = new HashMap<>();

        while(end < l){

            Integer temp = map.get(str.charAt(end));

            map.put(str.charAt(end), (temp==null)?1 : temp+1);

            if(map.size() > end-start+1){  //this condition never hit because window_size(end-start+1) can't graeter than map.size()//
                end++;                     //But, follow the format of variable sized sliding window//
            }

            else if(map.size() == end-start+1){
                count = Math.max(count, end-start+1);
                end++;
            }

            else if(map.size() < end-start+1){
                while(map.size() < end-start+1){
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

        // int k;
        // System.out.println("Enter k: ");
        // k = sc.nextInt();

        int n = All_Unique_Char(str);
        System.out.println("Longest K unique characters substring: "+n);
    }
}
