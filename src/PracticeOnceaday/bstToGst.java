package PracticeOnceaday;



/**
 * @author cbz
 * @version 1.0
 */
public class bstToGst {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.left);
            sum += root.val;
            root.val = sum;
            bstToGst(root.right);
        }
        return root;
    }


}
