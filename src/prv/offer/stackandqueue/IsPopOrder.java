package prv.offer.stackandqueue;

import java.util.ArrayList;

/**
 * 栈的压入、弹出序列
 * 借用一个辅助数组，遍历压栈和出栈顺序进行匹配。
 * 这样循环等压栈顺序遍历完成。
 * 如果辅助栈还不为空，在匹配弹出序列是不是该栈的弹出顺序，如果有一个不一样说明错误
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class IsPopOrder {
	public boolean isPopOrder(int [] pushA,int [] popA) {
        if((pushA.length == 0 || popA.length == 0) || popA.length != pushA.length){
            return false;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 0, p = 0;
        while(i < pushA.length && p < popA.length){
            if(pushA[i] == popA[p]){
                i++;
                p++;
            } else {
                arr.add(pushA[i++]);                
            }
        }
        if(p >= 0 && p < popA.length){
            while(!arr.isEmpty()){
                if(arr.get(arr.size()-1) == popA[p]){
                    arr.remove(arr.size()-1);
                    p++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
