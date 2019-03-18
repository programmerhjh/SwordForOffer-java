package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 对称的二叉树
 * 
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author HJH
 *
 * @date 2019年3月18日
 */
public class IsSymmetrical {
	boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null) return true;
        return compareTree(pRoot.left, pRoot.right);
    }
    boolean compareTree(TreeNode left, TreeNode right){
        if(left == null) return right == null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return compareTree(left.right, right.left) && compareTree(left.left, right.right);
    }
}
