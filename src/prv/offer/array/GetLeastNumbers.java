package prv.offer.array;

import java.util.ArrayList;

/**
 * 最小的K个数
 * 运用插排思想，每次找出最小一个与数组最后确定的元素下标交换
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class GetLeastNumbers {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> rs = new ArrayList();
        if(k == 0 || input.length == 0 || k > input.length) return rs;
        for(int i=0;i<k;i++){
            int minIndex = 0;
            for(int j=0;j<input.length-i;j++){
                if(input[j] < input[minIndex]){
                    minIndex = j;
                }
            }
            swap(input, minIndex, input.length-i-1);
        }
        for(int i=input.length-1;i>input.length-k-1;i--) rs.add(input[i]);
        return rs;
    }
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
