package com.learning.tree;

public class InvertTree {
    public static void main(String[] args) {
        Node root = new Node(4);

        // filling left subtree
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        // filling right subtree
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        System.out.println("InOrder before invert :: ");
        printInOrder(root);
        Node newRoot = invertTree(root);
        System.out.println("Inorder after invert :: ");
        printInOrder(newRoot);
    }

    private static Node invertTree(Node root) {
        if (root==null) return null;

        Node tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;

    }

    private static void printInOrder(Node root) {

        if (root==null) return;

        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }
}
