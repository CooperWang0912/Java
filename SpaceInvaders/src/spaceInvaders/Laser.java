package spaceInvaders;

import java.awt.*;

public class Laser extends Rectangle {

    private int w, h;

    public Laser(int x, int y, int w, int h){ //constructor
        super(x, y, w, h); //super constructor from the rectangle class
        this.w = w; //set width
        this.h = h; //set height
    }

    public void moveX(int dX) {
        x += dX;
    } //move x by the value input

    public void moveY(int dY) {
        y += dY;
    } //move y by the value input

    public void draw(Graphics g) {
        g.setColor(Color.RED); //set color to red
        g.fillRect(x, y, w, h); //fill the rectangle
    }
}
