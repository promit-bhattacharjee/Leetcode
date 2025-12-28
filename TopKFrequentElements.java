package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class Solution {
        public class Element implements Comparable<Element> {
            int val;
            int count;

            public Element(int val, int count) {
                this.val = val;
                this.count = count;
            }

            @Override
            public int compareTo(Element other) {
                // Sort by count descending
                return other.count - this.count;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            ArrayList<Element> map = new ArrayList();
            int max = 0;
            int result[] = new int[k];

            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            for (int key : freq.keySet()) {
                map.add(new Element(key, freq.get(key)));
            }
            Collections.sort(map);
            for (int i = 0; i <k; i++) {
                result[i] = map.get(i).val; 
            }
            
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new TopKFrequentElements().new Solution();
        int nums[] = {1,2,1,2,1,2,3,1,3,2,4,5,4,5,4 };
        int k = 2;
        int result[] = sol.topKFrequent(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
