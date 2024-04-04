public class LinkedQueue {

    private Node front = null;
    private Node rear  = null;
    private int numberElements = 0;

    public void enqueue(Object item){
        if(front == null){
            Node newNode = new Node(item);
            rear = newNode;
            front = newNode;
        }
        else{
            Node newNode = new Node(item);
            rear.setLink(newNode);
            rear = newNode;
        }
        numberElements++;
    }

    public Object dequeue () {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        else {
            Object data = front.getData();
            front = front.getLink();
            numberElements--;
            return data;
        }
    }


    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        else
            return front.getData();
    }

    public boolean isEmpty () {
        return front == null;
    }

    public int size () {
        return numberElements;
    }



    public class Node{
        private Object data;
        private Node link;

        public Node(Object dataToAdd){
            data = dataToAdd;
            link = null;
        }

        public Object getData() { return data; }
        public void setData(Object data) { this.data = data;  }

        public Node getLink() { return link;  }
        public void setLink(Node link) { this.link = link;   }
    }


    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();

        lq.enqueue("a");
        lq.enqueue("k");
        lq.enqueue("d");
        lq.enqueue("x");
        lq.enqueue("w");

        System.out.println(lq.peek());
        System.out.println(lq.size());

    }
}
