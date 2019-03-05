package prv.offer.bitoperation;

/**
 * 二进制中1的个数
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class NumberOf1 {
	public int numberOf1(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}
