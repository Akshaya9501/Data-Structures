public class Queue {
    int MAX = 10;
    int[] a = new int[MAX];
    int rear = -1;
    int front = -1;

    public void Enqueue(int data) {
        if (isFull()) {
            return;
        } else if (rear == front) {
            rear = front = 0;
            a[rear] = data;
        } else {
            rear = (rear + 1) % MAX;
            a[rear] = data;
        }
    }

    public boolean isFull() {
        if ((rear + 1) % MAX == front)
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        if (rear == -1 && front == -1)
            return true;
        else
            return false;
    }

    public void Dequeue() {
        if (isEmpty()) {
            return;
        } else if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % MAX;
        }

    }

    public void print() {
        if (isEmpty()) {
            return;
        } else {
            int count = (rear + MAX - front) % MAX + 1;
            for (int i = 0; i < count; i++) {
                int index = (front + i) % MAX; // Index of element while travesing circularly from front
                System.out.println(a[index]);
            }
        }
    }


    public static void main(String args[]) {
        Queue q=new Queue();
        q.Enqueue(4);
        q.print();
        q.Enqueue(6);
        q.print();
        q.Dequeue();
        q.print();
    }
}
