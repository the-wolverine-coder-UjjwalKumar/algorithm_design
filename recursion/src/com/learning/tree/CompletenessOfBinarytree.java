package com.learning.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompletenessOfBinarytree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(6);

        System.out.println("Is complete tree :: "+isCompleteTree(root));
    }

    public static boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // after we encounter any null node, we don't expect to have further valid node
        // so once null encunter all after it all must be null
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if(cur == null) end = true;
            else {
                if(end) return false;

                queue.add(cur.left);
                queue.add(cur.right);
            }


        }
        return true;
    }
}
