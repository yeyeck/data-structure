package com.yeyeck.data.tree;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

@ToString
public class BinaryTree {
    protected Node root;

    public BinaryTree() {}

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void inOrderTreeWalk() {
        inOrderTreeWalk(this.root);
        System.out.println();
    }
    private void inOrderTreeWalk(Node node) {
        if (node == null) return;
        inOrderTreeWalk(node.left);
        System.out.print(node.val + ",");
        inOrderTreeWalk(node.right);
    }

    public void preOrderTreeWalk() {
        preOrderTreeWalk(this.root);
        System.out.println();
    }
    private void preOrderTreeWalk(Node node) {
        if (node == null) return;
        System.out.print(node.val + ",");
        preOrderTreeWalk(node.left);
        preOrderTreeWalk(node.right);
    }

    public void postOrderTreeWalk() {
        postOrderTreeWalk(this.root);
        System.out.println();
    }
    private void postOrderTreeWalk(Node node) {
        if (node == null) return;
        postOrderTreeWalk(node.left);
        postOrderTreeWalk(node.right);
        System.out.print(node.val + ",");
    }

    public void levelOrderTreeWalk() {
        Node node = this.root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.val + ",");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    public static BinaryTree createBinaryTree(int n) {
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 2;
        while (i <= n) {
            Node node = queue.poll();
            node.left = new Node(i++);
            queue.offer(node.left);
            if (i <= n) {
                node.right = new Node(i++);
                queue.offer(node.right);
            }
        }
        return new BinaryTree(root);
    }


    @Data
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}


