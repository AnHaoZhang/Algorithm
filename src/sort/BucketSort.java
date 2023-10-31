package sort;

/**
 * @author cbz
 * @version 1.0
 * 桶排序
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BucketSort {
    private static List<Integer> bucketSort(List<Integer> arr, int bucketSize) {
        /* 获取传入数组长度*/
        int len = arr.size();
        /* 判断数组长度和桶大小*/
        if (len < 2 || bucketSize == 0) {
            return arr;
        }
        /* 获取最小值、最大值*/
        int minVal = arr.get(0), maxVal = arr.get(0);
        /* 遍历数组*/
        for (int i = 1; i < len; i++) {
            if (arr.get(i) < minVal) {
                minVal = arr.get(i);
            } else if (arr.get(i) > maxVal) {
                maxVal = arr.get(i);
            }
        }
        /* 计算桶大小*/
        int bucketNum = (maxVal - minVal) / bucketSize + 1;
        /* 创建桶*/
        List<List<Integer>> bucket = new ArrayList<>();
        /* 初始化桶*/
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }
        /* 桶排序*/
        for (int val : arr) {
            int idx = (val - minVal) / bucketSize;
            bucket.get(idx).add(val);
        }
        for (int i = 0; i < bucketNum; i++) {
            if (bucket.get(i).size() > 1) {
                bucket.set(i, bucketSort(bucket.get(i), bucketSize / 2));
            }
        }
        /* 合并桶*/
        List<Integer> result = new ArrayList<>();
        for (List<Integer> val : bucket) {
            result.addAll(val);
        }
        /* 返回结果*/
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        System.out.println(bucketSort(arr, 10));
        scanner.close();
    }

}

