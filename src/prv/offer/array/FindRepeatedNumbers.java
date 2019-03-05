package prv.offer.array;

import java.util.ArrayList;

/**
 * 找出数组中重复的数字
 * @author HJH
 * @date 2019年3月3日
 */
public class FindRepeatedNumbers {
	
	public ArrayList<Integer> findRepeatedNum(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		ArrayList<Integer> rs = new ArrayList<>();
		mergeSort(nums, 0, nums.length-1);
		int temp = nums[0], i = 1;
		while(i < nums.length) {
			int j = nums[i];
			if (temp == j) {
				rs.add(j);
				while(nums[++i] == temp);
			} else {
				temp = j;
				i ++;
			}
		}
		return rs;
	}
	
	public void mergeSort(int[] nums, int s, int e) {
		if (s >= e) {
			return;
		}
		int m = (s + e) >> 1;
		mergeSort(nums, s, m);
		mergeSort(nums, m+1, e);
		merge(nums, s, e, m);
	}
	
	public void merge(int[] nums, int s, int e, int m) {
		int k = 0, p1 = s, p2 = m + 1;
		int[] help = new int[e-s+1];
		while(p1 <= m && p2 <= e) {
			if (nums[p1] <= nums[p2]) {
				help[k++] = nums[p1++];
			} else {
				help[k++] = nums[p2++];
			}
		}
		while(p1 <= m) {
			help[k++] = nums[p1++];
		}
		while(p2 <= e) {
			help[k++] = nums[p2++];
		}
		for (int i=0;i<help.length;i++) {
			nums[i+s] = help[i];
		}
	}
	
}
