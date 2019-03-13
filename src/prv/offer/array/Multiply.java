package prv.offer.array;

/**
 * 构建乘积数组
 * 
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * 最优解的关键在于找到规律：
 * B[i]=A(0)*A(1)*...A(i-1)乘以A(i+1)*A(i+2)*...*A(n)
 * 如A数组：[3,5,7,9],
 * 第一部分乘积分别为---> 9*7*5*1，9*7*1，9*1，1
 * 第二部分乘积分别为---> 1，1*3，1*3*5，1*3*5*7
 * 由此可以看出规律
 * 
 * @author HJH
 *
 * @date 2019年3月13日
 */
public class Multiply {
	public int[] multiply(int[] A) {
        if(A.length==0) return new int[]{};
        int len = A.length;
        int[] rs = new int[len];
        rs[0] = 1;
        for(int i=1;i<len;i++){
            rs[i] = rs[i-1] * A[i-1];
        }
        int t = 1;
        for(int i=len-2;i>=0;i--){
            t *= A[i+1];
            rs[i] *= t;
        }
        return rs;
    }
}
