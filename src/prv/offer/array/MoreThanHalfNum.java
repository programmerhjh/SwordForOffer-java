/**
 * 
 */
package prv.offer.array;

/**
 * 数组中出现次数超过一半的数字
 * 一次循环比较中得到的必是数组中的众数之一，再进行双倍校验
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class MoreThanHalfNum {
	public int moreThanHalfNum_Solution(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        int result = array[0], times = 1, length = array.length;
        for(int i=1;i<length;i++)
            if(times == 0){
                result = array[i]; times = 1;
            }else{
                if(array[i] == result) times++; else times--;
            }
        times = 0;
        for(int i=0;i<length;i++) if(result==array[i]) times++;
        if(times * 2 <= length) result = 0;
        return result;
    }
}
