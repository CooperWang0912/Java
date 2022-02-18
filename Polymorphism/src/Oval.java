import java.awt.*;

public class Oval extends Shape{

    private int width;

    private int height;

    public Oval(int startx, int starty, int width, int height){
        super(startx, starty);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(getX(), getY(), width, height);
    }
}
