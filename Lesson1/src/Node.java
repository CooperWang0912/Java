public class Node {

    public int value;
    public Node next;

    public Node(int nodeValue) {
        value = nodeValue;
        next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}