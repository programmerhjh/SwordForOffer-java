package prv.offer.binarytree;

import prv.offer.model.TreeLinkNode;

/**
 * 二叉树的下一个结点
 * 
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * 两种可能：如果节点的右节点不为空就遍历右节点的最左孩子，
 * 		     如果右节点为空，则往父节点走，走到第一个节点的父节点的左孩子和节点相等的时候，返回父节点
 * 
 * @author HJH
 *
 * @date 2019年3月18日
 */
public class GetNext {
	public TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        if(pNode.right != null){
            TreeLinkNode n = pNode.right;
            while(n.left != null) {
                n = n.left;
            }
            return n;
        }
        if(pNode.next != null){
            while(pNode.next != null && pNode.next.left != pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }
        return null;
    }
}
