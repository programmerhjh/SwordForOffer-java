/**
 * 
 */
package prv.offer.array;

/**
 * 二维数组的查找
 * @author HJH
 *
 * @date 2018年12月2日
 */

public class TwoDimensionalArraySearch {

	public static boolean Find(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) {
			return false;
		}
        int col = 0, row = array.length-1;
        while (row >= 0 && col < array[0].length) {
			if (target < array[row][col]) {
				row --;
			} else if (target > array[row][col]) {
				col ++;
			} else {
				return true;
			}
		}
        
        return false;
	}

}
