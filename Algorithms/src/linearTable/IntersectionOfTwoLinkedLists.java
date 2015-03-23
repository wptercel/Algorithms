package linearTable;
/*Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                   ¨K
                     c1 ¡ú c2 ¡ú c3
                   ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int difference = Math.abs(lengthA - lengthB);
        int currentCountLonger = 0;
        ListNode currentLonger = null;
        ListNode currentShorter = null;
        if(lengthA > lengthB){
        	currentLonger = headA;
        	currentShorter = headB;
        }
        else{
        	currentLonger = headB;
        	currentShorter = headA;
        }
        
        while(currentLonger != null && currentShorter != null){
        	if(currentCountLonger <= difference){
        		currentLonger = currentLonger.next;
        		currentCountLonger++;
        	}
        	else{
        		currentLonger = currentLonger.next;
        		currentShorter = currentShorter.next;
        	}
        	if(currentLonger.equals(currentShorter))
        		break;
        }
        return currentLonger;
    }
	
	private int getLength(ListNode head){
		int length = 0;
		ListNode current = head;
		while(current != null){
			current = current.next;
			length++;
		}
		return length;
	}
}
