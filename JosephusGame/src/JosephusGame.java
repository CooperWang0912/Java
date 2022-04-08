public class JosephusGame {
    public class Node {
        int info;
        Node next;

        public Node(int i, Node n) {
            info = i;
            next = n;
        }
    }

    private Node head = null;

    public void add(int info){

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

    public int getSize(){
        Node curr = head;
        int size = 0;
        while (curr != null){
            curr = curr.next;
            size++;
        }
        return size;
    }

    public void remove(int i){
        try {
            int storedInfo;
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
        }
        catch(NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int output(){
        int output = 0;
        Node curr = head;
        while (curr != null){
            output = curr.info;
            curr = curr.next;
        }
        return output;
    }

    public int game(int n, int m){
        JosephusGame a = new JosephusGame();
        for (int i = 1; i <= n; i++){
            a.add(i);
        }
        int j = 0;
        while(a.getSize() > 1){
            if (j + m > a.getSize() - 1){
                a.remove((j + m) % a.getSize());
                j = 0;
            }
            else{
                a.remove(j + m);
                j++;
            }
        }
        return a.output();
    }

    public static void main(String[]args){
        JosephusGame runner = new JosephusGame();
        System.out.println(runner.game(5, 1));
    }
}
