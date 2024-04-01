public class Stack_Array {

    private int top;
    private Object[] arr;

    public Stack_Array(int capacity){
        top = -1;
        arr = new Object[capacity];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public boolean isFull(){
        return arr.length == size();
    }

    public void push(Object data){
        if(isFull()){
            throw new RuntimeException("stack is full !!!");
        }
        top++;
        arr[top] = data;
    }

    public Object pop() {
        if (isEmpty()){
            throw new RuntimeException("Stack is empty !!!");
        }
        Object result = arr[top];
        top--;
        return result;
    }

    public Object peek(){
        if (isEmpty()){
            throw new RuntimeException("Stack is empty !!!");
        }
        return arr[top];
    }

    public static void main(String[] args) {
        Stack_Array stack = new Stack_Array(3);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
    }

}


