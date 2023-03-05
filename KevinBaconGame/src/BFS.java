import java.util.*;

public class BFS {

    public String traverse(HashMap<String, vertex> nameToActor, String start, String end){

        if (nameToActor.get(start) == null || nameToActor.get(end) == null){
            return "There is no such actor, please try again";
        }

        String ans = "";

        vertex prev = nameToActor.get(start);

        Queue<vertex> queue = new LinkedList<vertex>();

        Queue<String> movies = new LinkedList<String>();

        for(int i = 0; i <= nameToActor.get(start).getEdges().size() - 1; i++){
            queue.add(nameToActor.get(nameToActor.get(start).getEdges().get(i).actor2));
            nameToActor.get(nameToActor.get(start).getEdges().get(i).actor2).setPrevious(prev);
            nameToActor.get(start).setVisited();
        }

        boolean found = false;

        while(!queue.isEmpty()){
            queue.peek().setVisited();
            vertex currVertex = queue.poll();
            prev = currVertex;
            if (currVertex.actor.equals(end)){
                found = true;
                break;
            }
            for (int i = 0; i <= nameToActor.get(currVertex.actor).getEdges().size() - 1; i++){
                if (!nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2).visited && !nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2).hasPrevious()){
                    nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2).setPrevious(prev);
                    queue.add(nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2));
                }
            }
        }

        if (found) {

            Stack<vertex> backtrace = new Stack<vertex>();

            Stack<vertex> test = new Stack<vertex>();

            vertex endNode = nameToActor.get(end);

            backtrace.add(endNode);

            test.add(endNode);

            while (!endNode.actor.equals(start)) {
                endNode = nameToActor.get(endNode.getPrevious().actor);
                backtrace.add(endNode);
                test.add(endNode);
            }

//            System.out.println(backtrace);

            String lead = start;
            String finish = test.pop().actor;

            while(test.size() > 0){
                for (int i = 0; i <= nameToActor.get(lead).getEdges().size() - 1; i++){
                    if (nameToActor.get(lead).getEdges().get(i).actor2.equals(finish)){
                        movies.add(nameToActor.get(lead).getEdges().get(i).movie);
                    }
                }
                lead = finish;
                finish = test.pop().actor;
            }

            for (int i = 0; i <= nameToActor.get(lead).getEdges().size() - 1; i++){
                if (nameToActor.get(lead).getEdges().get(i).actor2.equals(end)){
                    movies.add(nameToActor.get(lead).getEdges().get(i).movie);
                }
            }

//            System.out.println(movies);

            while (backtrace.size() != 1){
                ans += backtrace.pop() + " -> ";
                ans += "(" + movies.poll() + ") ->";
            }

            ans += end;

            return ans;

        }

        else{
            return "There is no connection";
        }

    }

    public String getMovie(HashMap<String, vertex> nameToActor, String start, String end){
        if (nameToActor.get(start) == null || nameToActor.get(end) == null){
            return "There is no such actor, please try again";
        }
        int ran = (int)(Math.random() * (nameToActor.get(start).getEdges().size() - 1));
        return nameToActor.get(start).getEdges().get(ran).getMovie();
    }

}
