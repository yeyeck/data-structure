package com.yeyeck.data.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    static BinarySearchTree tree;

    @BeforeAll
    static void before() {
        tree = BinarySearchTree.createRandomTree(20, 100);
        tree.insert(new BinarySearchTree.SearchNode(30));
        tree.inOrderTreeWalk();
        System.out.println(tree);
    }

    @Test
    void insert() {
        tree.insert(new BinarySearchTree.SearchNode(30));
        tree.inOrderTreeWalk();

    }

    @Test
    void search() {
        BinaryTree.Node node = tree.search(30);
        System.out.println("递归 search 30: " + node);
    }

    @Test
    void max() {
        BinaryTree.Node max = tree.max();
        System.out.println("max = " + max);
    }

    @Test
    void min() {
        BinaryTree.Node min = tree.min();
        System.out.println("min = " + min);
    }

    @Test
    void whileSearch() {
        BinaryTree.Node node =tree.whileSearch(30);
        System.out.println("while 版 search 30" + node);
    }

    @Test
    void pre() {
        BinaryTree.Node pre = tree.pre(30);
        System.out.println("30 的前一节点：" + pre);
    }

    @Test
    void next() {
        BinaryTree.Node next = tree.next(30);
        System.out.println("30 的下一节点：" + next);
    }
}