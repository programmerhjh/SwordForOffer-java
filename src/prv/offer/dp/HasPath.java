package prv.offer.dp;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 矩阵中的路径
 * 
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 
 * 由于给的图是一个一维数组，所以直接新建一个与其一样长的标志数组，判断是否该条路径走过
 * 由于没有给起点，则数组中任意一点都可能为起点
 * 先计算当前点的下标，并判断是否越界，是否访问过，当前位置是否与字符位置匹配
 * 如果已经匹配到最后一个字符则返回 true
 * 标志数组中当前位置置为true
 * 如果上下左右都走不通回退再次置为false未走过并返回false
 * 
 * @author HJH
 *
 * @date 2019年3月20日
 */
public class HasPath {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(str == null || matrix == null || matrix.length == 0 || rows <= 0 || cols <= 0) return false;
        boolean[] f = new boolean[matrix.length];
        for(int i=0;i<rows;i++) for(int j=0;j<cols;j++) if(jg(f, matrix, rows, cols, str, 0, i, j)) return true;
        return false;
    }
    public boolean jg(boolean[] f, char[] mr, int rows, int cols, char[] str, int c, int i, int j){
        int index = i*cols + j;
        if(i<0 || j<0 || rows<=i || cols<=j || mr[index]!=str[c] || f[index]==true) return false;
        if(c == str.length-1) return true;
        f[index] = true;
        if(
            jg(f, mr, rows, cols, str, c+1, i, j+1) 
            || jg(f, mr, rows, cols, str, c+1, i, j-1) 
            || jg(f, mr, rows, cols, str, c+1, i+1, j) 
            || jg(f, mr, rows, cols, str, c+1, i-1, j)
        ) return true;
        f[index] = false;
        return false;
    }
}
