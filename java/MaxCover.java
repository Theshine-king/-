import java.util.Arrays;

public class MaxCover {
    public static void main(String[] args) {
        int[][] line = {{1,2},{2,3},{2,9},{1,6},{3,7}};
        int res = maxcover(line);
        System.out.println(res);
    }

    public static int maxcover(int[][] line) {
        //堆的清空
        size = 0;
        //按照开始位置排序
        int an = 0;
        Arrays.sort(line,(a,b) -> a[0]- b[0]);
        int ans = 0;
        for (int i = 0; i < line.length; i++) {
            while (size > 0 && heap[0] <= line[i][0]) {
            //小根堆有数 把小根堆里小于等于当前位置的数全弹出
            pop();
        }
            add(line[i][1]);//加入当前右边界
            ans = Math.max(ans, size);
    }
    return ans;
    }

    //小根堆  堆顶0位置
    public static int[] heap;

    //堆的大小
    public static int size;

    //堆的调整
    public static void add(int x) {
        heap[++size] = x;
        int i = size;
        while(heap[i] < heap[(i - 1) / 2] && i > 0) {
            swap(i,(i - 1) / 2);
        }
    }

    public static void pop() {
        //把小根堆里 第一个元素和最后一个元素交换
        swap(0,--size);
        //从0位置开始调整
        int i = 0;
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
            best = heap[i] > heap[best] ? i : best;
            if(i == best) {
                break;
            }
            swap(i, best);
            i = best;
            l = i * 2 + 1; 
        }

    }

    public static void swap(int i,int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


}
