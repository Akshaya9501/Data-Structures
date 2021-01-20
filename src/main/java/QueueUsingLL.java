public class QueueUsingLL {
    Node rear;
    Node front;

    public void enqueue(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if (isEmpty()) {
            front = rear = n;
            return;
        }
        rear.next = n;
        rear = n;
    }

    public boolean isEmpty() {
        if (rear == null && front == null) {
            return true;
        } else
            return false;
    }

    public void dequeue() {
        Node n = front;
        if (front == null) {
            return;
        } else if (front == rear) {
            rear = front = null;
        }else{
            front=front.next;
        }
        n=null;
    }

   public void print() {
        Node n = front;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public static void main(String args[]) {
        QueueUsingLL q = new QueueUsingLL();
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(0);
        q.print();
        q.dequeue();
        q.print();
    }
}
