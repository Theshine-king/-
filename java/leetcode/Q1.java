package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1 {
    public static void main(String[] args) {
        int[] nums = {6,7,8,9};
        int[] nums1 = {1,2,3,4,2,3,3,5,7};
        int res = minimumOperations(nums1);
        System.out.println(res);
    }
    if()
    public static int minimumOperations(int[] nums) {
        //检查所有元素互不相同
        //定义步长
        int n = nums.length;
        int l = 0, r = n - 1;
        int ans = 0;
        for(int step = 0;step < n;step += 2) {
            if(l < r && nums[l] != nums[l + 1]) { //跳空
                //不跳空
                l = step;
                ans++;
            }
        }
        //检查剩下的元素是否相同如果相同返回ans+1不相同返回ans
        for(int i = l;i <= r;i++) {
            if(nums[i] != nums[i + 1]) {
                return ans;
            }
        }
        return ans + 1;                                                           

    }
    
}
