package in.algo.subsets;

import java.util.*;
import java.util.stream.Collectors;

//https://www.educative.io/courses/grokking-the-coding-interview/7npk3V3JQNr
class SubsetsWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        subsets.add(new ArrayList<>());

        for(int num: nums) {
            Set<List<Integer>> subsetsCopy = new HashSet<>(subsets);
            Iterator iter = subsetsCopy.iterator();
            while(iter.hasNext()) {
                List<Integer> newSubset = new ArrayList<>((List<Integer>)iter.next());
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }
        return subsets.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

