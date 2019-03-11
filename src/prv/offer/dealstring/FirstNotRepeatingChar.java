package prv.offer.dealstring;

/**
 * 第一个只出现一次的字符
 * 创建一个int数组，遍历字符数组在对应下标上加一
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class FirstNotRepeatingChar {
	public int firstNotRepeatingChar(String str) {
        char[] c = str.toCharArray();
        int[] a = new int['z'+1];
        for (char d:c) a[d]++;
        for (int i=0;i<c.length;i++) if(a[c[i]] == 1) return i;
        return -1;
    }
}
