import java.util.ArrayList;
import java.util.HashMap;

public class PriorityQueue<T> {

    HashMap<T, Bundle> base = new HashMap<T, Bundle>(); //the map that holds the element and the bundle

    private class Bundle { //constructor of the bundle
        T element;
        int priority;

        public Bundle(T e, int p) {
            element = e;
            priority = p;
        }

        public String toString() {
            return element + ": " + priority;
        } //print method
    }

    ArrayList<Bundle> queue = new ArrayList<Bundle>(); //create an arraylist of bundles

    public int size() {
        return queue.size();
    } //return the size of the arraylist

//    public void put(T info, int p){ //put an element with t as the information and p as the priority
//        Bundle n = new Bundle(info, p); //create a new bundle
//        for (int i = 0; i <= queue.size() - 1; i++){ //goes through the queue
//            if (queue.get(i).element == info){ //if the element is a duplicate
//                queue.remove(i); //remove the duplicate
//            }
//            if (queue.get(i).priority < p){ //if the element has a lower priority
//                queue.add(i, new Bundle(info, p)); //add the new element in front of it
//                base.put(info, n); //add the bundle to the map
//                return; //stop the loop
//            }
//        }
//        queue.add(new Bundle(info, p)); //add the new element to the end in other cases
//        base.put(info, n); //add the bundle to the map
//    }

    public void put(T info, int p) {
        Bundle n = new Bundle(info, p);
        if (base.get(info) != null) {
            queue.remove(base.get(info));
        }
        if (queue.size() == 0) {
            queue.add(n);
            base.put(info, n);
            return;
        }
        if (queue.get(0).priority < p) {
            queue.add(0, n);
            base.put(info, n);
            return;
        }
        if (queue.get(queue.size() - 1).priority > p) {
            queue.add(queue.size(), n);
            base.put(info, n);
            return;
        }
        else {
            int start = 0;
            int end = queue.size() - 1;
            int mid = 0;
            while (start < end && end - start != 1) {
                mid = (start + end) / 2;
                if (queue.get(mid).priority > p) {
                    start = mid + 1;
                }
                if (queue.get(mid).priority < p) {
                    end = mid - 1;
                }
                if (queue.get(mid).priority == p){
                    queue.add(mid, n);
                    base.put(info, n);
                    return;
                }
            }
            if (queue.get(mid).priority > p) {
                queue.add(mid + 1, n);
                base.put(info, n);
                return;
            }
            if (queue.get(mid).priority < p) {
                queue.add(mid, n);
                base.put(info, n);
                return;
            }
        }
        queue.add(n);
        base.put(info, n);
    }

    public Bundle pop(){ //pop function
        Bundle removed = queue.get(queue.size() - 1); //create a new bundle with the element with the lowest priority from the map
        queue.remove(queue.size() - 1); //remove the element from the arraylist
        return removed; //return the bundle
    }

    public T get(int i){
        return queue.get(i).element; //return the information
    }

    public int getNum(int i){
        return queue.get(i).priority; //return the priority
    }

    public String toString(){ //print function
        String ans = ""; //creates an empty string
        for (int i = 0; i <= queue.size() - 1; i++){ //goes through the arraylist
            ans += queue.get(i) + " "; //add the element to the string
        }
        return ans; //return the string
    }

    public void createTree(PriorityQueue<Branch> n){ //creates the tree
        for (int i = 0; i <= queue.size() - 1; i++){ //goes through the arraylist
            n.put(new Branch((char)get(i)), getNum(i)); //create branches and add them to the tree
        }
    }

    public void build(PriorityQueue<Branch> n){ //build the tree
        while (n.size() > 1) { //if there are more than one element remaining on the tree
            PriorityQueue<Branch>.Bundle n1 = n.pop(); //pop the smallest number
            PriorityQueue<Branch>.Bundle n2 = n.pop(); //pop the second-smallest number
            n.put(new Branch(n1.element, n2.element), n1.priority + n2.priority); //put them as a branch with left branch and right branch and combine their priority
        }
    }
}