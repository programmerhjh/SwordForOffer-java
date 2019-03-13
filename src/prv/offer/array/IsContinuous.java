package prv.offer.array;

/**
 * 扑克牌顺子 
 * 
 * 核心思路：
 * 1.先用一个长度为14的数组，记忆原始数据，下标为值，值为下标出现的次数。
 * 2.按下标从小到大找到第一个不为0的数counts[i]（一定有，因为一共5个数，撑死4个0）。
 * 3.从counts[i]访问到counts[i+5]：
 * 如果counts[i] == 0：就counts[0]--,（类比成拿一个0来顶）；如果没有0可以用来顶，说明没法构成顺子，返回false；
 * 如果能顺利的访问完，就说明是顺子；
 * 如果不能访问完，就说明因为访问到了数组的边界而提前退出访问了。（比如 0,0,12,12,13） 这时我们就需要判断 已经连成的顺子的长度+counts[0]是否==5.
 * 如果相等，就可以把0补到最左边组成顺子，true；
 * 如果不等，说明有非0的对子，false；
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class IsContinuous {

	public boolean isContinuous(int[] numbers) {
		int[] counts = new int[14];
		for (int num : numbers)
			counts[num]++;
		int left, i;
		for (left = 1; left < 14; left++)
			if (counts[left] != 0)
				break;
		// 用left记下最小的一个非0数字
		for (i = left + 1; i <= left + 4 && i < 14; i++)
			if (counts[i] == 0)
				if (counts[0] == 0)
					return false;
				else
					counts[0]--;
		if (i == left + 5)
			return true;
		else if (14 - left + counts[0] == 5)
			return true;
		else
			return false;
	}

}
