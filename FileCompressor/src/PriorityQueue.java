import java.util.ArrayList;
import java.util.HashMap;

public class PriorityQueue<T> {

    HashMap<T, Bundle> base = new HashMap<T, Bundle>();

    private class Bundle {
        T element;
        int priority;

        public Bundle(T e, int p) {
            element = e;
            priority = p;
        }

        public String toString() {
            return element + ": " + priority;
        }
    }

    ArrayList<Bundle> queue = new ArrayList<Bundle>();

    public int size() {
        return queue.size();
    }

    public void put(T info, int p){
        Bundle n = new Bundle(info, p);
        for (int i = 0; i <= queue.size() - 1; i++){
            if (queue.get(i).element == info){
                queue.remove(i);
            }
            if (queue.get(i).priority < p){
                queue.add(i, new Bundle(info, p));
                base.put(info, n);
                return;
            }
        }
        queue.add(new Bundle(info, p));
    }

//    public void put(T info, int p) {
//        Bundle n = new Bundle(info, p);
//        if (base.get(info) != null) {
//            queue.remove(base.get(info));
//        }
//        if (queue.size() == 0) {
//            queue.add(n);
//            base.put(info, n);
//            return;
//        }
//        if (queue.get(0).priority < p) {
//            queue.add(0, n);
//            base.put(info, n);
//            return;
//        }
//        if (queue.get(queue.size() - 1).priority > p) {
//            queue.add(queue.size(), n);
//            base.put(info, n);
//            return;
//        }
//        else {
//            int start = 0;
//            int end = queue.size() - 1;
//            int mid = 0;
//            while (start < end) {
//                mid = (start + end) / 2;
//                if (queue.get(mid).priority > p) {
//                    start = mid + 1;
//                }
//                System.out.println("hi");
//                if (queue.get(mid).priority < p) {
//                    end = mid - 1;
//                }
//            }
//            if (queue.get(mid).priority > p) {
//                queue.add(mid + 1, n);
//                base.put(info, n);
//                return;
//            }
//            if (queue.get(mid).priority < p) {
//                queue.add(mid, n);
//                base.put(info, n);
//                return;
//            }
//        }
//        queue.add(n);
//        base.put(info, n);
//    }

    public Bundle pop(){
        Bundle removed = queue.get(queue.size() - 1);
        queue.remove(queue.size() - 1);
        return removed;
    }

    public T get(int i){
        return queue.get(i).element;
    }

    public int getNum(int i){
        return queue.get(i).priority;
    }

    public String toString(){
        String ans = "";
        for (int i = 0; i <= queue.size() - 1; i++){
            ans += queue.get(i) + " ";
        }
        return ans;
    }

    public void createTree(PriorityQueue<Branch> n){
        for (int i = 0; i <= queue.size() - 1; i++){
            n.put(new Branch((char)get(i)), getNum(i));
        }
    }

    public void build(PriorityQueue<Branch> n){
        while (n.size() > 1) {
            PriorityQueue<Branch>.Bundle n1 = n.pop();
            PriorityQueue<Branch>.Bundle n2 = n.pop();
            n.put(new Branch(n1.element, n2.element), n1.priority + n2.priority);
            System.out.println(n);
        }
    }
}