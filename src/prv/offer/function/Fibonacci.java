package prv.offer.function;

/**
 * 斐波那契数列
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class Fibonacci {
	public int fibonacci(int n) {
        int preNum = 1, prePreNum = 0, result = 0;
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        for(int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;
    }
}
