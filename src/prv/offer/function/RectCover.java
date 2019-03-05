package prv.offer.function;

/**
 * 矩形覆盖
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class RectCover {
	public int rectCover(int target) {
		int tempNum = 1, result = 2, count = 2;
        if (target == 0 || target == 1 || target == 2) return target;
        while (count < target) {
            result += tempNum;
            tempNum = result - tempNum;
            count ++;
        }
        return result;
    }
}
