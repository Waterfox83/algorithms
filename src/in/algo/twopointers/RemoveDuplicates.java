package in.algo.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(" Non-duplicate array size: " + RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(" Non-duplicate array size: " + RemoveDuplicates.remove(arr));
    }

    public static int remove(int[] arr) {
        int nextPointer = 1; int nonDuplicatePointer = 0;
        while(nextPointer < arr.length) {
            if(arr[nonDuplicatePointer] != arr[nextPointer]) {
                nonDuplicatePointer++;
                System.out.println("non-dup pointer is now " + nonDuplicatePointer + " and next pointer :" + nextPointer);
                if (nextPointer != nonDuplicatePointer+1) {
                    arr[nonDuplicatePointer] = arr[nextPointer];
                    System.out.println("Printing array:");
                    printArray(arr);
                }
            }

            nextPointer++;
        }
        System.out.print("Non-duplicate array: ");
        for (int i = 0; i <= nonDuplicatePointer ; i++) {
            System.out.print(arr[i]);
        }
        return (nonDuplicatePointer+1);
    }

    public static int simpleRemove(int[] arr) {
        int nonDuplicatePointer = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[nonDuplicatePointer-1] != arr[i]){
                arr[nonDuplicatePointer] = arr[i];
                nonDuplicatePointer++;
            }
        }
        return nonDuplicatePointer;
    }

    private static void printArray(int[] arr) {
        for (int i:arr) {
            System.out.print(i);
        }
    }
}
