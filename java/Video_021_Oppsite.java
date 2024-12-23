//归并分治实现
//再考虑一个问题时  问题可以转化为 --->  左部分之和 + 右部分之和 + 加上跨越左右之和
//可以考虑使用归并分治  

import java.util.Random;

public class Video_021_Oppsite {

    public static void main(String[] args) {
        //给定数组求反转对
        Random random = new Random();
        //定义数组长度
        int size = random.nextInt(9) + 1;
        int[] arr = {1,3,2,3,1};
        int l = 0;
        int r = arr.length - 1;
        int count = Oppsite(arr,l,r);
        System.out.println(count);
    }


    public static int Oppsite(int[] arr,int l,int r) {
        //对于数组中的下标总有 i < j 左下标 < 右下标
        //只需求出arr[i] > 2*arr[j]
        //对于一个数组arr反转对的数量等于左侧 + 右侧 + 跨左右
        if(l == r) {
            //当 l == r时不产生反转对；
            return 0;
        }
        int m = (l + r) / 2;
        return Oppsite(arr,l,m) + Oppsite(arr, m + 1, r) + merge(arr,l,m,r);
    }

    public static int merge(int[] arr,int l,int m,int r) {

        //计算反转对数量
        int count = 0;
        for(int i = l,j= m + 1;i <= m;i++) {
            while(j <= r && arr[i] > 2 * arr[j]) {
                j++;
            }
            count += j - m - 1;
        }
        // for(int i = l,j = m + 1;i <= m;i++) {
        //     for(;j <= r;j++) {
        //         if (arr[i] > 2 * arr[j]) {
        //             count++;
        //         }

        //     }
        // }
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
        return count;
    }
}
