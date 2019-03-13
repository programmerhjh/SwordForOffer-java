/**
 * 
 */
package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 平衡二叉树
 * 平衡二叉树判断依据：根据其左右子树高度差是否小于等于1判断，如果有任一子树高度差大于1则不是平衡二叉树
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class IsBalanced {
	public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int l = getDepth(root.left);
        if(l == -1) return -1;
        int r = getDepth(root.right);
        if(r == -1) return -1;
        return Math.abs(l - r) > 1 ? -1 : 1 + Math.max(l, r);
    }
}
