package prv.offer.model;

/**
 * next 代表父节点
 * @author HJH
 *
 * @date 2019年3月18日
 */
public class TreeLinkNode {
	public int val;
	public TreeLinkNode left = null;
	public TreeLinkNode right = null;
	public TreeLinkNode next = null;
	public TreeLinkNode(int val) {
        this.val = val;
    }
}
