package prv.offer.array;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * 在一个有序树组中，数字隔越远乘积越小
 * 双指针法，头指针末指针加起来的和大于目标值则末指针后移一位，小于则头指针前移一位
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class FindNumbersWithSum {
	public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> rs = new ArrayList<>(10);
        if (array.length == 0) return rs;
        int len = array.length, s = 0, e = len - 1;
        while(s < e){
            int p = array[s], a = array[e], t = p + a;
            if (t == sum) {
                rs.add(p);
                rs.add(a);
                break;
            } else if (t > sum){
                e --;
            } else {
                s ++;
            }
        }
        return rs;
    }
}
