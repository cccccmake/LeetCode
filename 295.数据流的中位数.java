/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private Queue<Integer> numsA;
    private Queue<Integer> numsB;

    public MedianFinder() {
        numsA = new PriorityQueue<>();
        numsB = new PriorityQueue<>((x, y) -> (y - x));
    }
    
    public void addNum(int num) {
        if(numsA.size() != numsB.size()){
            numsA.add(num);
            numsB.add(numsA.poll());
        }else{
            numsB.add(num);
            numsA.add(numsB.poll());
        }
    }
    
    public double findMedian() {
        return numsA.size() == numsB.size() ? (numsA.peek() + numsB.peek()) / 2.0 : numsA.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

