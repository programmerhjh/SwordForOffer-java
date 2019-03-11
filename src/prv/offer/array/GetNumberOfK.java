package prv.offer.array;

/**
 * 数字在排序数组中出现的次数 使用二分法进行查找数字，在对数字左右两端进行遍历
 * 
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class GetNumberOfK {
	public int getNumberOfK(int[] array, int k) {
		if (array.length == 0)
			return 0;
		else if (array.length == 1)
			if (k == array[0])
				return 1;
		int rs = 0, l = 0, r = array.length - 1, index = -1, temp;
		while (l < r) {
			int m = (l + r) >> 1;
			if (array[m] > k)
				r = m - 1;
			else if (array[m] < k)
				l = m + 1;
			else {
				index = m;
				break;
			}
		}
		if (index == -1)
			return 0;
		else {
			temp = index;
			rs++;
			while (temp >= 1) {
				if (array[index] == array[--temp])
					rs++;
				else
					break;
			}
			temp = index;
			while (temp <= array.length - 2) {
				if (array[index] == array[++temp])
					rs++;
				else
					break;
			}
		}
		return rs;
	}
}
