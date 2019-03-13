package prv.offer.other;

/**
 * 求1+2+3+...+n
 * 
 * 题目描述：
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * 使用短路与中断递归
 * 
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class Sum_Solution {
	public int sum_Solution(int n) {
		return n > 0 && (n += sum_Solution(n-1)) > 0 ? n : n;
    }
}
