package prv.offer.bitoperation;

/**
 * 数值的整数次方
 * 快速幂
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class Power {
	public double power(double base, int exponent) {
        int temp = exponent;
        if(exponent < 0){
            exponent = -exponent;
        }else if(exponent == 0){
            return 1;
        }
        double res = 1, curr = base;
        while(exponent != 0){
            if((exponent & 1) == 1)
                res *= curr;
            curr *= curr;
            exponent >>= 1;
        }
        return temp >= 0 ? res : 1 / res;
    }
}
