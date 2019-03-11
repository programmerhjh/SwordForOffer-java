package prv.offer.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 比较器排序
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class PrintMinNumber {
	public String printMinNumber(int [] numbers) {
        int n = numbers.length;
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++) list.add(numbers[i]);
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer str1,Integer str2){
                return (str1 + "" + str2).compareTo(str2 + "" + str1);
            }
        });
        for(int j:list) s.append(j);
        return s.toString();
    }
}
