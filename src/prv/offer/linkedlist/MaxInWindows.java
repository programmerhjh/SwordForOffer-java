package prv.offer.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * 
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * 使用队列保存数组下标，保存滑动窗口中最大的数并做下标过期处理
 * @author HJH
 *
 * @date 2019年3月19日
 */
public class MaxInWindows {
	public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> rs = new ArrayList<>();
        if(num == null || num.length == 0 || size == 0 || size > num.length) return rs;
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0;i<num.length;i++){
            // 从队尾最小的开始比较，如果比队尾大，就筛选掉最先不可能作为最大值的元素下标
            while(!q.isEmpty() && num[q.peekLast()] < num[i]) q.pollLast();
            // 加入当前元素下标
            q.addLast(i);
            // 如果队头下标等于当前左边界下标，弹出
            if(q.peekFirst() == i - size) q.pollFirst();
            // 当滑动窗口满的时候加入结果集
            if(i >= size - 1) rs.add(num[q.peekFirst()]);
        }
        return rs;
    }
}
