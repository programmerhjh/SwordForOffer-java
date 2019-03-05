package prv.offer.linkedlist;

import prv.offer.model.ListNode;

/**
 * 合并两个排序的链表
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class Merge {
	public ListNode merge(ListNode list1,ListNode list2) {
        if(list1 != null && list2 == null){
            return list1;
        } else if(list1 == null && list2 != null){
            return list2;
        } else if(list1 == null && list2 == null){
            return null;
        }
        ListNode t, p;
        if(list1.val > list2.val){
            t = list2;
            list2 = list2.next;
        } else {
            t = list1;
            list1 = list1.next;
        }
        p = t;
        while(list1 != null && list2 != null){
            if(list2.val > list1.val){
                t.next = list1;
                list1 = list1.next;
            } else {
                t.next = list2;
                list2 = list2.next;
            }
            t = t.next;
        }
        //把未结束的链表连接到合并后的链表尾部
        if(list1 != null){
            t.next = list1;
        } else{
            t.next = list2;
        }
        return p;
    }
}
