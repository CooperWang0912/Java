import java.util.ArrayList;
import java.util.HashMap;

public class PriorityQueue<T> {

    HashMap<T, Bundle> base = new HashMap<T, Bundle>();

    private class Bundle{
        T element;
        int priority;
        public Bundle(T e, int p){
            element = e;
            priority = p;
        }

        public String toString(){
            return element + ": " + priority;
        }
    }

    ArrayList<Bundle> queue = new ArrayList<Bundle>();

    public Bundle pop(){
        Bundle removed = queue.get(0);
        queue.remove(0);
        return removed;
    }

    public int size(){
        return queue.size();
    }

//    public void put(T info, int p){
//        for (int i = 0; i <= queue.size() - 1; i++){
//            if (queue.get(i).element == info){
//                queue.remove(i);
//            }
//            if (queue.get(i).priority < p){
//                queue.add(i, new Bundle(info, p));
//                return;
//            }
//        }
//        queue.add(new Bundle(info, p));
//    }

    public void put(T info, int p){
        Bundle n = new Bundle(info, p);
        if (base.get(info) != null){
            queue.remove(base.get(info));
        }
        if (queue.size() == 0){
            queue.add(n);
            base.put(info, n);
            return;
        }
        if (queue.get(0).priority < p){
            queue.add(0, n);
            base.put(info, n);
            return;
        }
        if (queue.get(queue.size() - 1).priority > p){
            queue.add(queue.size(), n);
            base.put(info, n);
            return;
        }
        else{
            int start = 0;
            int end = queue.size()-1;
            int mid = 0;
            while (start < end){
                mid = (start + end) / 2;
                if (queue.get(mid).priority > p){
                    start = mid + 1;
                }
                if (queue.get(mid).priority < p){
                    end = mid - 1;
                }
            }
            if (queue.get(mid).priority > p){
                queue.add(mid + 1, n);
                base.put(info, n);
                return;
            }
            if (queue.get(mid).priority < p){
                queue.add(mid, n);
                base.put(info, n);
                return;
            }
        }
        queue.add(n);
        base.put(info, n);
    }

    public String toString(){
        return queue.toString();
    }

    public static void main(String[]args){
        PriorityQueue runner = new PriorityQueue();
        PriorityQueue a = new PriorityQueue();
        a.put("Condy", 15);
        a.put("Cooper", 30);
        a.put("Joe", 20);
        a.put("Mr. Friedman", 29);
        a.put("Tony", 28);
        a.put("Ryan", 31);
        a.put("Yumna", 4);
        a.put("Cooper", 14);
        System.out.println(a.pop());
        System.out.println(a);
    }

}
