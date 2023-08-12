package com.greatlearning.q2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class DriverMain {
    public static void main(String[] args) {
        // Construct the initial BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);        
        root.right.left = new TreeNode(55);

        // Convert to right-skewed tree
        TreeNode skewedRoot = rightSkewTree(root);

        // Display the right-skewed tree
        displayTree(skewedRoot);
    }

    public static TreeNode rightSkewTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode newRoot = rightSkewTree(root.left);

        TreeNode rightSubtree = rightSkewTree(root.right);
        root.left = null;
        root.right = rightSubtree;

        if (newRoot == null) {
            return root;
        }

        TreeNode current = newRoot;
        while (current.right != null) {
            current = current.right;
        }
        current.right = root;

        return newRoot;
    }

    public static void displayTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}
