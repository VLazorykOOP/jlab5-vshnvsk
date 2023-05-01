import java.util.Stack;

public class RecordStack {
    private Stack<Integer> recordStack;

    public RecordStack(){
        recordStack = new Stack<Integer>();
    }

    public void push(int recordNumber){
        recordStack.push(recordNumber);
    }

    public int pop(){
        return recordStack.pop();
    }

    public int peek(){
        return recordStack.peek();
    }

    public int get(int index){
        return recordStack.get(index);
    }

    public boolean isEmpty(){
        return recordStack.isEmpty();
    }

    public int size(){
        return recordStack.size();
    }

    public static void main(String[] args) {
        RecordStack recordStack = new RecordStack();

        recordStack.push(1);
        recordStack.push(2);
        recordStack.push(3);
        recordStack.push(4);
        recordStack.push(5);

        int recordNumber = recordStack.get(1);
        System.out.println("Element with index 1: " + recordNumber);

        int poppedRecordNumber = recordStack.pop();
        System.out.println("Popped element: " + poppedRecordNumber);

        int peekedRecordStack = recordStack.peek();
        System.out.println("Peeked stack: " + peekedRecordStack);

        boolean isEmpty = recordStack.isEmpty();
        System.out.println("Is the stack empty? " + isEmpty);

        int size = recordStack.size();
        System.out.println("Stack size: " + size);
    }
}