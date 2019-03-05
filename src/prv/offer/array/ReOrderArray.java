package prv.offer.array;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 插入排序思想
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class ReOrderArray {
	public void reOrderArray(int [] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0;//记录已经摆好位置的奇数的个数
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {//j >= k+1
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }
}
