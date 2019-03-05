package prv.offer.array;

/**
 * 旋转数组的最小数字
 * 采用二分查找
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class MinNumberInRotateArray {

	public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int start = 0, end = array.length - 1, mid = end >> 1;
        while(start < mid){
            if(array[end] < array[mid]){
                start = mid;
                mid = (end + start) >> 1;
            } else {
                end = mid;
                mid = (end + start) >> 1;
            }
        }
        return array[start] > array[end] ? array[end] : array[start];
    }
	
}
