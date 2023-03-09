package com.learning.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LCABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        // getLca(4,7) = 2
        // getLca(5,9) = 1
        // getLca(2,6) = 2
        int u = 4;
        int v = 7;
        int lcaNodeVal = getLca(u, v, root);
        System.out.println("Lowest Common Ancestor :: of (u,v) :: (" + u + "," + v + ") :: " + lcaNodeVal);

        System.out.println("====");
        System.out.println(getLcaOptimized(root, u, v));
    }

    private static int getLca(int u, int v, TreeNode root) {
        // brute force
        // traverse from root to node and collect the path for u and v
        // then traverse both the path array till the elements differ
        // return the last matched element

        List<Integer> pathList1 = getPathList(u, root);
        System.out.println("Path 1 " + pathList1);
        List<Integer> pathList2 = getPathList(v, root);
        System.out.println("Path 2 " + pathList2);


        int len1 = pathList1.size();
        int len2 = pathList2.size();

        int len = Math.max(len1, len2);
        int ans = -1;
        for (int i = 0; i < len; i++) {
            if (Objects.equals(pathList1.get(i), pathList2.get(i))) {
                ans = pathList1.get(i);
            } else {
                break;
            }
        }

        return ans;
    }

    private static List<Integer> getPathList(int u, TreeNode root) {
        List<Integer> path = new ArrayList<>();
        doInorderTraverse(u, root, path);

        return path;

    }

    private static boolean doInorderTraverse(int u, TreeNode root, List<Integer> path) {
        if (root == null) return false;

        path.add(root.val);
        if (root.val == u) return true;

        if (doInorderTraverse(u, root.left, path) || doInorderTraverse(u, root.right, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }

    public static Integer getLcaOptimized(TreeNode root, int u, int v) {

        if (root == null) return null;

        if (root.val == u || root.val == v) {
            return root.val;
        }

        Integer leftCall = getLcaOptimized(root.left, u, v);
        Integer rightCall = getLcaOptimized(root.right, u, v);

//        if (leftCall!=null && rightCall!=null) return root.val;
//
//        if (leftCall!=null) return leftCall;
//        else return rightCall;

        if (leftCall==null) {
            return rightCall;
        } else if (rightCall == null) {
            return leftCall;
        } else {
            return root.val;
        }

    }
}
