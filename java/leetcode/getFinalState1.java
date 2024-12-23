package leetcode;

import java.util.PriorityQueue;

class getFinalState1 {
    public static void main(String[] args) {
        int[] gifts = {2, 1, 3, 5, 6};
        int k = 2;
        int[] ans = pickGifts(gifts, k);
        for(int i = 0;i < ans.length;i ++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < gifts.length; i ++) {
            heap.offer(gifts[i]);
        }
        for(int i = 0; i < k; i ++) {
            int max = heap.poll();
            heap.offer((int) Math.sqrt(max));
        }
        int[] res = new int[gifts.length];
        for(int i = 0; i < gifts.length; i ++) {
            res[i] = heap.poll();
        }
        return res;
    }    

}