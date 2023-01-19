/*
    Count Occurences of Anagrams

    Input:
    txt = forxxorfxdofr
    pat = for

    Output: 3
    Explanation: for, orf and ofr appears
    in the txt, hence answer is 3.
*/

import java.util.*;

public class Question3 {
    public static int search(String txt, String pat){
        int start = 0;
        int end = 0;
        int count = 0;
        int ans = 0;
        int k = pat.length();

        HashMap<Character, Integer> map = new HashMap<>();
        //put all pat in map
        for(int i = 0; i < pat.length(); i++){
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        while(end < txt.length()){
            char ch = txt.charAt(end);
            
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) >= 0){
                    count++;
                }
            }

            if(end-start+1 < k){
                end++;
            }
            else if(end-start+1 == k){
                if(count == k){
                    ans++;
                }
                char ch2 = txt.charAt(start);
                if(map.containsKey(ch2)){
                    if(map.get(ch2) >= 0){
                        count--;
                    }
                    map.put(ch2, map.get(ch2)+1);
                }
                start++;
                end++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String txt = "aaaabaabbbbaabababababaabababababababababababababababababababababbbaaaabbbaba";
        String pat = "aaba";
        System.out.println(search(txt, pat));
    }
}
