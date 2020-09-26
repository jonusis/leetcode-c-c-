/**
* 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
* 很简单 给两个指针 p,q 不断进行 q = q.next 如果p.val != q.val则让p.next = q,p = p.next;
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        if(head == null) return head;
        while(q.next != null){
            q = q.next;
            if(p.val != q.val){
                p.next = q;
                p = p.next;
            }
        }
        p.next = null;
        return head;
    }
}