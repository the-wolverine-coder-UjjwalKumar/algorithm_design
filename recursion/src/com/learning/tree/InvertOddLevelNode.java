package com.learning.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class InvertOddLevelNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        // filling left subtree
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);

        // filling right subtree
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        System.out.println("InOrder before invert :: ");
        printInOrder(root);
        System.out.println();
        TreeNode newRoot = invertOddLevelNodeInTree(root, 0);
        System.out.println("Inorder after invert :: ");
        printInOrder(newRoot);
    }

    private static TreeNode invertOddLevelNodeInTree(TreeNode root, int level) {
        if (root == null) return null;

        // will be using BFS, level by level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

           while (size-- > 0) {
               TreeNode currentTreeNode = queue.poll();
               if (currentTreeNode.left!=null) queue.add(currentTreeNode.left);
               if (currentTreeNode.right!=null) queue.add(currentTreeNode.right);
           }
            level++;
            if (level%2!=0) {
                // means odd leve
                swap(queue);
            }


        }
        return root;

    }

    private static void swap(Queue<TreeNode> queue) {
        if (!queue.isEmpty()){
            List<Integer> data = queue.stream().map(i -> i.val).collect(Collectors.toList());
            int j = data.size()-1;
            for (TreeNode currentTreeNode : queue){
                currentTreeNode.val = data.get(j);
                j--;
            }
        }
    }

    private static TreeNode invertTree(TreeNode root, int level) {
        if (root == null) return null;

        if (level % 2 == 0) {
            TreeNode tmp = root.left;
            root.left = invertTree(root.right, level+1);
            root.right = invertTree(tmp, level+1);
        }
        return root;

    }

    private static void printInOrder(TreeNode root) {

        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
