/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.package stack;
 */
package stack;

public class MinStack {
private StackNode top = null;
    
    // inner class StackNode
    private class StackNode{
        private int value;
        private StackNode next;
        
        private StackNode(int value, StackNode next){
            this.value = value;
            this.next = next;
        }
    }
    
    public void push(int x) {
        StackNode newNode = new StackNode(x, top);
        top = newNode;
    }

    public void pop() {
        if(top != null)
            top = top.next;
    }

    public int top() {
        if(top != null){
            StackNode tempNode = top;
            return tempNode.value;
        }
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        StackNode tempNode = top;
        int tempMin = Integer.MAX_VALUE;
        if(top != null) tempMin = top.value;
        while(tempNode != null){
            tempMin = Math.min(tempMin, tempNode.value);
            tempNode = tempNode.next;
        }
        return tempMin;
    }
}
