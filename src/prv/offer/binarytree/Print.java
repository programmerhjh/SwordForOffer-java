package prv.offer.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import prv.offer.model.TreeNode;

/**
 * 两个层次打印二叉树的题合并
 * @author HJH
 *
 * @date 2019年3月18日
 */
public class Print {
	
	/**
	 * 题目：按之字形顺序打印二叉树
	 * 
	 * 题目描述
	 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
	 * 
	 * 用一个标识记录层数, 两个栈记录每层的节点顺序，奇数从左向右压入依次先压左节点再压右节点，偶数从右向左压入依次先压右节点再压左节点
	 * 每层判断哪个栈不为空就弹哪个栈
	 * @param pRoot
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        if (pRoot == null) return rs;
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(pRoot);
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            if (layer % 2 != 0){
                while (!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    if(node != null){
                        temp.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
            } else {
                while (!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    if(node != null){
                        temp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
            }
            if (!temp.isEmpty()){
                rs.add(temp);
                layer ++;
            }
        }
        return rs;
    }
	
	/**
	 * 题目：把二叉树打印成多行
	 * 
	 * 题目描述
	 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
	 * 
	 * 按上面那道题的思路，这次换成两个队列交错打印
	 * @param pRoot
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        if(pRoot == null) return rs;
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(pRoot);
        while(!q1.isEmpty() || !q2.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    TreeNode p = q1.poll();
                    if(p != null){
                        temp.add(p.val);
                        q2.add(p.left);
                        q2.add(p.right);
                    }
                }
            } else {
                while(!q2.isEmpty()){
                    TreeNode p = q2.poll();
                    if(p != null){
                        temp.add(p.val);
                        q1.add(p.left);
                        q1.add(p.right);
                    }
                }
            }
            if(!temp.isEmpty()){
                rs.add(temp);
            }
        }
        return rs;
    }
}
