public class Stack {

    int top = 0;
    static final int MAX = 5;
    int a[] = new int[MAX];

    public void push(int data) {
        if (top == MAX - 1) {
            return;
        }
        a[top] = data;
        top++;
    }

    public int pop() {
        if (top <= 0) {
            return 0;
        }
        top--;
        int data = a[top];
        a[top] = 0;
        System.out.println(data + "Popped");
        return data;
    }

    public int peek() {
        System.out.println(a[top - 1] + "Top");
        return a[top - 1];
    }
public boolean isEmpty(){
    System.out.println(top<0);
        return top <0;
}
    public void print() {
        for (int n : a) {
            System.out.print(n + " ");
        }
    }
}
