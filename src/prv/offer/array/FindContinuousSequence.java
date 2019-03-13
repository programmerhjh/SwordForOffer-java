package prv.offer.array;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 用双指针，先确认末指针的位置，然后进行循环取结果，当sum大于预期值时，头指针加一，小于预期值时，末指针加一
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class FindContinuousSequence {
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        if (sum <= 0) return rs;
        int p = 0, s = 0, a = -1, len = sum/2+1;
        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i=0;i<len;i++) {
            list.add(i+1);
            if ((s >= sum && a == -1)) a = i-1;
            else if (s < sum) s += i+1;
        }
        if ((s >= sum && a == -1)) {
            a = len;
            if (s == sum && a - p > 1) rs.add(new ArrayList<>(list.subList(p++, a)));
        }
        if (a == -1) return rs;
        while(a < len && a - p > 0) {
            if (s > sum)
                s -= list.get(p++);
            else if (s < sum)
                s += list.get(++a);
            else {
                s -= list.get(p);
                if (a < len - 1) s += list.get(++a);
                else s += list.get(a++);
                rs.add(new ArrayList<>(list.subList(p++, a)));
            }
        }
        return rs;
    }
}
