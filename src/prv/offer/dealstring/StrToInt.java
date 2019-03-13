package prv.offer.dealstring;

/**
 * 把字符串转换成整数
 * 
 * 使用字符数组，从后往前根据len-i的位数依次pow并且根据flag正负相乘，最后相加在rs上得出最后结果
 * 
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class StrToInt {
	public int strToInt(String str) {
        if(str.length() == 0) return 0;
        char[] arr = str.toCharArray();
        int rs = 0, len = arr.length-1, flag = 1;
        char o = arr[0];
        if (o == '-') {
            flag = -1;
        }
        for(int i=len;i>=0;i--){
            char c = arr[i];
            if((c < '0' || c > '9') && c != '-' && c != '+') return 0;
            if (c == '-' || c == '+') continue;
            rs += (c - '0') * Math.pow(10, len-i) * flag;
        }
        return rs;
    }
}
