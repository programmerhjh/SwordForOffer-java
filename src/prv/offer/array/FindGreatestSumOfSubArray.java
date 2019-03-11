package prv.offer.array;

/**
 * 连续子数组的最大和
 * 遍历一次数组，每次遍历都加上当前值和比较当前和，如果当前和为负数则重新把当前和改为当前下标的值
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class FindGreatestSumOfSubArray {
	public int findGreatestSumOfSubArray(int[] array) {
        int tempSum = 0, rs = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(tempSum < 0) tempSum = array[i]; else tempSum += array[i];
            if(tempSum > rs) rs = tempSum;
        }
        return rs;
    }
}
