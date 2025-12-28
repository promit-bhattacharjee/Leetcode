package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    class Solution {
        public void helper(int idx, int[] candidates, int target, List<Integer> ans,List<List<Integer>> li) {
            if (target<0) {
                return ;
            }
            if (target==0) {
                li.add(new ArrayList<>(ans));
                return;
            }
            for(int i=idx;i<candidates.length;i++){
                target-=candidates[i];
                ans.add(candidates[i]);
                helper(i, candidates, target, ans,li);
                ans.remove(ans.size()-1);
                target+=candidates[i];
  
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> li = new ArrayList<>();
            for(int i=0;i<candidates.length;i++){
                List<Integer> e= new ArrayList<>();
                helper(i, candidates, target, e,li);
                break;
            }
            return li;
        }
    }

    public static void main(String[] args) {
        CombinationSum out = new CombinationSum();
        CombinationSum.Solution sn = out.new Solution();
        int candidates[] = {
           2,3,7
        };
        int target = 18;
        List<List<Integer>> li = sn.combinationSum(candidates, target);
        for (List<Integer> e : li) {
            for (Integer i : e) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
