public class LinkedStack {
    private Node top = null;
    private int numberElements = 0;

    public void push(Object item){
        Node newNode = new Node(item);
        newNode.setLink(top);
        top = newNode;
        numberElements++;
    }

    public Object pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        else{
            Object data = top.getData();
            top = top.getLink();
            numberElements--;
            return data;
        }
    }

    public Object peek(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        else
            return top.getData();
    }

    public boolean isEmpty () {
        return top == null;
    }

    public int size () {
        return numberElements;
    }

    //Node class
    public class Node{
        private Object data;
        private Node link;

        public Node(Object dataToAdd){
            data = dataToAdd;
            link = null;
        }

        public Object getData(){return data;}
        public void setData(Object data){this.data = data;}
        public Node getLink(){return link;}
        public void setLink(Node link){this.link = link;}
    }

    public static void main(String[] args) {
        LinkedStack ls = new LinkedStack();

        ls.push(5);
        ls.push(7);
        ls.push(21);
        ls.push(2);
        ls.push(4);

        System.out.println(ls.peek());

    }

}
