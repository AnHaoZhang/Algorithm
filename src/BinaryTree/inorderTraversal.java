package BinaryTree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author cbz
 * @version 1.0
 */

/**
 * 内部类
 * 成员内部类
 * 匿名内部类
 * 静态内部类
 */
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
public class inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    void dfs(TreeNode root,List<Integer> res){
        if (root == null) {
            return;
        }
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }

    public static void main(String[] args) {

    }


}

