/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start

import java.util.Stack;

class MinStack {
    private static Stack<Integer> stack;
    private static Stack<Integer> minStack;
    // private static int minVal;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        // minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        // minVal = Math.min(val, minVal);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
        // minVal = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

