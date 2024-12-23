public class Video_025_HeapSort {
    public static void main(String[] args) {
        int[] arr = {8,3,4,3,2,6};
        heapSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
//堆结构
//i位置数父亲节点 (i - 1) / 2
//i位置数子节点  左孩子  i * 2 + 1   右孩子  i * 2 + 2
//向上看  i位置的数向上调整大根堆
//i位置的变大了  -->  向上调整大根堆
    public static void heapInsert(int[] arr,int i) {
        while(arr[i] > arr[(i - 1) / 2]) {
            swap(arr,i,(i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    //向下调整大根堆
    //i 位置的变小了  --->  向下看
    public static void heapify(int[] arr,int i,int size) {
        int l = 2 * i + 1;//左孩子位置
        while (l < size) {
            //评选最大孩子的下标
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;//有右孩子 && 右孩子的值大于左孩子的值
            best = arr[i] > arr[best] ? i : best;
            if(i == best) {
                break;
            }
            swap(arr,i,best);
            i = best;
            l = 2 * i + 1;//继续向下查找
        }
    }
    //复杂度分析  O(N * logN)


    //堆排序
    //从顶到底建堆复杂度 O(N * logN)
    //整体复杂度 O(N * logN)
    //如何估计复杂度？
    //对于一个数组[0,1,2,3,4,5,6,......] 建堆时单次调用时的复杂度为 logN
    //则建堆复杂度为 log1 + log2 + log3 + ... + logN
    //调整复杂度为 logN + logN - 1  + .... + log1(调整每次抹掉一个数)
    // log1 + log2 + log3 + ... + logN 收敛于 N * logN
    //证明：常量倍增法
    //如果数据量为  N  复杂度的上限为N * logN
    //那么数据量为2N时  复杂度的下限也为N * logN (数据量翻有限的常数倍不会影响复杂度)
    //则复杂度为N * logN
    public static void heapSort(int[] arr) {
        //第一步  建堆
        int n = arr.length;
        for(int i = 0;i < n;i++) {
            heapInsert(arr, i);
        }
        //第二步 交换 + 调整
        //复杂度 O(N * logN)
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }


    //从底到顶建堆
    //建堆复杂度O(n)
    //调整复杂度O(N * logN)
    //整体复杂度O(N * logN)
    public static void heapSort1(int[] arr) {
        int n = arr.length;
        for(int i = n - 1;i >= 0;i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
    }
}
//为什么 从底到顶 建堆复杂度优于            从顶到底
//      大部分的数 （向下沉）             大部分的数（向上飘）
//      小部分代价                       大部分代价



    public static void swap (int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
