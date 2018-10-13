package org.java.bin.interview;

/**
 * Created by wangbin on 16/12/25.
 */
public class Test {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return length;
        }
        int i = 0;
        int j = 1;
        while( i < length && j < length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int[] leftPre;
        int[] rightPre;
        int[] leftIn;
        int[] rightIn;
        TreeNode root = null;
        if(pre == null || in == null){
            return null;
        }

        if(pre.length != 0 && in.length != 0){
            root = new TreeNode(pre[0]);

            int inPos = 0;
            for(int i = 0;i < in.length; i++){
                if(in[i] == root.val){
                    inPos = i;
                }
            }

            int leftArrayLength = inPos;
            leftPre = new int[leftArrayLength];
            leftIn = new int[leftArrayLength];
            System.arraycopy(pre,1,leftPre,0,leftPre.length);
            System.arraycopy(in,0,leftIn,0,leftIn.length);
            rightPre = new int[pre.length - leftArrayLength - 1];
            rightIn = new int[in.length - leftArrayLength - 1];
            System.out.println(leftArrayLength + 2);
            System.arraycopy(pre,leftArrayLength + 1,rightPre,0,rightPre.length);
            System.arraycopy(in,inPos + 1,rightIn,0,rightIn.length);

            TreeNode left = reConstructBinaryTree(leftPre,leftIn);
            TreeNode right = reConstructBinaryTree(rightPre,rightIn);
            if(root != null){
                root.left = left;
                root.right = right;
            }

        }
        return root;
    }

    public static void main(String[] args) {
/*        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7};
        removeDuplicates(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }*/
//[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        reConstructBinaryTree(pre, in);
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
