public class LinkedList<E> {

    public class Node {
        E info;
        Node next;

        public Node(E i, Node n) {
            info = i;
            next = n;
        }
    }
    private Node head = null;

    public void add(E info){

        Node newNode = new Node(info, null);

        if (head == null){
            head = newNode;
        }
        else{
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void addIndex(E info, int i){

        Node curr = head;
        Node newNode = new Node(info, curr);
        if (i == 0){
            head = newNode;
        }
        else{
            for(int j = 0; j < i - 1; j++){
                curr = curr.next;
            }
            newNode = new Node(info, curr.next);
            curr.next = newNode;
        }
    }


    public int getSize(){
        Node curr = head;
        int size = 0;
        while (curr != null){
            curr = curr.next;
            size++;
        }
        return size;
    }

    public E get(int i){
        try {
            Node curr = head;
            for (int j = 0; j <= i - 1; j++) {
                curr = curr.next;
            }
            return curr.info;
        }
        catch(NullPointerException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public E remove(int i){
        try {
            E storedInfo;
            if (i == 0){
                storedInfo = head.info;
                head = head.next;
            }
            else{
                Node curr = head;
                for (int j = 1; j <= i - 1; j++) {
                    curr = curr.next;
                }
                storedInfo = curr.next.info;
                curr.next = curr.next.next;
            }
            return storedInfo;
        }
        catch(NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString(){
        String output = "";
        Node curr = head;
        while (curr != null){
            output += curr.info.toString() + " -> ";
            curr = curr.next;
        }
        return output;
    }
}
