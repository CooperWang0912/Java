import java.awt.*;

public class ColorBall extends BouncingBall{

    private Color temp;

    private int time = 0;

    public ColorBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor ){
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
    }

    public void move(){
        super.move();
        time++;
        if (time == 20){
            temp = new Color((getColor().getRed()+(int)(Math.random()*256))%256, (getColor().getGreen()+(int)(Math.random()*256))%256, (getColor().getBlue()+(int)(Math.random()*256))%256);
            setColor(temp);
            time = 0;
        }
    }
}
