//数组小和问题

import java.util.Random;

public class Video_022_smallSum {
    public static void main (String[] args) {
        Random random = new Random();
        int size =  random.nextInt(9) + 1;
        int number = random.nextInt(9);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number;
        }
    }
    public static int smallSum(int[] arr,int l,int r) {
        if(l == r)
        return 0;

        int mid  = (l + r) / 2;
        return smallSum(arr, l, mid) + smallSum(arr, mid + 1, r) + merge(arr,l,mid,r);
    }
    public static int merge(int[] arr,int l,int m,int r) {

        //统计小和
        int result = 0;
        int ans = 0;
        for(int j = l,i = m + 1;i <= r;i++) {
            while(j <= m) {
                if(arr[j] <= arr[i]) {
                    ans += arr[j];
                }
                j++;
            }
            result += ans;
        }
        //merge
        int a = l;
        int b = m + 1;
        int i = l;
        int[] help = new int[arr.length];
        while(a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while(a <= m) {
            help[i++] = arr[a++];
        }
        while(b <= r) {
            help[i++] = arr[b++];
        }
        for(int j = l;j <= r;j++) {
            arr[j] = help[j];
        }
        return result;
    }
}


