package prv.offer.dealstring;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 * 循环加递归，加上数组中的contains方法检查重复
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class Permutation {

	public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }
	
	public void permutationHelper(char[] arr, int index, ArrayList<String> rs) {
		if (index == arr.length - 1) {
			String str = new String(arr);
			if (!rs.contains(str)) {
				rs.add(str);
			}
		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, i, index);
				permutationHelper(arr, i+1, rs);
				swap(arr, i, index);
			}
		}
	}
	
	public void swap(char[] arr, int i, int j) {
		char t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
