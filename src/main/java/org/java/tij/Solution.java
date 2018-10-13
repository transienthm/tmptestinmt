package org.java.tij;

/**
 * Created by wangbin on 2017/9/22.
 */
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curLevelNodes = 1;
        int nextLevelNodes = 0;
        Stack<List<Integer>> temp = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            curLevelNodes--;

            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelNodes++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if (curLevelNodes == 0) {
                temp.push(list);
                list = new ArrayList<>();
                curLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }

            while (!temp.isEmpty()) {
                res.add(temp.pop());
            }
        }
        return res;
    }
}
