package in.algo.subsets;

import java.util.*;

//https://www.educative.io/courses/grokking-the-coding-interview/gx2OqlvEnWG
class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        System.out.println("Created blank subset");
        subsets.add(new ArrayList<>());

        for(int num: nums) {
            int subsetSize = subsets.size();
            System.out.println("No. of subsets = " + subsetSize);
            for (int i=0; i<subsetSize; i++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                System.out.println("Created new subset from existing one " + subsets.get(i));
                newSubset.add(num);
                System.out.println("Added " + num + " to it");
                subsets.add(newSubset);
                System.out.println("Added new subset to the list of subsets. New Subset = " + newSubset);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

