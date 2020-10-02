package in.algo.slidingwindow;

public class SmallestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 2, 8};
        int sum = 8;
        _getSmallestSubarray(arr, sum);
    }

    private static void _getSmallestSubarray(int arr[], int sum) {
        int windowSum = 0;
        int minWindowSize = arr.length;
        int windowStartIndex = 0;
        for(int windowEndIndex = 0; windowEndIndex < arr.length; windowEndIndex++) {
            windowSum += arr[windowEndIndex];

            while (windowSum >= sum) {
                int currentWindowSize = (windowEndIndex - windowStartIndex) + 1;
                minWindowSize = Math.min(minWindowSize, currentWindowSize);
                System.out.println("Sum : " + windowSum + " Min Window Size = " + minWindowSize);
                windowSum -= arr[windowStartIndex++];
            }
        }
        System.out.println("Smallest window size = " + minWindowSize);
    }
}
