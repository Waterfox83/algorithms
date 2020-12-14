package in.algo.xor;

//https://www.educative.io/courses/grokking-the-coding-interview/gk20xz4VwpG
class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int j : arr) {
            num = num ^ j;
            System.out.println(num);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
