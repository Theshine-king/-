public class Video_024_RandomizedSelect {
    public static void main (String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int ans = findKthLargest(arr,2);
        System.out.println(ans);
    }
    public static int first;
    public static int last;
    public static int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums,nums.length - k);
    }
    //array第i位置数是几
    public static int randomizedSelect(int[] arr,int i) {
        int ans = 0;
        for(int l = 0,r = arr.length - 1;l <= r;) {
            partition(arr,l,arr[l + (int) Math.random() * (r - l + 1)],r);
            if(i < first) {
                r = first - 1;
            }
            else if(i > last) {
                l = last + 1;
            }
            else {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }
    public static void partition(int[] arr,int l,int x,int r) {
        first = l;
        last = r;
        int i = l;
        while(i <= last) {
            if(arr[i] < x) {
                swap(arr,i++,first++);
            }
            else if(arr[i] > x) {
                swap(arr,i,last--);
            }
            else {
                i++;
            }
        }
    }
    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}