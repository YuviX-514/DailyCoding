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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null)return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[]lists, int start, int end){
        if(start == end)return lists[start];
        int mid = start + (end- start)/2;

        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid+1, end);

        return mergeList(left, right);
    }

    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
