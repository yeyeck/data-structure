package com.yeyeck.data.tree;

import java.util.Random;


public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(SearchNode root) {
        super(root);
    }

    public BinarySearchTree() {
    }

    public void insert(SearchNode node) {
        Node n = this.root, r = null;
        while (n != null) {
            r = n;
            if (node.val < n.val)
                n = n.left;
            else n = n.right;
        }
        if (r == null) {
            this.root = node;
        } else if (node.val < r.val) {
            r.left = node;
            node.parent = (SearchNode) r;
        } else {
            r.right = node;
            node.parent = (SearchNode) r;
        }
    }

    public Node max() {
        Node node = this.root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node min() {
        Node node = this.root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node pre(int val) {
        SearchNode node = (SearchNode)search(val);
        if (node == null) {
            throw new RuntimeException("No Such Node");
        }
        return pre(node);
    }

    private Node pre(SearchNode node) {
        // 左边的最右节点
        SearchNode p = node.parent;
        if (node.left == null) {
            if (p == null) return null;
            else return p.val < node.val ? p : null;
        } else {
            return new BinarySearchTree((SearchNode) node.left).max();
        }
    }

    public Node next(int val) {
        SearchNode node = (SearchNode) search(val);
        if (node == null) {
            throw new RuntimeException("No Such Node");
        }
        return next(node);
    }

    private Node next(SearchNode node) {
        // 右边的最左节点
        SearchNode p = node.parent;
        if (node.right == null) {
            if (p == null) return null;
            else return p.val > node.val ? p : null;
        } else {
            return new BinarySearchTree((SearchNode) node.right).min();
        }
    }

    public Node search(int n) {
        return search(this.root, n);
    }

    // 递归版 search
    private Node search(Node node, int n) {
        if (node == null || node.val == n) return node;
        if (n < node.val) {
            return search(node.left, n);
        } else {
            return search(node.right, n);
        }
    }
    // while 迭代版 search
    public Node whileSearch(int n) {
        Node node = this.root;
        while (node != null && node.val != n) {
            if (node.val < n) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    static BinarySearchTree createRandomTree(int n, int bound) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            binarySearchTree.insert(new SearchNode(random.nextInt(bound)));
        }
        return binarySearchTree;
    }


    public static class SearchNode extends BinaryTree.Node {

        SearchNode parent;

        public SearchNode(int val) {
            super(val);
        }

    }

}
