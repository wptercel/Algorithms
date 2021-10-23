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
 
 /**
    思路：对半分ListNode数组，进行分治处理
    空间复杂度：O(1)
    时间复杂度：假设lists长度为n，list的平均长度为k。进行n/2 + n/4 + n/8 + ... = n次merge操作。O(nk)。
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int from, int to) {
        if(from == to) {
            return lists[from];
        }

        int mid = from + (to - from) / 2;
        ListNode merged1 = mergeKLists(lists, from, mid);
        ListNode merged2 = mergeKLists(lists, mid + 1, to);
        ListNode preHead = new ListNode();
        ListNode p = preHead;
        while(merged1 != null && merged2 != null) {
            if(merged1.val < merged2.val) {
                p.next = merged1;
                merged1 = merged1.next;
            } else {
                p.next = merged2;
                merged2 = merged2.next;
            }
            p = p.next;
        }
        if(merged1 != null) {
            p.next = merged1;
        }
        if(merged2 != null) {
            p.next = merged2;
        }
        return preHead.next;
    }
}
