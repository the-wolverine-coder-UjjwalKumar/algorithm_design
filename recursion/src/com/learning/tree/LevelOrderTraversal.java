package com.learning.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);

        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if(root!=null){
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                List<Integer> innerList = new ArrayList<>();
                int count = q.size();
                for(int i=0; i<count; i++){
                    TreeNode temp = q.poll();
                    innerList.add(temp.val);
                    if(temp.left!=null)
                        q.add(temp.left);
                    if(temp.right!=null)
                        q.add(temp.right);
                }
                l.add(innerList);
            }
        }
        return l;
    }
}
