package PracticeOnceaday;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author cbz
 * @version 1.0
 */
public class SmallestInfiniteSet2336 {
    /**
     * 正整数集合-> list、set、 map
     * 移除最小值-> 最小值标志
     * 添加当前没有的值（去重）-> set
     */

    //声明实例化set集合
    HashSet<Integer> set = new HashSet();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    int n = 1;
    //初始化set集合
    public SmallestInfiniteSet2336() {

    }
    public int popSmallest() {
        if (set.isEmpty()) {
            return n++;
        }
        int res = pq.poll();
        set.remove(res);
        return res;
    }

    public void addBack(int num) {
        if (set.contains(num) && set.add(num)) {
            pq.offer(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet2336 s = new SmallestInfiniteSet2336();
        s.addBack(2);
        s.popSmallest();
        s.popSmallest();
        s.popSmallest();
        s.addBack(1);



    }
}
