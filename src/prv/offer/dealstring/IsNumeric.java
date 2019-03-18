package prv.offer.dealstring;

/**
 * 表示数值的字符串
 * 
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * @author HJH
 *
 * @date 2019年3月14日
 */
public class IsNumeric {
	public boolean isNumeric(char[] str) {
        if(str.length == 0) return false;
        int len = str.length, p = 0;
        for(int i=0;i<len;i++){
            char c = str[i];
            if((c == '+' || c == '-') || (c >= '0' && c <= '9') || (c == 'e' || c == 'E') || c == '.'){
                if(c == '.') {
                    if (i == 0 || i == len-1) return false;
                    p++;
                    if (p > 1 || searchPreE(str, i)) return false;
                }
                if((c == '+' || c == '-') && (i == len-1 || (i != 0 && (str[i-1] != 'e' && str[i-1] != 'E')))) return false;
                if((c == 'e' || c == 'E') && ((i == 0 || i == len-1) || (str[i+1] != '-' && str[i+1] != '+' && (str[i+1] < '0' || str[i+1] > '9')))) return false;
            } else
                return false;
        }
        return true;
    }

    public boolean searchPreE(char[] a, int index){
        while (index-- > 0){
            char c = a[index];
            if (c == 'E' || c == 'e'){
                return true;
            }
        }
        return false;
    }
}
