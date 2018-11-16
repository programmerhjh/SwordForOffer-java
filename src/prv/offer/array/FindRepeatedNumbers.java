/**
 * 找出数组中重复的数字
 */
package prv.offer.array;

import java.util.HashSet;

/**
 * @author HJH
 *
 * @date 2018年11月16日
 */
public class FindRepeatedNumbers {
	
	public static HashSet<Integer> findRepeatedNum(int nums[]) {
		if (nums.length <= 0) {
			return null;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums.length-1 || nums[i] < 0) {
				return null;
			}
		}
		HashSet<Integer> result = new HashSet<Integer>();
		for (int i = 0; i < nums.length;) {
			int j = nums[i];
			if (i != j) {
				// 交换下标i，j的数字
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				// 交换后还和原来位置的值一样，说明重复了，加入结果集，下标加一
				if (nums[i] == j) {
					result.add(j);
					i++;
				}
			} else {
				// 如果下标和对应下标的值一样说明该数字位置正确，下标加一
				i++;
			}
		}
		return result;
	}
	
}
