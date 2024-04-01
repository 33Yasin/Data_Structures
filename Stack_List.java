import java.util.EmptyStackException;
public class Stack_List {

    private ListNode top;
    private int length;

    public Stack_List(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(Object data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public Object pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Object result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public Object peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    //ListNode class
    private class ListNode{
        private Object data;
        private ListNode next;

        public ListNode(Object data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Stack_List stack = new Stack_List();
        stack.push(10);
        stack.push("abc");
        stack.push(33);
        stack.push('f');

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("length of stack: " + stack.length());
    }


}
