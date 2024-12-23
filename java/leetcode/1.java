package leetcode;

import java.util.PriorityQueue;

public class 1 {
        public int minOperations(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a - b); 
        while(heap.peek() < k) {
            if(nums.length == 0 || nums.length < 2) {
                return 0;
            }
            if(nums.length >= 2) {
                for(int num : nums) {
                    heap.add(num);
                }
                int ans = 0;
                while(heap.peek() < k) {
                    int x = heap.poll();
                    int y = heap.poll();
                    heap.offer(Math.min(x,y) * 2 + Math.max(x,y));
                    ans++;
                }
                return ans;
            }
            return 0;
        }
}
