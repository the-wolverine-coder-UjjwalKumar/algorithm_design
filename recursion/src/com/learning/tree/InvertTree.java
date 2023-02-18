package com.learning.tree;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        // filling left subtree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // filling right subtree
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("InOrder before invert :: ");
        printInOrder(root);
        TreeNode newRoot = invertTree(root);
        System.out.println("Inorder after invert :: ");
        printInOrder(newRoot);
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root==null) return null;

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;

    }

    private static void printInOrder(TreeNode root) {

        if (root==null) return;

        printInOrder(root.left);
        System.out.print(root.val +" ");
        printInOrder(root.right);
    }
}
