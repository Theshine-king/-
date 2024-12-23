import java.util.Random;
import java.lang.*;
public class Video_023_QuickSort {
    public static void main(String[] args) {
        System.out.println("排序前的数组：");
        Random random = new Random();
        int size = random.nextInt(9);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            int number = random.nextInt(9);
            arr[i] = number;
        }
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        Qickqsort1(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("排序后的数组：");
        for (int i = 0;i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //快排1.0
    public static void Qickqsort(int[] arr,int l,int r) {
        if(l >= r) {
            return;
        }
        int x = arr[l + (int) Math.random() * (r - l + 1)];//生成l.......r范围上的随机数
        int mid = partition(arr,l,r,x);
        Qickqsort(arr, l, mid - 1);
        Qickqsort(arr, mid + 1, r);

    }
    //以x为划分
    //>= x 在左边  < x 在右边
    public static int partition(int[] arr,int l,int r,int x) {
        int xi = 0;
        int a = l;
        for(int i= l;i <= r;i++) {
            if(arr[i] <= x) {
            swap(arr,i,a);
            if(arr[a] == x) {
                xi = a;
            }
            a++;
        }
    }
        swap(arr,xi,a - 1);
        return a - 1;
    }
    
    
    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //快排2.0
    public static int first;
    public static int last;
    public static void Qickqsort1(int[] arr,int l,int r) {
        if(l >= r) {
            return;
        }
        int x = arr[l + (int) Math.random() * (r - l + 1)];//生成l.......r范围上的随机数
        partition1(arr, l, r, x);
        int left = first;
        int right = last;
        Qickqsort1(arr, l, left - 1);
        Qickqsort1(arr,right + 1,r);

    }
    public static void partition1(int[] arr,int l,int r,int x) {
        //设计两个区域  < 放左边 = 放中间  > 放右边
        first = l;//a区域从l开始
        last = r;//b区域丛r开始
        int i = l;
        while (i <= last) {
            if(arr[i] < x) {
                swap(arr, i++, first++);
            }
            //这里i不变的原因：我们无法得知交换过来的数与x的大小关系
            if(arr[i] > x) {
                swap(arr, i, last--);
            }
            if(arr[i] == x) {
                i++;
            }
        }
    }
}
