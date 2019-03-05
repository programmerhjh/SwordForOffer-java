package prv.offer.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

import prv.offer.model.ListNode;

/**
 * 从尾到头打印链表
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class PrintListFromTailToHead {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> rs = new ArrayList<Integer>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            rs.add(stack.pop());
        }
        return rs;
    }
	
}
