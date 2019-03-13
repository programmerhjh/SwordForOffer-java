package prv.offer.function;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * 使用数组模拟一群孩子的编号，将淘汰的人的下标标志为-1
 * 到数组终点时，起点重置为0， 遇到-1时跳过，否则步数加一
 * n为0时退出循环
 * 
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class LastRemaining {
	public int lastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1) return -1;
        int[] p = new int[n];
        int c = -1, step = 0;
        while(n > 0){
            c ++;
            if(c >= p.length) c = 0;
            if(p[c] == -1) continue;
            step ++;
            if(step == m){
                step = 0;
                p[c] = -1;
                n --;
            }
        }
        return c;
    }
}
