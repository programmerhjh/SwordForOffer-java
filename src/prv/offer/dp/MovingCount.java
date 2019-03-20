package prv.offer.dp;

import java.util.Stack;

/**
 * 机器人的运动范围
 * 
 * 题目描述
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * 
 * 思路：不带记忆的DFS搜索 + 限定条件 = 普通的DSF例题
 * 1.需要记录已经遍历过的节点，用辅助矩阵visited[rows * cols]
 * 2.每次加入栈时，count++，标记已经遍历，这样下一个节点就不会遍历了
 * 入栈条件：
 * 1.每一位的和小于等于threshold：
 * 2.x和 y  的边界条件
 * 3.没有遍历过
 * 
 * @author HJH
 *
 * @date 2019年3月20日
 */
public class MovingCount {
	public int movingCount(int threshold, int rows, int cols){
        if(rows <= 0 || cols <= 0 || threshold < 0) return 0;
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[rows*cols];
        int[][] xoy = {{0,1,0,-1}, {1,0,-1,0}};
        int count = 0;
        s.add(0);
        visited[0] = true;
        while(!s.empty()) {
            int cur = s.pop();
            // 栈不为空时就加一，代表走过的格子数
            count++;
            for (int i=0;i<4;i++) {
                // 1,0 2,0 3,0 ... 逐行变换x坐标, 当行数可以整除 cols 时，换为新的一列
                int x = cur % cols + xoy[0][i], y = cur / cols + xoy[1][i], sum = getDigitSum(x) + getDigitSum(y); 
                // 不越界，坐标之和小于k，所处位置未走过的时候表示当前位置还可以继续走，把当前标志数组的下标添加进栈
                if(x >= 0 && x < cols && y >= 0 && y < rows 
                   && sum <= threshold && !visited[x + y * cols]) {
                    s.add(x + y * cols);
                    visited[x + y * cols] = true;
                }
            }
        }
        return count;
    }
    private int getDigitSum(int i) { //获取数字各位的和
        int sum = 0;
        while(i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
