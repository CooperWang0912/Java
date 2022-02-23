package pokemon;

public class Nuke extends Pokemon{

    public Nuke(){
        super("Nuke", 1, 10,"Nuke.png", new Move[]{new Move("You got nuked", 0, 75, 1), new Move("You got bombed", 0, 35, 0), new Move("You got wrecked", 0, 40, 0), new Move("", 0, 0, 0)});
    }
}
