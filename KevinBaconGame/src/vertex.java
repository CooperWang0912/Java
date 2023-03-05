import java.util.ArrayList;

public class vertex {

    boolean visited = false;

    vertex previous;

    String actor;

    ArrayList<edge> edges = new ArrayList<edge>();

    public vertex(String actor){
        this.actor = actor;
    }

    public void addEdge(edge n){
        edges.add(n);
    }

    public ArrayList<edge> getEdges(){
        return edges;
    }

    public void setVisited() {
        visited = true;
    }

    public void unVisit(){
        visited = false;
    }

    public boolean getVisited(){
        return visited;
    }

    public void setPrevious(vertex n) {
        previous = n;
    }

    public vertex getPrevious(){
        return previous;
    }

    public boolean hasPrevious(){
        return (previous != null);
    }

    @Override
    public String toString() {
        return actor;
    }
}
