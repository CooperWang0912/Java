import java.awt.*;

public class BouncingBall extends Ball{

    public BouncingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor){
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
    }

    public void move(){
        setX(getX()+getXSpeed());
        setY(getY()+getYSpeed());
        if(getX() > WIDTH || getX() < 0){
            setXSpeed(-getXSpeed());
        }
        if (getY() > HEIGHT || getY() < 0){
            setYSpeed(-getYSpeed());
        }
    }
}
