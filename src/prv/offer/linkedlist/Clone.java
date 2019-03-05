package prv.offer.linkedlist;

import prv.offer.model.RandomListNode;

/**
 * 复杂链表的复制
 * @author HJH
 *
 * @date 2019年3月4日
 */
public class Clone {
	public RandomListNode clone(RandomListNode pHead)
    {
        if (pHead == null) {
			return null;
		}
		RandomListNode cur = pHead;
		RandomListNode next = null;
		// 首先在每个节点后面加上一个自我复制节点
		while (cur != null) {
			next = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = next;
			cur = next;
		}
		cur = pHead;
		RandomListNode curCopy = null;
		// 再把这些新节点的random通过跨越两个节点（即跨越新节点到达老节点），来找到老节点并以老节点的random链接新节点的分支
		// 先不连接新节点的next，后面分离有用到
        while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.random = cur.random != null ? cur.random.next : null;
			cur = next;
		}
		RandomListNode res = pHead.next;
		cur = pHead;
		// 在从原链表分离出复制链表
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
    }
}
