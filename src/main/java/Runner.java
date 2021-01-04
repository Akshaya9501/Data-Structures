public class Runner {
    public static void main(String args[]) {
        //LinkedList implementation
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(5);
        l.insert(89);
        l.insertAtBeginning(2);
        l.insertAt(0, 0);
        l.insertAt(3, 9);
        l.delete(2);
        l.view();
        /*//Doubly linkedlist Implementation
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insert(2);
        dl.print();
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(5);
        s.peek();
        s.pop();
        s.isEmpty();
        s.print();*/
        //Stack using Linkedlist Implementation
        StackUsingLL sll = new StackUsingLL();
        sll.push(2);
        sll.push(5);
        sll.push(3);
        sll.print();
        sll.peek();
        sll.pop();
        sll.pop();
        sll.peek();
        sll.print();
        //Reverse LinkedList using stack
        ReverseLLUsingStack rs = new ReverseLLUsingStack();
        rs.push(1);
        rs.push(4);
        Node head = rs.Reverse(rs.top);
        rs.print(head);
    }
}

