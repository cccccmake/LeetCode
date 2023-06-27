class ListNode{
    int val;
    ListNode next;
    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        this.head = new ListNode();
    }

    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;
        ListNode current = head;
        for(int i = 0; i <= index; i++){
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode current = head.next;
        ListNode previous = head;
        ListNode newNode = new ListNode(val);
        for(int i = 0; i < index; i++){
            previous = current;
            current = current.next;
        }
        newNode.next = current;
        previous.next = newNode;
        //newNode.next = current;
        return;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)
            return;
        size--;
        ListNode current = head.next;
        ListNode previous = head;
        if(index == 0){
            head = head.next;
            return;
        }
        for(int i = 0; i < index; i++){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */