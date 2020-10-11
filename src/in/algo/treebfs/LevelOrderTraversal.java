package in.algo.treebfs;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Problem Statement
//    Given a binary tree, populate an array to represent its level-by-level
//    traversal. You should populate the values of all nodes of each level from
//    left to right in "separate sub-arrays".

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }

//      12
//     7  1
//    9  10 5

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()!=0) {
//            In each iteration, first count the elements in the queue
//            (let’s call it levelSize). We will have these many nodes in the current level.
            int levelSize = queue.size();
            List<Integer> nodeList = new ArrayList<>(queue.size());
//            Next, remove levelSize nodes from the queue and push their value
//            in an array to represent the current level.
            for(int i = 0; i<levelSize; i++) {
                TreeNode node = queue.poll();
                nodeList.add(node.val);
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
//            add the nodeList for current level to result list
            result.add(nodeList);
        }

        return result;
    }
}
