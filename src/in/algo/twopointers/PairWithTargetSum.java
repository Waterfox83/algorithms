package in.algo.twopointers;

public class PairWithTargetSum {
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 6};
        int target = 6;
        search(arr, target);
    }

    public static int[] search(int[] arr, int targetSum) {
        int startPointer = 0, endPointer= arr.length - 1;
        while(startPointer <= endPointer) {
            if ((arr[startPointer] + arr[endPointer]) > targetSum) {
                endPointer--;
            } else if((arr[startPointer] + arr[endPointer]) < targetSum) {
                startPointer++;
            } else if ((arr[startPointer] + arr[endPointer]) == targetSum) {
                System.out.println(arr[startPointer] + "," + arr[endPointer]);
                return new int[] {arr[startPointer], arr[endPointer]};
            }
        }
        return new int[] {-1};
    }
}
