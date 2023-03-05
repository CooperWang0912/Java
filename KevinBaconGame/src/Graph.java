import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    public HashMap<String, vertex> createGraph() throws IOException {
        BufferedReader actors = new BufferedReader(new FileReader("actors.txt"));
        BufferedReader movies = new BufferedReader(new FileReader("movies.txt"));
        BufferedReader connect = new BufferedReader(new FileReader("movie-actors.txt"));
        HashMap<String, String> actorCode = new HashMap<String, String>();
        HashMap<String, String> movieCode = new HashMap<String, String>();
        HashMap<String, vertex> nameToActor = new HashMap<String, vertex>();
        ArrayList<String> movieList = new ArrayList<String>();
        ArrayList<String> connections = new ArrayList<String>();

        ArrayList<vertex> actorNames = new ArrayList<vertex>();
        ArrayList<edge> edges = new ArrayList<edge>();

        int num = 0;

        for (String line = actors.readLine(); line != null; line = actors.readLine()){
            actorNames.add(new vertex(line.split("~")[1]));
            actorCode.put(line.split("~")[0], line.split("~")[1]);
            nameToActor.put(line.split("~")[1], new vertex(line.split("~")[1]));
            num++;
        }

        for (String line = movies.readLine(); line != null; line = movies.readLine()){
            movieList.add(line.split("~")[1]);
            movieCode.put(line.split("~")[0], line.split("~")[1]);
        }

        for (String line = connect.readLine(); line != null; line = connect.readLine()){
            connections.add(line);
        }

        String curr = movieCode.get(connections.get(0).split("~")[0]);
        num = 0;

        for (int i = 0; i <= connections.size() - 1; i++){
            if (!curr.equals(movieCode.get(connections.get(i).split("~")[0]))){
                for (int j = num; j <= i - 1; j++){
                    for (int k = j + 1; k <= i - 1; k++){
                        edges.add(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
                        nameToActor.get(actorCode.get(connections.get(j).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
                        nameToActor.get(actorCode.get(connections.get(k).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(k).split("~")[1]), actorCode.get(connections.get(j).split("~")[1]), curr));
                    }
                }
                num = i;
                curr = movieCode.get(connections.get(i).split("~")[0]);
            }
            else if (i == connections.size() - 1){
                for (int j = num; j <= i; j++){
                    for (int k = j + 1; k <= i; k++){
                        edges.add(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
                        nameToActor.get(actorCode.get(connections.get(j).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
                        nameToActor.get(actorCode.get(connections.get(k).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(k).split("~")[1]), actorCode.get(connections.get(j).split("~")[1]), curr));
                    }
                }
            }
        }

        return nameToActor;

    }

}
