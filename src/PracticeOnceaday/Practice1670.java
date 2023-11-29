package PracticeOnceaday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cbz
 * @version 1.0
 */
public class Practice1670 {

    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> right = new ArrayDeque<>();

    private void balance() {
        // 如果左侧队列的大小大于右侧队列的大小
        if (left.size() > right.size()) {
            // 将左侧队列的最后一个元素移动到右侧队列的头部
            right.addFirst(left.pollLast());
        }
        // 如果右侧队列的大小大于左侧队列的大小
        else if (right.size() > left.size()+1) {
            // 将右侧队列的第一个元素移动到左侧队列的尾部
            left.addLast(right.pollFirst());
        }

    }
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()){
            left.addLast(val);
        }else {
            right.addFirst(val);
        }
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    /**
     * 从双端队列的前端（左侧）弹出一个元素，并平衡队列。
     * 如果左侧队列为空，从右侧队列弹出一个元素；否则，从左侧队列弹出一个元素。
     * 如果队列为空，返回 -1。
     * @return 弹出的元素值或 -1（如果队列为空）
     */
    public int popFront() {
        // 如果右侧队列为空，无法从前端弹出元素，返回 -1
        if (right.isEmpty()) {
            return -1;
        }

        // 从左侧队列或右侧队列的尾部弹出一个元素，并记录其值
        int val = left.isEmpty() ? right.pollFirst() : left.pollLast();

        // 平衡队列
        balance();

        // 返回弹出的元素值
        return val;
    }

    public int popMiddle() {
        if (right.isEmpty()){
            return -1;
        } else if (left.size() == right.size()) {
            return left.pollLast();
        }
        return right.pollFirst();
    }

    public int popBack() {
        if (right.isEmpty()) { // 整个队列为空
            return -1;
        }
        int val = right.pollLast();
        balance();
        return val;
    }

    public static void main(String[] args) {
        Practice1670 practice1670 = new Practice1670();
        practice1670.pushFront(1);
        practice1670.pushMiddle(2);
        practice1670.pushBack(3);
        practice1670.pushFront(4);
        System.out.println(practice1670.popFront());
        System.out.println(practice1670.popMiddle());
        System.out.println(practice1670.popBack());
        System.out.println(practice1670.popFront());
    }

}
