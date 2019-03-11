package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 二叉树的深度
 * 分别求左右子树的高度进行比较，大的加1
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class TreeDepth {
	public int treeDepth(TreeNode root) {
        return treeDepth2(root, 0);
    }
    public int treeDepth2(TreeNode root, int rs) {
        if(root == null) 
        	return 0;
        int t1 = treeDepth2(root.left, rs), t2 = treeDepth2(root.right, rs);
        return t1 > t2 ? t1 + 1 : t2 + 1;
    }
}
