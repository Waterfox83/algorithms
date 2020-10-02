package in.algo.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
//        iterativeAlgo(arr, K);
        slidingWindow(arr, K);
        System.out.println(findMaxSumSubArray(K, arr));
    }

    private static void iterativeAlgo(int arr[], int K) {
        int iteration = 0;
        double finalAverage = 0.0;

        while (iteration + K <= arr.length){
            System.out.println("Iteration# :" + iteration);
            double sum = 0;
            for(int i=iteration; i<iteration+K;i++) {
                System.out.println("adding " + arr[i]);
                sum += arr[i];
            }
            System.out.println("Sum of the subarray with indices: " + iteration + "," + (iteration+K-1) + " = " + sum + " and average: " + (sum/K));
            finalAverage += (sum/K);
            iteration++;
        }
        System.out.println("Total avg: "+ finalAverage/K);
    }

    private static void slidingWindow(int arr[], int K) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum;// / K; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowStartIndex = 0;
        int maxSum = 0;
        int windowSum = 0;
        int[] result = new int[arr.length - k + 1];

        for (int windowEndIndex = 0; windowEndIndex < arr.length; windowEndIndex++) {
            windowSum += arr[windowEndIndex];
            if (windowEndIndex >= k-1) {
                System.out.println("Sum for window" + windowStartIndex + " = " + windowSum );
                result[windowStartIndex] = windowSum;
                maxSum = Math.max(maxSum, windowSum);

                windowSum -= arr[windowStartIndex++];
            }
        }

        return maxSum;
    }
}
