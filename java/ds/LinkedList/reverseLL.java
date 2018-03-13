/**      https://leetcode.com/problems/reverse-linked-list/description/

Reverse the linked list

**/





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
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode cur = head;
        ListNode nxt = head.next;
        ListNode temp = nxt.next;
        boolean flag = false;
        while(nxt != null){
            nxt.next = cur;
            if(!flag){
                flag = true;
                cur.next = null;
            }
            cur = nxt;
            nxt = temp;
            if(temp != null)
                temp = temp.next;
            
            
        }
        return cur;
        
        
    }
}