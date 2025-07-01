import java.util.*;
class Solution {
    static List<Integer> Problem_3_Minimum_number_of_Coins(int N) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(5);
        ls.add(10);
        ls.add(20);
        ls.add(50);
        ls.add(100);
        ls.add(200);
        ls.add(500);
        ls.add(2000);
        List<Integer> ans = new ArrayList<>();
        
        int i = ls.size()-1;
        while(i >= 0){
            if(ls.get(i) <= N){
                N -= ls.get(i);
                ans.add(ls.get(i));
            }
            else if(ls.get(i) > N)
            i--;
        }
        return ans;
        
    }
}