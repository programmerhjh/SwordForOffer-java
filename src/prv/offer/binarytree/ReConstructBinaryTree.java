package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 重建二叉树
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class ReConstructBinaryTree {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in){
		return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie){
            return null;
        }
        TreeNode head = new TreeNode(pre[ps]);
        for (int i = is;i < in.length;i++){
            if (pre[ps] == in[i]){
                // 因为子树的前序中序的长度是一样的，可以通过建立方程 endPre-x = endIn-(i+1)，x - (startPre + 1) = i - 1 - startIn 来得出当前左右子树的前序的起点和终点
                // i为当前节点在中序的下标， endPre-x = endIn-(i+1) 的 x 为右子树前序开头 startPre， x - (startPre + 1) = i - 1 - startIn 的 x 为左子树前序结尾
                // ps+1 为下一个头结点（根）， i + 1 为子树中序的节点开头， i - 1 为子树中序的节点结尾
                head.left = reConstructBinaryTree(pre, in, ps + 1, ps + i - is, is, i - 1);
                head.right = reConstructBinaryTree(pre, in, i - ie + pe + 1, pe,i + 1, ie);
                break;
            }
        }
        return head;
    }
}
