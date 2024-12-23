package leetcode;

public class getFinalState {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 2;
        int multiplier = 2;
        getFinalState obj = new getFinalState();
        int[] ans = obj.getFinalState(nums, k, multiplier);
        for(int i = 0;i < ans.length;i ++) {
            System.out.print(ans[i] + " ");
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        for(int j = 0;j <= k;j ++) {
            //找到最小值
            int m = 0;
            for(int i = 0;i < nums.length;i ++) {
                if(nums[i] < nums[m]) {
                    m = i;
                }
            }
            nums[m] *= multiplier;
        }
        return nums;
    }
}
