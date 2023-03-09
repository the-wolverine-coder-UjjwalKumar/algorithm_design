package com.learning.tree;

public class LCAInBinarySearchTree {

    public static void main(String[] args) {
        // BSt root left value is small and root right value is greater
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(4);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.right = new TreeNode(2);

        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.left = new TreeNode(5);
        root.left.right.left.right = new TreeNode(7);

        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(15);


        int u = 5;
        int v = 9;

        int ans = getLcaInBst(root, u, v);
        System.out.println("Lowest Common Ancestor :: of (u,v) :: (" + u + "," + v + ") :: " + ans);

    }

    private static Integer getLcaInBst(TreeNode root, int u, int v) {

        // logic is get the first node
        // where we can say that u lie in left and v lies in right
        if (root == null) return null;

        if (root.val == u || root.val == v) return root.val;

        if (root.val > u && root.val > v)
            return getLcaInBst(root.left, u, v);
        else if (root.val < u && root.val < v)
            return getLcaInBst(root.right, u, v);
        else
           return root.val; // case of split i.e. one value lies left and one right

    }
}
