import java.awt.*;

public class Rect extends Shape{

    private int width;

    private int height;

    public Rect(int startx, int starty, int width, int height){
        super(startx, starty);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(getX(), getY(), width, height);
    }
}
