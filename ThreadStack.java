import java.util.Stack;

class ThreadSafeStack<T> {
    private Stack<T> stack = new Stack<>();

    public synchronized void push(T item) {
        stack.push(item);
    }

    public synchronized T pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public synchronized boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class ThreadStack {
    public static void main(String[] args) {
        ThreadSafeStack<Integer> stack = new ThreadSafeStack<>();

        Thread pushThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                stack.push(i);
                System.out.println("Pushed: " + i);
            }
        });

        Thread popThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                Integer item = stack.pop();
                if (item != null) {
                    System.out.println("Popped: " + item);
                } else {
                    System.out.println("Stack is empty. Cannot pop.");
                }
            }
        });

        pushThread.start();
        popThread.start();
    }
}
