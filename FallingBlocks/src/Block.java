import java.awt.*;

public class Block {

    private int x;
    private int y;
    private Color color;
    private int speed;

    public Block(int x, int y, Color color, int speed){
        this.x = x;
        this.y = y;
        this.color = color;
        this.speed = speed;
    }

    public void draw(Graphics g){
        g.fillRect(x, y, 20, 20);
    }

    public void move(){
        y += speed;
    }

    public int getY(){
        return y;
    }

    public Color getColor(){
        return color;
    }

}
