import java.util.Stack;

public class ReverseLLUsingStack {

    Node top;

    public void push( int new_data)
    {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = (top);
        (top) = new_node;
    }

    public Node Reverse(Node top) {
        Node n = top;
        Stack<Node> S = new Stack<Node>();
        if (top == null) {
            return null;

        } else {
            while (n.next != null) {
                S.push(n);
                n = n.next;
            }
        }

        top = n;

        while (!S.empty()) {
            n.next = S.peek();
            n = n.next;
            S.pop();

        }
        n.next = null;
        return top;
    }

    public void print(Node top) {
       while(top!=null) {
           System.out.print(top.data+ " " );
        top=top.next;
        }
    }
}
