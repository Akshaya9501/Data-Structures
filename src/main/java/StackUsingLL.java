public class StackUsingLL {
    Node top;

    public void push(int data) {
        Node n = new Node();
        n.data = data;
        if (top == null) {
            top = n;
        } else {
            n.next = top;
            top = n;
        }
    }

        public void pop() {
            if (top == null) {
                return;
            } else {
                Node n1=top;
               top=n1.next;
                n1=null;
            }
        }
public void peek(){
        System.out.println(top.data+ " ");
}
    public void print() {
        Node n = top;
        while (n.next != null) {
            System.out.print(n.data+ " ");
            n = n.next;
        }
        System.out.println(n.data+ " ");
    }
}
