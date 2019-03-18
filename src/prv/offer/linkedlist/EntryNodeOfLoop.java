package prv.offer.linkedlist;

import prv.offer.model.ListNode;

/**
 * 链表中环的入口结点
 * 
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 * 两个节点，一个一次走一步，一个一次走两步，相遇则存在环，有一个先为空则无环
 * 有环则重置一个节点到头部，然后两个节点一直走到相遇即是环的入口节点
 * 
 * @author HJH
 *
 * @date 2019年3月18日
 */
public class EntryNodeOfLoop {
	public ListNode entryNodeOfLoop(ListNode pHead){
        if(pHead == null) return null;
        ListNode p = pHead, a = pHead;
        while((p = p.next) != null && (a = a.next.next) != null){
            if(p == a){
                p = pHead;
                while(p != a){
                    p = p.next;
                    a = a.next;
                }
                return p;
            }
        }
        return null;
    }
}
