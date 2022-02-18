import java.awt.*;

public class Circle extends Shape{

    private int radius;

    public Circle(int startx, int starty, int radius){
        super(startx, starty);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(getX(), getY(), radius, radius);
    }
}
