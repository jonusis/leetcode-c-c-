/**
剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000
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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> s = new Stack<ListNode>();
        if(head == null) return null;
        while(head != null){
            s.push(head);
            head = head.next;
        }
        ListNode x = s.pop();
        ListNode res = x;
        while(!s.isEmpty()){
            x.next = s.pop();
            x = x.next;
        }
        x.next = null;
        return res;
    }
}