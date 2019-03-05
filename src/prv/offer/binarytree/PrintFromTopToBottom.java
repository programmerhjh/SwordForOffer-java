package prv.offer.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import prv.offer.model.TreeNode;

/**
 * 从上往下打印二叉树
 * 借助一个队列迭代
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class PrintFromTopToBottom {
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        if (root == null){
            return rs;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            rs.add(node.val);
        }
        return rs;
    }
}
