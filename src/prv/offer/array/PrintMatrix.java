package prv.offer.array;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 可以模拟魔方逆时针旋转的方法，一直做取出第一行的操作
 * 例如 
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 输出并删除第一行后，再进行一次逆时针旋转，就变成：
 * 6 9
 * 5 8
 * 4 7
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class PrintMatrix {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0){
            return null;
        }
        ArrayList<Integer> rs = new ArrayList<Integer>();
        int tC = 0, tR = matrix.length - 1, sC = 0, sR = matrix[0].length - 1;
        while(tC <= tR && sC <= sR){
            if(tR == tC){
                for (int i=sC;i<=sR;i++){
                    rs.add(matrix[tC][i]);
                }
                return rs;
            } else if (sR == sC){
                for (int i=tC;i<=tR;i++){
                    rs.add(matrix[i][sC]);
                }
                return rs;
            }
            for(int i=sC;i<sR;i++){
                rs.add(matrix[tC][i]);
            }
            for(int i=tC;i<tR;i++){
                rs.add(matrix[i][sR]);
            }
            for(int i=sR;i>sC;i--){
                rs.add(matrix[tR][i]);
            }
            for(int i=tR;i>tC;i--){
                rs.add(matrix[i][sC]);
            }
            tC ++;
            tR --;
            sC ++;
            sR --;
        }
        return rs;
    }
}
