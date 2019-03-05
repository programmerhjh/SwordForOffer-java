package prv.offer.binarytree;

import java.util.ArrayList;

import prv.offer.model.TreeNode;

/**
 * 二叉树中和为某一值的路径
 * @author HJH
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * 递归减去目标值，当其左右子树均为null时并且目标值也和当前目标值一样加入到集合里
 * @date 2019年3月3日
 */
public class FindPath {
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(root == null) return rs;
        find(rs, root, target, temp);
        return rs;
    }
    
    public void find(ArrayList<ArrayList<Integer>> rs, TreeNode root, int tg, ArrayList<Integer> temp1){
        temp1.add(root.val);
        if(root.left == null && root.right == null){
            if(tg == root.val) rs.add(temp1);
            return;
        }
        ArrayList<Integer> temp2 = new ArrayList<Integer>(temp1);
        if(root.left != null) find(rs, root.left, tg-root.val, temp1);
        if(root.right != null) find(rs, root.right, tg-root.val, temp2);
    }
}
