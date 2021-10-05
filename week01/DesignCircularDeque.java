class MyCircularDeque {
    private int[] data;
    private int front;
    private int rear;

    public MyCircularDeque(int k) {
        this.data = new int[k + 1];
        this.front = 0;
        this.rear = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (data.length + front - 1) % data.length;
        data[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        front = (front + 1) % data.length;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        rear = (data.length + rear - 1) % data.length;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return data[front];
    }
    
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return data[(data.length + rear - 1) % data.length];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
