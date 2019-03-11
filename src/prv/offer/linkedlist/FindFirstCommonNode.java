package prv.offer.linkedlist;

import prv.offer.model.ListNode;

/**
 * 两个链表的第一个公共结点
 * 先计算两个链表的长度，长的比短的长多少（sublen）
 * 然后长的先走sublen步，然后两个链表一起走
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class FindFirstCommonNode {
	public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        int s1 = 1, s2 = 1;
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != null){
            p1 = p1.next;
            s1 ++;
        }
        while(p2 != null){
            p2 = p2.next;
            s2 ++;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(s1 > s2) 
        	for(int i=0;i<s1-s2;i++) p1 = p1.next;
        else 
        	for(int i=0;i<s2-s1;i++) p2 = p2.next;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
