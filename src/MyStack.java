import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Stephen on 10/18/2016.
 * Stack Implemented Using Queues
 */
public class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    int top;

    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.remove();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
