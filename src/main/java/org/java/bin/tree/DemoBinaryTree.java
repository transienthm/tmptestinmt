package org.java.bin.tree;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Stack;

/**
 * Created by wangbin on 16/12/18.
 */
public class DemoBinaryTree {
    int data;
    DemoBinaryTree leftTree;
    DemoBinaryTree rightTree;

    public DemoBinaryTree(int data) {
        this.data = data;
        leftTree = null;
        rightTree = null;
    }

    public void insert(DemoBinaryTree root, int data) {
        if (root.data > data) {
            if (root.leftTree == null) {
                DemoBinaryTree left = new DemoBinaryTree(data);
                root.leftTree = left;
            } else {
                root.insert(root.leftTree, data);
            }
        } else {
            if (root.rightTree == null) {
                DemoBinaryTree right = new DemoBinaryTree(data);
                root.rightTree = right;
            } else {
                root.insert(root.rightTree, data);
            }
        }
    }

    public static void preOrder(DemoBinaryTree root) {
        if (root != null) {
            System.out.print(root.data+"-");
            preOrder(root.leftTree);
            preOrder(root.rightTree);
        }
    }

    public static void inOrder(DemoBinaryTree root) {
        if (root != null) {
            inOrder(root.leftTree);
            System.out.print(root.data + "-");
            inOrder(root.rightTree);
        }
    }

    public static void postOrder(DemoBinaryTree root) {
        if (root != null) {
            postOrder(root.leftTree);
            postOrder(root.rightTree);
            System.out.print(root.data+"-");
        }
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点
     * 递归解法：
     * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     */
    public static DemoBinaryTree getLastCommonParentRec(DemoBinaryTree root, DemoBinaryTree n1, DemoBinaryTree n2) {
        if (findNodeRec(root.leftTree, n1)) {
            if (findNodeRec(root.rightTree, n2)) {
                return root;
            } else {
                return getLastCommonParentRec(root.leftTree, n1, n2);
            }
        } else {
            if (findNodeRec(root.leftTree, n2)) {
                return root;
            } else {
                return getLastCommonParentRec(root.rightTree, n1, n2);
            }
        }
    }

    private static boolean findNodeRec(DemoBinaryTree root, DemoBinaryTree node) {
        if (root == null || node == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return findNodeRec(root.leftTree, node) && findNodeRec(root.rightTree, node);
    }

        public static void depthFirst(DemoBinaryTree root) {
        Stack<DemoBinaryTree> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            DemoBinaryTree node = stack.pop();
            System.out.println(node.data);
            List<DemoBinaryTree> children = getChildren(node);
            if (CollectionUtils.isEmpty(children)) {
                for (DemoBinaryTree n : children) {
                    stack.push(n);
                }
            }
        }
    }

    private static List<DemoBinaryTree> getChildren(DemoBinaryTree node) {
        return null;
    }
    public static void main(String[] str) {
        int[] array = {12, 76, 35, 22, 16, 48, 90, 46, 9, 40};
        DemoBinaryTree root = new DemoBinaryTree(array[0]);   //创建二叉树
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]);       //向二叉树中插入数据
        }
        System.out.println("先根遍历：");
        preOrder(root);
        System.out.println();
        System.out.println("中根遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后根遍历：");
        postOrder(root);
    }
}
