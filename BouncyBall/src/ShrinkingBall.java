import java.awt.*;

public class ShrinkingBall extends BouncingBall{

    private int time;

    private int val = -1;

    private int ori;

    public ShrinkingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor ){
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
        ori = startrad;
    }

    public void move(){
        super.move();
        time++;
        if (time == 10){
            setRad(getRad()-val);
            time = 0;
        }
        if (getRad() < 5){
            val = -1;
        }
        if (getRad() > ori){
            val = 1;
        }
    }

}
