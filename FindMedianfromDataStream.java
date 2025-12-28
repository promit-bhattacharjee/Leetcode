package LeetCode;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianFinder() {
            left = new PriorityQueue<>((a, b) -> b - a);
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            left.add(num);
            right.add(left.poll());
            if (left.size() < right.size()) {
                left.add(right.poll());
            }

        }

        public double findMedian() {
            int total = left.size() + right.size();
            if (total % 2 == 0) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }

    }

    public static void main(String[] args) {
        FindMedianfromDataStream out = new FindMedianfromDataStream();
        FindMedianfromDataStream.MedianFinder md = out.new MedianFinder();
        md.addNum(1); // arr = [1]
        md.addNum(2); // arr = [1, 2]
        md.addNum(5); // arr = [1, 2]
        // System.out.println(md.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        md.addNum(3); // arr[1, 2, 3]
        // md.addNum(4); // arr[1, 2, 3]
        md.addNum(7); // arr[1, 2, 3]
        // md.print();
        System.out.println(md.findMedian()); // return 2.0

    }
}
