package prv.offer.array;

/**
 * 数组中只出现一次的数字
 * 首先循环数组并异或数组每个数，得到的肯定是两个单独出现一次的数的异或结果
 * 接着确定该异或结果的最低位1的位置
 * 然后根据该位置上是否为1分为两部分进行异或，得到的就是两个只出现一次的数
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class FindNumsAppearOnce {
	public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
}
