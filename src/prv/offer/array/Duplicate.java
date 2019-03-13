/**
 * 
 */
package prv.offer.array;

/**
 * 数组中重复的数字
 * 
 * 建一个长度到字符‘9’的字符数组，依次遍历数组数字并加入到对应的ASCII码下标的字符数组。
 * 遇到第一个字符下标为1的（证明之前已经加入过），直接返回退出
 * 
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class Duplicate {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0) return false;
        char[] arr = new char['9'];
        for(int i=0;i<length;i++){
            int n = numbers[i];
            char c = arr['0'+n];
            if(c >= 1){
                duplication[0] = n;
                return true;
            } else {
                arr['0'+n] = (char) (arr['0'+n] + 1);
            }
        }
        return false;
    }
}
