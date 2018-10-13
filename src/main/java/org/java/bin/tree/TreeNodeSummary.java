package org.java.bin.tree;

import java.util.*;

/**
 * Created by wangbin on 16/12/18.
 */
public class TreeNodeSummary {
    /*
                 1
                / \
               2   3
              / \   \
             4  5   6
     */
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;

//        System.out.println(getNodeNumRec(r1));
//        System.out.println(getNodeNum(r1));
//        System.out.println(getDepthRec(r1));
//        preorderTraversalRec(r1);
//        preorderTraversal(r1);
//        inorderTraversal(r1);
//        postorderTraversal(r1);
//        levelTraversalRec(r1);
        TreeNode node = getLastCommonParentRec(r1, r1, r4);
        System.out.println(node == null ? null : node.val);
    }


    /**
     * 求二叉树中的节点个数递归解法： O(n)
     * （1）如果二叉树为空，节点个数为0
     * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 +
     * 右子树节点个数 + 1
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
        }
    }

    /**
     * 求二叉树中的节点个数迭代解法O(n)：基本思想同LevelOrderTraversal，
     * 即用一个Queue，在Java里面可以用LinkedList来模拟
     */
    public static int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            count++;
        }
        return count;
    }

    /**
     * 求二叉树的深度（高度） 递归解法： O(n)
     * （1）如果二叉树为空，二叉树的深度为0
     * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
     */
    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepthRec(root.left);
        int rightDepth = getDepthRec(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 求二叉树的深度（高度） 迭代解法： O(n)
     * 基本思想同LevelOrderTraversal，还是用一个Queue
     */
    public static int getDepth(TreeNode root) {
        return 0;
    }

    /**
     * 前序遍历，中序遍历，后序遍历 前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     */
    public static void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    /**
     * 前序遍历迭代解法：用一个辅助stack，总是把右孩子放进栈
     * http://www.youtube.com/watch?v=uPTCbdHSFg4
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        /*Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }*/
    }

    /**
     * 中序遍历递归解法
     * （1）如果二叉树为空，空操作。
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public static void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    /**
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内，
     * 然后输出栈顶元素，再处理栈顶元素的右子树
     * http://www.youtube.com/watch?v=50v1sJkjxoc
     * <p>
     * 还有一种方法能不用递归和栈，基于线索二叉树的方法，较麻烦以后补上
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
     */
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    /**
     *  后序遍历迭代解法
     *  http://www.youtube.com/watch?v=hv-mJUs5mvU
     *
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            output.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!output.isEmpty()) {
            System.out.printf(output.pop().val + " ");
        }

    }
    /**
     * 分层遍历二叉树（按层次从上往下，从左往右）迭代
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点
     * ，访问，若左子节点或右子节点不为空，将其压入队列
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.printf(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     *  分层遍历二叉树（递归）
     *  很少有人会用递归去做level traversal
     *  基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。
     *  大的ArrayList的size和level有关系
     *
     *  这是我目前见到的最好的递归解法！
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543
     */
    public static void levelTraversalRec(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, 0, ret);
        System.out.println(ret);
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }

        if (level >= ret.size()) {
            ret.add(new ArrayList<Integer>());
        }

        ret.get(level).add(root.val);
        dfs(root.left, level + 1, ret);
        dfs(root.right, level + 1, ret);
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点
     * 递归解法：
     * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     */
    public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
/*        if (root == null || n1 == null || n2 == null) {
            return null;
        }
        if (root == n1 || root == n2) {
            return root;
        }*/
        if (findNodeRec(root.left, n1)) {
            if (findNodeRec(root.right, n2)) {
                return root;
            } else {
                return getLastCommonParentRec(root.left, n1, n2);
            }
        } else {
            if (findNodeRec(root.left, n2)) {
                return root;
            } else {
                return getLastCommonParentRec(root.right, n1, n2);
            }
        }
    }

    private static boolean findNodeRec(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        boolean found = findNodeRec(root.left, node) ;
        if (!found) {
            found = findNodeRec(root.right, node);
        }
        return found;
    }



        private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}



