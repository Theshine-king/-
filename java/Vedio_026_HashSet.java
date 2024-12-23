import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Vedio_026_HashSet {
    public static void main (String[] args) {
        //哈希表
        Set<Integer> hashset = new HashSet<>();
       //添加指定元素  -->  去重
        hashset.add(1);
        hashset.add(2);
        hashset.add(3);
        hashset.add(2);
        //移除指定元素
        hashset.remove(3);
        //查找元素
        boolean flag = hashset.contains(8);
        boolean flag1 = hashset.contains(2);
        System.out.println(flag);
        System.out.println(flag1);
        System.out.println(hashset.size());//返回hashset的大小
        int[] arr = {1,2,3,4,5,6,7,8,9,9,10};
        test(arr);
    }

    public static void test(int[] arr) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashmap.put(arr[i],i);//加入元素
        }
        //hashmap.remove(1);
        hashmap.remove(2);//删除元素

        boolean flag = hashmap.containsKey(4);
        boolean flag1 = hashmap.containsKey(5);//查找元素
        System.out.println(flag);
        System.out.println(flag1);

        int size = hashmap.size();//返回大小
        System.out.println(size);

        int a = hashmap.get(3);//拿出3位置所对应的数 
        System.out.println(a);


    }
}
