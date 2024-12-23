package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1046 {
    public static void main (String[] args) {
        int[] arr = {2,7,4,1,8,1};
        int[] arr1 = {1,1};
        int ans = lastStoneWeight(arr1);
        System.out.println(ans);
    }
    
    public static int lastStoneWeight(int[] arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
    for(int stone : arr) {
        pq.offer(stone);
    }
    while(pq.size() > 1) {
        int a = pq.poll();
        int b = pq.poll();
        if(a > b) {
            pq.offer(a - b);
        }
    }
    return pq.isEmpty() ? 0 : pq.poll();
}
    public static int lastStoneWeight1(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        //数组排序
        Arrays.sort(arr);
        for(int i = 0;i < arr.length;i++) {
            
        }
                return 0;
    }

    public static int Sum(int a,int b) {
        return a + b;
    }
}

