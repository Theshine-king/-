import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class Vedio_027_MergeKSortList {

    //合并k个有序链表   堆排法
    //复杂度分析
    //假设我有k条链表，其中包括N个节点
    //每次进堆的节点数为链表的条数 O(logk)
    //串节点的复杂度为  O(N)
    //整体复杂度为O(N * logk)
    //空间复杂度为 O(K)
    //每次进堆的数为K个
public static ListNode MergeKSortList(ArrayList<ListNode> arr) {
    PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);//小根堆
    for(ListNode h : arr) {
        if(h != null) {
            heap.add(h);
        }
    }

    if(heap.isEmpty()) {
        return null;
    }

    ListNode h = heap.poll();
    ListNode pre = h;//串起所有节点
    if(pre.next !=null) {
        heap.add(pre.next);
    }
    while (!heap.isEmpty()) {
        ListNode cur = heap.poll();
        pre.next = cur;
        pre = cur;//串起所有的节点
        if(cur.next != null) {
            heap.add(cur.next);
        }
    }
    return h;
}

    //暴力解法
    public static ListNode mergeKSortList1(ListNode[] arr) {
        if (arr == null || arr.length == 0) return null;
    
        ListNode dummy = new ListNode(0, null); // 创建一个虚拟头节点
        ListNode cur = dummy; // 使用cur来构建新的合并链表
    
        while (true) {
            ListNode minNode = null;
            int minIndex = -1;//最小值索引
            // 找出所有链表中最小的节点
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null && (minNode == null || arr[i].val < minNode.val)) {
                    minNode = arr[i];
                    minIndex = i;
                }
            }
    
            // 如果minNode为null，说明所有链表都已经被合并完毕
            if (minNode == null) break;
    
            cur.next = minNode; // 将最小节点连接到结果链表上
            cur = cur.next; // 移动cur指针
             // 移动链表头指针
            arr[minIndex] = arr[minIndex].next;
        }
    
        cur.next = null; // 最后一个节点的next应该设置为null
        return dummy.next; // 返回合并后的链表头节点
    }
}