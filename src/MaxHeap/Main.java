package MaxHeap;

import com.sun.corba.se.impl.orb.ParserTable;

import java.util.Random;

/**
 * @ClassName Main
 * @Author sensu
 * @Date 2019/10/9 12:02
 **/
public class Main {
    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<Integer>(testData);
        } else {
            maxHeap = new MaxHeap<Integer>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

//        int[] arr = new int[testData.length];
//        for (int i = 0; i < testData.length; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//
//        //如果前一个元素小于后一个元素  则堆出了问题
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i - 1] < arr[i]) {
//                throw new IllegalArgumentException("TestData error");
//            }
//        }

//        System.out.println("TestData success");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        //比较heapify 跟 普通插入的差距
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");
        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
