import java.awt.*;

public class CirclePathBall extends BouncingBall{

    private int angle = 0;

    private int oriX = 0;

    private int oriY = 0;

    public CirclePathBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor){
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
        oriX = startx;
        oriY = starty;
    }

    public void move(){
        setX((int)(Math.cos(angle * Math.PI / 180) * 30 * getXSpeed() + oriX));
        setY((int)(Math.sin(angle * Math.PI / 180) * 30 * getYSpeed() + oriY));
        angle++;
        if(getX() > WIDTH || getX() < 0){
            setXSpeed(-getXSpeed());
        }
        if (getY() > HEIGHT || getY() < 0){
            setYSpeed(-getYSpeed());
        }
    }
}
