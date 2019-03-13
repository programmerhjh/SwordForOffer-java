package prv.offer.dealstring;

/**
 * 左旋转字符串
 * 思路：
 * 1.先翻转前半部分
 * 2.再翻转后半部分
 * 3.再对字符串整个进行翻转
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class LeftRotateString {
	public String leftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0 || n > str.length()) {
            return str;
        }
        char[] ch = str.toCharArray();
        reverseString(ch, 0, n - 1);
        reverseString(ch, n, str.length() - 1);
        reverseString(ch, 0, str.length() - 1);
        return new String(ch);
    }
    public void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}
