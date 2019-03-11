package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 二叉搜索树与双向链表
 * 右中左顺序
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class Convert {
	
	// 保存父节点
    TreeNode temp = null;
    public TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree != null){
            return convert2(pRootOfTree);
        }
        return pRootOfTree;
    }
    
    public TreeNode convert2(TreeNode cur) {
        if(cur != null){
            convert2(cur.right);
            if(temp == null){
                // 到达了最右最大的数
                temp = cur;
            } else {
                // 不为空则开始连接
                temp.left = cur;
                cur.right = temp;
                temp = cur;
            }
            convert2(cur.left);
        }
        return temp;
    }
	
}
