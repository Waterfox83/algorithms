package in.algo.twopointers;

import java.util.ArrayList;
import java.util.List;

public class SortedArraySquares {
    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

    public static int[] makeSquares(int[] arr) {
        int left = 0, right = arr.length - 1;
        int[] squares = new int[arr.length];
        int highIndex = arr.length - 1;
        while(left <= right) {
            int leftSqr = arr[left] * arr[left];
            int rightSqr = arr[right] * arr[right];
            if(leftSqr > rightSqr) {
                squares[highIndex--] = leftSqr;
                left++;
            } else {
                squares[highIndex--] = rightSqr;
                right--;
            }
        }

        return squares;
    }
}
