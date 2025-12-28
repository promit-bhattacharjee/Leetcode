package LeetCode;

public class ReverseBits {
    class Solution {

        public void intToBinary(int n, String remaining) {
            if (n == 1) {
                remaining = n + remaining;
                return;
            }
            remaining = n % 2 + remaining;
            intToBinary(n / 2, remaining);
        }

        public int reverseBits(int n) {
            String remaining = "";
            intToBinary(n, remaining);
            System.out.println(remaining);
            return 1;
        }
    }

    public static void main(String[] args) {
        ReverseBits out = new ReverseBits();
        ReverseBits.Solution sn = out.new Solution();
        sn.reverseBits(43261596);
    }
}
