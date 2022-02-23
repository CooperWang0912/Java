package pokemon;

import java.util.ArrayList;

public class TeamCooper extends PokeTeam{

    public TeamCooper(){
        super("TeamCooper");
    }

    @Override
    public ArrayList<Pokemon> createTeam(){
        ArrayList<Pokemon> team = new ArrayList<Pokemon>();
        team.add(new Dialga());
        team.add(new Mewtwo());
        team.add(new Nuke());
        return team;
    }
}
