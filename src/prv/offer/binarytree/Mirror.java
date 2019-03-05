package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 二叉树的镜像
 * 
 * 二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * 
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class Mirror {
	public void mirror(TreeNode root) {
        if(root != null){
            TreeNode n = root.left;
            root.left = root.right;
            root.right = n;
            mirror(root.left);
            mirror(root.right);
        }
    }
}
