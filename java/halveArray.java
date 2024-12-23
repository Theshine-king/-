import java.util.PriorityQueue;

public class halveArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,7,6,7,3}; 
        int res = halveArray(nums);
        System.out.println(res);
    }
    public static int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((a,b) -> (b).compareTo(a));
        double sum = 0;
        for(int num : nums) {
            heap.add((double) num);
            sum += num;
        }

        sum /= 2;
        int ans = 0;
        for(double minus = 0,cur;minus < sum;ans++,minus += cur) {
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;
    }



    public static int halveArray1(int[] nums) {
        size = nums.length;
        long sum = 0;
        for(int i = size - 1;i >= 0;i--) {
            //进堆
            heap[i] = (long) nums[i] << 20;
            sum += nums[i]; 
            heapify(i);
        }
        sum/= 2;
        //每次弹出堆顶元素 然后把堆顶元素的值减半再进堆
        int ans = 0;
        for(long minus = 0;minus < sum;ans++) {
            heap[0] /= 2; 
            minus += heap[0];
            heapify(0);
        }
        return ans;     
            
    }
    //堆的大小
    public static int size;
    public static int MAXN = 100001; 
    public static long[] heap = new long[MAXN];

    public static void heapify(int i) {
        int l = i * 2 + 1;//左孩子
        while(l < size) {
            int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
            best = heap[i] > heap[best] ? i : best;
            if(best == i) {
                break;
            }
            swap(i,best);
            i = best;
            l = i * 2 + 1;
        }
    }


    public static void swap(int i,int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
