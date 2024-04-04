public class SingleLinkedList {

    Node head;

    public void add(Object data){
        if(head == null){
            Node newNode = new Node(data);
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.getLink() != null){
                temp = temp.getLink();
            }
            Node newNode = new Node(data);
            temp.setLink(newNode);
        }
    }

    public int size(){
        if(head == null){
            return 0;
        }
        else{
            int count = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.getLink();
                count++;
            }
            return count;
        }
    }

    public void display(){
        if(head == null){
            System.out.println("List is empty !!!");
        }
        else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.getData() + " ");
                temp = temp.getLink();
            }
        }
        System.out.println();
    }

    public void remove(Object dataToDelete){
        if(head == null){
            System.out.println("Linklist is empty !!!");
        }
        else{
            while((Integer)head.getData() == (Integer)dataToDelete)
                head = head.getLink();

            Node temp = head;
            Node previous = null;
            while(temp != null){
                if((Integer)temp.getData() == (Integer)dataToDelete){
                    previous.setLink(temp.getLink());
                    temp = previous;
                }
                previous = temp;
                temp = temp.getLink();
            }
        }
    }

    public int findMax(){
        if(head == null){
            System.err.println("The Linked List is empty !!!");
            return Integer.MIN_VALUE;
        }
        else{
            int maxval = Integer.MIN_VALUE;
            Node temp = head;

            while (temp != null){
                if((int)temp.getData() > maxval){
                    maxval = (int)temp.getData();
                }
                temp = temp.getLink();
            }
            return maxval;
        }
    }


    public boolean search(Object data){
        if(head == null){
            System.out.println("List is empty");
            return false;
        }
        else{
            Node temp = head;
            while(temp != null){
                if((Integer)temp.getData() == (Integer)data)
                    return true;
                temp = temp.getLink();
            }
            return false;
        }
    }


    class Node{
        Object data;
        Node link;

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
        SingleLinkedList sll = new SingleLinkedList();
        sll.add(5);
        sll.add(13);
        sll.add(8);
        sll.add(76);

        sll.display();
        System.out.println(sll.findMax());
        System.out.println(sll.search(8));
        System.out.println(sll.size());
        sll.remove(13);
        sll.display();
    }
}
