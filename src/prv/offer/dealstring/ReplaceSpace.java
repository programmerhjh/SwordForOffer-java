/**
 * 
 */
package prv.offer.dealstring;

/**
 * 字符串里面的空格字符装换为%20
 * @author HJH
 *
 * @date 2018年12月6日
 */
public class ReplaceSpace {
	
	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer(" ")));
	}
	
	public static String replaceSpace(StringBuffer str) {
		if (str.length() <= 0) {
			return "";
		}
		String space = "%20", result = "";
		char[] charArray = str.toString().toCharArray();
		int mark = 0, chlen = charArray.length;
		String[] split;
		if (str.toString().trim().length() == 0) {
			for (int i = 0; i < str.length(); i++) {
				result += space;
			}
			return result;
		} else {
			split = str.toString().split("\\s+");
		}
    	for (int i = 0; i < split.length; i++) {
			result += split[i];
			int offset = split[i].length();
			mark += offset;
			if (mark >= chlen) {
				break;
			}
			while (charArray[mark] == ' ') {
				result += space;
				mark ++;
				if (mark >= chlen) {
					break;
				}
			}
		}
		return result;
    }
	
}
