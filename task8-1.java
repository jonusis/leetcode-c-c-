/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        int s1 , s2;

        while(l1 != null && l2 != null){
            s1 = l1.val;
            s2 = l2.val;
            if(s1 > s2){
                res.next = new ListNode(s2);
                l2 = l2.next;
                res = res.next;
            } 
            if(s1 <= s2){
                res.next = new ListNode(s1);
                l1 = l1.next;
                res = res.next;
            } 
        }
        if(l1 == null && l2 != null){
            res.next = l2;
        }
        if(l2 == null && l1 != null){
            res.next = l1;
        }
        return p.next;
    }
}