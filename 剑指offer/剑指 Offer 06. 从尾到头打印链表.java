/**
剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        List <Integer> arr = new LinkedList<Integer>();
        while(p != null){
            arr.add(0,p.val);
            p = p.next;
        }
        int[] a = new int[arr.size()];
        for(int i = 0;i < arr.size();i++){
            a[i] = arr.get(i);
        }
        return a;
    }
}