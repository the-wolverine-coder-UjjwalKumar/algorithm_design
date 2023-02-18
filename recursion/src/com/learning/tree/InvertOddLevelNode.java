package com.learning.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class InvertOddLevelNode {
    public static void main(String[] args) {
        Node root = new Node(2);

        // filling left subtree
        root.left = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(13);

        // filling right subtree
        root.right = new Node(5);
        root.right.left = new Node(21);
        root.right.right = new Node(34);

        System.out.println("InOrder before invert :: ");
        printInOrder(root);
        System.out.println();
        Node newRoot = invertOddLevelNodeInTree(root, 0);
        System.out.println("Inorder after invert :: ");
        printInOrder(newRoot);
    }

    private static Node invertOddLevelNodeInTree(Node root, int level) {
        if (root == null) return null;

        // will be using BFS, level by level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

           while (size-- > 0) {
               Node currentNode = queue.poll();
               if (currentNode.left!=null) queue.add(currentNode.left);
               if (currentNode.right!=null) queue.add(currentNode.right);
           }
            level++;
            if (level%2!=0) {
                // means odd leve
                swap(queue);
            }


        }
        return root;

    }

    private static void swap(Queue<Node> queue) {
        if (!queue.isEmpty()){
            List<Integer> data = queue.stream().map(i -> i.data).collect(Collectors.toList());
            int j = data.size()-1;
            for (Node currentNode : queue){
                currentNode.data = data.get(j);
                j--;
            }
        }
    }

    private static Node invertTree(Node root, int level) {
        if (root == null) return null;

        if (level % 2 == 0) {
            Node tmp = root.left;
            root.left = invertTree(root.right, level+1);
            root.right = invertTree(tmp, level+1);
        }
        return root;

    }

    private static void printInOrder(Node root) {

        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
}
