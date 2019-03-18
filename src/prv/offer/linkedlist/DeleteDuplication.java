package prv.offer.linkedlist;

import prv.offer.model.ListNode;

/**
 * 删除链表中重复的结点
 * 
 * 题目描述 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * 思路都是找不重复的节点添加到当前节点的next，如果重复就遍历到不重复的点再继续添加
 * @author HJH
 *
 * @date 2019年3月18日
 */
public class DeleteDuplication {
	
	/**
	 * 递归
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication1(ListNode pHead) {
		if (pHead == null)
			return null;
		if (pHead.next == null)
			return pHead;
		ListNode cur;
		// 对重复结点的处理
		if (pHead.val == pHead.next.val) {
			cur = pHead.next.next;
			// 遍历到没有重复结点的位置
			while (cur != null && cur.val == pHead.val) {
				cur = cur.next;
			}
			return deleteDuplication1(cur);
		}
		// 该结点不重复，递归下一个结点
		cur = pHead.next;
		pHead.next = deleteDuplication1(cur);
		return pHead;
	}
	
	/**
	 * 非递归
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication(ListNode pHead){
        ListNode q, p, r;
        p = pHead;
        q = r = null;
        while (p != null) {
            boolean flag = false;
            r = p.next;
            while (r != null && r.val == p.val) {
                flag = true;
                r = r.next;
            }
            if (flag) {
                if (q != null)
                    q.next = r;
                else
                    pHead = null;
            } else {
                if (q == null)
                    pHead = p;
                q = p;
            }
            p = r;
        }
        return pHead;
    }
}
