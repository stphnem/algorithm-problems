import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyQueue {

    Stack<Integer> s1 =  new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int front;

    // Push element x to the back of queue.
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        if (s2.isEmpty())
            return front;
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}