/**
148. 排序链表
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
进阶：
你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 
示例 1：
输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：
输入：head = []
输出：[]
 

提示：
链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105
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
    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }
    ListNode sort(ListNode head,ListNode tail){
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sort(head, mid);
        ListNode list2 = sort(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }
    ListNode merge(ListNode listx,ListNode listy){
        ListNode Headx = new ListNode(0);
        ListNode tempHead = Headx;
        ListNode list1 = listx,list2 = listy;
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                tempHead.next = list2;
                list2 = list2.next;
            }else{
                tempHead.next = list1;
                list1 = list1.next;
            }
            tempHead = tempHead.next;
        }
        if(list1 != null){
            tempHead.next = list1;
        }else if(list2 != null){
            tempHead.next = list2;
        }
        return Headx.next;
    }
}