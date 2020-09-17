/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1,num2,num3;
        num1 = num2 = 0;
        int x = 1;
        while(l1 != null){
            num1 += l1.val * x;
            x *= 10;
            l1 = l1.next;
        }
        x = 1;
        while(l2 != null){
            num2 += l2.val * x;
            x *= 10;
            l2 = l2.next;
        }
        num3 = num1 + num2;
        ListNode l4 = new ListNode(0);
        ListNode lk = l4;
        if(num3 == 0) return lk;
        while(num3 != 0){
            l4.next = new ListNode(num3 % 10);
            l4 = l4.next;
            num3 /= 10;
        }
        return lk.next;
    }
}

// 代码没过，由于int型数据溢出