package prv.offer.dealstring;

/**
 * 正则表达式匹配
 * 
 *
 * 当模式中的第二个字符不是“*”时：
 * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 * 
 * 而当模式中的第二个字符是“*”时：
 * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 * 1、模式后移2字符，相当于x*被忽略；
 * 2、字符串后移1字符，模式后移2字符；
 * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 * 
 * @author HJH
 *
 * @date 2019年3月14日
 */
public class Match {
	public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        // 字符串下标
        int strIndex = 0;
        // 匹配字符串下标
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }
  
    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 如果字符串下标和匹配规则字符串走完了直接return true
    	if (strIndex == str.length && patternIndex == pattern.length) return true;
        // 如果匹配规则字符串先走完则return false
    	if (strIndex != str.length && patternIndex == pattern.length) return false;
        // 如果后一个字符为 *
    	if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 如果当前匹配字符串字符为 . 或者与当前字符串的字符相等则分为三种情况
    		if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
    			return  // 假设不存在匹配字符串直接越过两个下标过如果还是可以走完递归则证明可以匹配
    					matchCore(str, strIndex, pattern, patternIndex + 2) || 
                        // 假设只存在一个匹配字串直接越过两个下标过如果还是可以走完递归则证明可以匹配
                        matchCore(str, strIndex + 1, pattern, patternIndex + 2) || 
                        // 假设有n个字符可以匹配则字符串匹配坐标不进行改变，如果还是可以走完递归则证明可以匹配
                        matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
            	// 如果都不匹配则匹配字符串直接越过两个下标
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
    	// 如果当前匹配字符串字符为 . 或者与当前字符串的字符相等则进入下一个递归
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
