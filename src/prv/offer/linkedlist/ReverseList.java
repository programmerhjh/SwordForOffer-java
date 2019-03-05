package prv.offer.linkedlist;

import prv.offer.model.ListNode;

/**
 * 反转链表
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode s = head, t = null, p = null;
        while(head != null){
            t = s.next;
            s.next = p;
            if(t == null){
                break;
            };
            p = s;
            s = t;
        }
        return s;
    }
}
