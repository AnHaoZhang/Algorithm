package PracticeOnceaday;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cbz
 * @version 1.0
 */
public class maxScore {
    public static void main(String[] args) {
//        int[] cardPoints = {100,40,17,9,73,75};
//        int[] cardPoints = {1,1000,1};
        int[] cardPoints = {11,49,100,20,86,29,72};
        System.out.println(new maxScore().maxScore(cardPoints, 4));
    }
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        int i = 0;
//        if (k >= n) {
//            for (i = 0; i < n; i++) {
//                sum += cardPoints[i] ;
//            }
//        }else {
//            Queue<Integer> startQueue = new LinkedList<>();
//            Queue<Integer> endQueue = new LinkedList<>();
//            for (i = 0; i < k; i++) {
//                startQueue.offer(cardPoints[i]);
//                endQueue.offer(cardPoints[n - 1 - i]);
//            }
//            i=0;
//            while (!startQueue.isEmpty() && !endQueue.isEmpty() && i<k) {
//                i++;
//                int firstElement = startQueue.peek();
//                int secondElement = endQueue.peek();
//
//                if (firstElement > secondElement) {
//                    sum += startQueue.poll();
//                } else {
//                    sum += endQueue.poll();
//                }
//            }
//        }
        for (i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
//        int maxSum = sum;
//        for (; i < n; i++) {
//            sum = sum - cardPoints[i - k] + cardPoints[i];
//            maxSum = Math.max(sum, maxSum);
//        }
        int maxSum = sum;
        for (int j = 1; j <= k; j++) {
            sum -= cardPoints[k - j];
            sum += cardPoints[n - j];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
