public class Lesson1 {

    Node head;
    Node tail;

    Lesson1(Node headNode) {
        head = headNode;
        tail = headNode;
    }

    public void prependNode(Node node) {
        node.next = head;
        head = node;
    }

    public void appendNode(Node node) {
        tail.next = node;
        tail = node;
    }

    public void traverseAndPrint() {
        Node curr = head;
        while(curr != null){
            System.out.print(curr.value);
            curr = curr.next;
        }
    }

    public void insert(Node node, int n){
        try {
            Node curr = head;
            if (n == 0) {
                node.setNext(head);
                head = node;
            } else {
                for (int i = 0; i < n - 1; i++) {
                    curr = curr.next;
                }
                node.setNext(curr.next);
                curr.next = node;
            }
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int delete (int n){
        try {
            int storedInfo;
            if (n == 0) {
                storedInfo = head.value;
                head = head.next;
                return storedInfo;
            } else {
                Node curr = head;
                for (int i = 1; i <= n - 1; i++) {
                    curr = curr.next;
                }
                storedInfo = curr.next.value;
                curr.next = curr.next.next;
            }
            return storedInfo;
        } catch (NullPointerException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {
        // create a linked list (3 -> 2 -> 1 -> 2)
        Lesson1 ll = new Lesson1(new Node(2));
        ll.prependNode(new Node(1));
        ll.prependNode(new Node(2));
        ll.prependNode(new Node(3));
        ll.insert(new Node(4), 2);
        System.out.println(ll.delete(2));
        // traverse through and print
        ll.traverseAndPrint();
    }
}
