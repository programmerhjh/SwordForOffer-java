package prv.offer.binarytree;

import java.util.Stack;

import prv.offer.model.TreeNode;

/**
 * 二叉搜索树的第k个结点
 * 
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如 （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 * 
 * 用一个栈来迭代中序节点，一个记录数来记录到了第几小的节点，
 * 先依次压栈走到最左节点，在当前头为空的情况下弹出顶层节点作为当前头，记录数加一
 * 下个继续将当前头结点依次压栈走到最左节点
 * @author HJH
 *
 * @date 2019年3月19日
 */
public class KthNode {
	int c = 0;
    TreeNode kthNode(TreeNode pRoot, int k){
        if(c > k || pRoot == null) return null;
        TreeNode head = pRoot;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                if(++c == k) return stack.pop();
                head = stack.pop();
                head = head.right;
            }
        }
        return null;
    }
}
