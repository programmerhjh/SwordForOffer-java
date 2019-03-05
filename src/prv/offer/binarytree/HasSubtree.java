package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 树的子结构
 * 先找到头结点，找到之后比较各个节点，如果root2先为空则匹配，root1为空和root1和root2的值不相等都为不匹配情况
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class HasSubtree {
	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean f = false;
        if(root2 != null && root1 != null){
            if(root1.val == root2.val){
                f = hasSubtree2(root1, root2);
            } 
            if(!f){
                f = hasSubtree(root1.left, root2);
            }
            if(!f){
                f = hasSubtree(root1.right, root2);
            }
        }
        return f;
    }
    
    public boolean hasSubtree2(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return hasSubtree2(root1.left, root2.left) && hasSubtree2(root1.right, root2.right);
    }
}
