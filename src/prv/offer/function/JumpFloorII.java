package prv.offer.function;

/**
 * 变态跳台阶
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class JumpFloorII {

	public int jumpFloorII(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        int a = 1, b = 2;
        for (int i=2;i<=target;i++) {
            b = 2 * a;
            a = b;
        }
        return b;
    }
	
}
