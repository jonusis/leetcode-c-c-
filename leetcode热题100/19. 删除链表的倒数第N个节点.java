/**
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 0;
        while(p != null){
            p = p.next;
            len++;
        }
        int x = len - n;
        if(x == 0){
            p = head.next;
            head.next = null;
            return p;
        }
        p = head;
        ListNode pre = p;
        while(x != 0){
            x--;
            p = p.next;
            if(x != 0){
                pre = pre.next;
            }else{
                pre.next = p.next;
                p.next = null;
            }
        }
        return head;
    }
}