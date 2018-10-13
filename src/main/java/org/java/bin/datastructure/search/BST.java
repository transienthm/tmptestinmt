package org.java.bin.datastructure.search;

import java.io.File;
import java.io.IOException;

public class BST {
    TreeNode root;
    int count;

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }
}

class TreeNode<K, V> {
    K key;
    V value;
    TreeNode left;
    TreeNode right;

    TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }
}