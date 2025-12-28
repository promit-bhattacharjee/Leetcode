package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Three_Sum {
    class Solution {
        public int[] sort(int nums[]) {
            boolean frage = false;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        frage = true;
                    }
                }
                if (!frage) {
                    break;
                }
            }
            return nums;
        }

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 1) {
                return null;
            }
            List<List<Integer>> list = new ArrayList<>();
            nums = sort(nums);
            int left, right;
            for (int i = 0; i < nums.length - 2; i++) {
                int x = nums[i];
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    int y = nums[left];
                    int z = nums[right];
                    int sum = x + y + z;
                    if (sum == 0) {
                        list.add(new ArrayList<>(Arrays.asList(x, y, z)));
                        while (left < right && nums[left] == y)
                            left++;
                        while (left < right && nums[right] == z)
                            right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }

                }

            }
            return list;
        }

    }

    public static void main(String[] args) {
        Three_Sum out = new Three_Sum();
        Three_Sum.Solution sn = out.new Solution();
        int nums[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> li = sn.threeSum(nums);
        for (List ll : li) {
        System.out.println(ll);
        }
    }
}
