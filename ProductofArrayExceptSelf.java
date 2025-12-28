package LeetCode;

public class ProductofArrayExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n];
            int[] postfix = new int[n];
            int[] result = new int[n];
            prefix[0]  = nums[0];
            postfix[n-1] = nums[n-1];
            int i = 1;
            int j = n - 2;
            int k=0;
            while (i< n) {
                prefix[i]=nums[i]*prefix[i-1];
                i++;
            }
            while (j>= 0) {
                postfix[j]=nums[j]*postfix[j+1];
                j--;
            }
            while(k<n){
                if(k==0){
                    result[k]=postfix[k+1];
                }
                else if(k==n-1){
                    result[n-1]=prefix[k-1];
                }else{

                    result[k]=prefix[k-1]*postfix[k+1];
                }
                k++;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Solution sol = new ProductofArrayExceptSelf().new Solution();
        int[] nums = {1,2,3,4};
        int[] result = sol.productExceptSelf(nums);
        System.out.println("Product of Array Except Self: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
