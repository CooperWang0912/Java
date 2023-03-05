public class edge {

    String actor1;
    String actor2;
    String movie;

    public edge(String actor1, String actor2, String movie){
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.movie = movie;
    }

    public String getActor1() {
        return actor1;
    }

    public String getActor2(){
        return actor2;
    }

    public String getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return actor1 + " " + actor2 + " " + movie;
    }
}
