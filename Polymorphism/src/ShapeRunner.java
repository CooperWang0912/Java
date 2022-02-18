import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class ShapeRunner {

    private Shape[] shapes = new Shape[3];

    // this method should move all the shapes in the list
    public void moveShapes() {
        shapes[0].move(20,20);
        shapes[1].move(20,20);
        shapes[2].move(20,20);
    }

    // fill in your shape list here
    public void setup() {
        shapes[0] = new Rect(30, 30, 10, 50);
        shapes[1] = new Oval(60, 60, 20, 40);
        shapes[2] = new Circle(90, 90, 30);
    }

    // DON'T TOUCH BELOW CODE

    public void run() {
        while (true ) {
            moveShapes();
            frame.repaint();
            try {
                Thread.sleep(75);
            } catch (Exception ex) {}
        }
    }

    public static void main(String[] args) {
        new ShapeRunner();
    }
    private JFrame frame;
    public ShapeRunner() {
        setup();
        frame = new JFrame() {
            public void paint(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 600, 600);

                for (Shape s: shapes)
                    s.draw(g);
            }
        };
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        run();
    }
}