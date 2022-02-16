import java.awt.*;

public class SineBall extends BouncingBall{

    private int y;

    public SineBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor ){
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
        this.y = starty;
    }

    public void move(){
        setX(getX()+getXSpeed());
        setY((int)(Math.sin(getX() / 5.0)*30)+ y);
        if(getX() > WIDTH || getX() < 0){
            setXSpeed(-getXSpeed());
        }
        if (getY() > HEIGHT || getY() < 0){
            setYSpeed(-getYSpeed());
        }
    }
}
