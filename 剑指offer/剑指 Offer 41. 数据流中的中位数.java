/**
 * 剑指 Offer 41. 数据流中的中位数
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例 1：

输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]
示例 2：

输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]

 */
class MedianFinder {
    PriorityQueue<Integer> queue1;
    PriorityQueue<Integer> queue2;
    int index;
    /** initialize your data structure here. */
    public MedianFinder() {
        queue1 = new PriorityQueue<>();
        queue2 = new PriorityQueue<>((x,y) -> (y - x));
        index = 0;
    }
    
    public void addNum(int num) {
         if(queue1.size() != queue2.size()) {
            queue1.add(num);
            queue2.add(queue1.poll());
        } else {
            queue2.add(num);
            queue1.add(queue2.poll());
        }
    }
    
    public double findMedian() {
        return queue1.size() != queue2.size() ? queue1.peek() : (queue1.peek() + queue2.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */