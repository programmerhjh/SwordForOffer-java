package prv.offer.stackandqueue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 栈2为空把栈1压入，栈2不为空时必须先pop栈2
 * @author HJH
 *
 * @date 2019年3月3日
 */
public class ImplementQueuesWithTwoStacks {

	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }
	
}
