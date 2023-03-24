package com.learning.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EvaluateBooleanTree {
    public static void main(String[] args) {
        // root = [2,1,3,null,null,0,1]
        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(1);

        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root) {
        Map<Integer,String> operations = new HashMap<>();
        operations.put(0,"FALSE");
        operations.put(1,"TRUE");
        operations.put(2,"OR");
        operations.put(3,"AND");

        String ans = evaluateBoolean(root, operations);
        if (Objects.nonNull(ans)) {
            return ans.equalsIgnoreCase("TRUE");
        }

        return false;

    }

    private static String evaluateBoolean(TreeNode root, Map<Integer, String> operations) {

        String left = null;
        String right = null;

        if (root.left==null && root.right==null){
            return operations.get(root.val);
        }

        if (root.left!=null)
            left = evaluateBoolean(root.left, operations);

        if (root.right!=null)
            right = evaluateBoolean(root.right, operations);
        
        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            boolean leftBoolValue = false;
            boolean rightBoolValue = false;
            boolean result = false;
            
            if (left.equalsIgnoreCase("TRUE"))
                leftBoolValue = true;


            if (right.equalsIgnoreCase("TRUE"))
                rightBoolValue = true;

            if (root.val==2) {
                result =  leftBoolValue || rightBoolValue;
            } else if (root.val==3) {
                result =  leftBoolValue && rightBoolValue;
            }

            if (result){
                return "TRUE";
            } else {
                return "FALSE";
            }
        }
        return null;
    }

    // Optimized
    public boolean evaluateTreeOptimized(TreeNode root) {
        if(root.val == 0) return false;
        if(root.val == 1) return true;
        boolean l = evaluateTree(root.left);
        boolean r = evaluateTree(root.right);
        return root.val==2 ? l|r : l&r;
    }
}
