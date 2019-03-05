package prv.offer.binarytree;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 因为后序遍历根是永远大于左子树任何一个节点，小于右子树任何一个节点，只要有人以一个节点不符合该条件即不是BST的后序遍历
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class VerifySquenceOfBST {
	public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        } else if(sequence.length < 3){
            return true;
        }
        int rootIndex = sequence.length - 1;
        return jg(0, rootIndex, sequence);
    }
    
    public boolean jg(int s, int e, int[] a){
        if(s >= e){
            return true;
        }
        int l = e;
        while(l > s && a[e] < a[l-1]) l--;
        for(int i=s;i<l;i++)
            if(a[i] > a[e])
                return false;
        return jg(s, l-1, a) && jg(l, e-1, a);
    }
}
