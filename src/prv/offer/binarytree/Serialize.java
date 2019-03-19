package prv.offer.binarytree;

import prv.offer.model.TreeNode;

/**
 * 序列化，反序列化二叉树
 * 
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * 序列化时，建立一个StringBuilder，然后先加头节点，再左右节点一直递归加到StringBuilder
 * 反序列化时，用一个整数标识当前所在的字符位置，根据当前下标所在的字符和字符是否为‘#’字符判断头结点是否为空节点，不为空则建立新节点，依次递归加上左右节点
 * 
 * @author HJH
 *
 * @date 2019年3月19日
 */
public class Serialize {
	int index = -1;
    /**
     * 遇到节点为空时追加 '#'
     * 该方法与 deserialize 方法配合使用
     * @param root
     * @return 二叉树序列字符串
     */
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    
    /**
     * 遇到 '#' 代表到了空叶子，返回空
     * @param str
     * @return 已连接好的节点
     */
    TreeNode deserialize(String str) {
        index++;
        String[] sp = str.split(",");
        TreeNode node = null;
        if(!sp[index].equals("#")){
            node = new TreeNode(Integer.valueOf(sp[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }
}
