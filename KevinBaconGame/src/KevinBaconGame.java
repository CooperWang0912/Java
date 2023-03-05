import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class KevinBaconGame {

    public static void main(String[]args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
//
//        BufferedReader actors = new BufferedReader(new FileReader("actors.txt"));
//        BufferedReader movies = new BufferedReader(new FileReader("movies.txt"));
//        BufferedReader connect = new BufferedReader(new FileReader("movie-actors.txt"));
//        HashMap<String, String> actorCode = new HashMap<String, String>();
//        HashMap<String, String> movieCode = new HashMap<String, String>();
//        HashMap<String, vertex> nameToActor = new HashMap<String, vertex>();
//        ArrayList<String> movieList = new ArrayList<String>();
//        ArrayList<String> connections = new ArrayList<String>();
//
//        ArrayList<vertex> actorNames = new ArrayList<vertex>();
//        ArrayList<edge> edges = new ArrayList<edge>();

//        int num = 0;
//
//        for (String line = actors.readLine(); line != null; line = actors.readLine()){
//            actorNames.add(new vertex(line.split("~")[1]));
//            actorCode.put(line.split("~")[0], line.split("~")[1]);
//            nameToActor.put(line.split("~")[1], new vertex(line.split("~")[1]));
//            num++;
//        }
//
//        for (String line = movies.readLine(); line != null; line = movies.readLine()){
//            movieList.add(line.split("~")[1]);
//            movieCode.put(line.split("~")[0], line.split("~")[1]);
//        }
//
//        for (String line = connect.readLine(); line != null; line = connect.readLine()){
//            connections.add(line);
//        }
//
//        String curr = movieCode.get(connections.get(0).split("~")[0]);
//        num = 0;
//
//        for (int i = 0; i <= connections.size() - 1; i++){
//            if (!curr.equals(movieCode.get(connections.get(i).split("~")[0]))){
//                for (int j = num; j <= i - 1; j++){
//                    for (int k = j + 1; k <= i - 1; k++){
//                        edges.add(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
//                        nameToActor.get(actorCode.get(connections.get(j).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
//                        nameToActor.get(actorCode.get(connections.get(k).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(k).split("~")[1]), actorCode.get(connections.get(j).split("~")[1]), curr));
//                    }
//                }
//                num = i;
//                curr = movieCode.get(connections.get(i).split("~")[0]);
//            }
//            else if (i == connections.size() - 1){
//                for (int j = num; j <= i; j++){
//                    for (int k = j + 1; k <= i; k++){
//                        edges.add(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
//                        nameToActor.get(actorCode.get(connections.get(j).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(j).split("~")[1]), actorCode.get(connections.get(k).split("~")[1]), curr));
//                        nameToActor.get(actorCode.get(connections.get(k).split("~")[1])).addEdge(new edge(actorCode.get(connections.get(k).split("~")[1]), actorCode.get(connections.get(j).split("~")[1]), curr));
//                    }
//                }
//            }
//        }

//        String start = scanner.nextLine();
//        String end = scanner.nextLine();
//
//        vertex prev = nameToActor.get(start);
//
//        Queue<vertex> queue = new LinkedList<vertex>();
//
//        for(int i = 0; i <= nameToActor.get(start).getEdges().size() - 1; i++){
//            queue.add(nameToActor.get(nameToActor.get(start).getEdges().get(i).actor2));
//            nameToActor.get(nameToActor.get(start).getEdges().get(i).actor2).setPrevious(prev);
//            nameToActor.get(start).setVisited();
//        }
//
//        boolean found = false;
//
//        while(!queue.isEmpty()){
//            queue.peek().setVisited();
//            vertex currVertex = queue.poll();
//            prev = currVertex;
//            if (currVertex.actor.equals(end)){
//                found = true;
//                break;
//            }
//            for (int i = 0; i <= nameToActor.get(currVertex.actor).getEdges().size() - 1; i++){
//                if (!nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2).visited && !nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2).hasPrevious()){
//                    nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2).setPrevious(prev);
//                    queue.add(nameToActor.get(nameToActor.get(currVertex.actor).getEdges().get(i).actor2));
//                }
//            }
//        }
//
//        if (found) {
//
//            Stack<vertex> backtrace = new Stack<vertex>();
//
//            Stack<vertex> test = new Stack<vertex>();
//
//            vertex endNode = nameToActor.get(end);
//
//            backtrace.add(endNode);
//
//            test.add(endNode);
//
//            while (!endNode.actor.equals(start)) {
//                endNode = nameToActor.get(endNode.getPrevious().actor);
//                backtrace.add(endNode);
//                test.add(endNode);
//            }
//
//            System.out.println(backtrace);
//
//            while (backtrace.size() != 1){
//                System.out.print(backtrace.pop() + " -> ");
////                System.out.println(test.pop().getEdges());
//            }
//
//            System.out.println(end);
//
//            String lead = start;
//            String finish = test.pop().actor;
//
//            while(test.size() > 0){
//                for (int i = 0; i <= nameToActor.get(lead).getEdges().size() - 1; i++){
//                    if (nameToActor.get(lead).getEdges().get(i).actor2.equals(finish)){
//                        System.out.println(nameToActor.get(lead).getEdges().get(i).movie);
//                    }
//                }
//                lead = finish;
//                finish = test.pop().actor;
//            }
//
//            for (int i = 0; i <= nameToActor.get(lead).getEdges().size() - 1; i++){
//                if (nameToActor.get(lead).getEdges().get(i).actor2.equals(end)){
//                    System.out.println(nameToActor.get(lead).getEdges().get(i).movie);
//                }
//            }
//        }
//
//        else{
//            System.out.println("There is no connection");
//        }

        Frame frame = new Frame();

    }

}
