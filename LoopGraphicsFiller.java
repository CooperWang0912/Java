package com.example.LoopGraphicsFiller;
// filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class LoopGraphicsFiller extends JPanel {

    static Scanner scanner = new Scanner(System.in);
    public int a = scanner.nextInt();
    public int red;
    public int green;
    public int blue;

    // constants that are predefined and won't change as the program runs
    private final int WIDTH = 1000, HEIGHT = 590;

    public void circles(Graphics g){
        for(int i = 0; i < a; i++){
            g.setColor(Color.GREEN);
            g.fillOval(i*(1000/a), 1000/a,1000/a, 1000/a );
        }
    }

    public void increasingCircle(Graphics g) {
        g.setColor(Color.BLUE);
        int a = 1;
        for (int i = 0; i < 30; i++){
            if (i <= 15) {
                a++;
            }
            if (i > 15){
                a--;
            }
            g.fillOval(i * 30, 200, a, a);
        }
    }

    public void tenCircles(Graphics g){
        g.setColor(Color.red);
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                g.fillOval(400 + 20 * i, 300 + 20 * j, 10, 10);
            }
        }
    }

    public void rectangleColor(Graphics g){
        for (int i = 0; i < 10; i++){
            red = (int)(Math.random() * 256);
            green = (int)(Math.random() * 256);
            blue = (int)(Math.random() * 256);
            Color color = new Color(red, green, blue);
            g.setColor(color);
            g.fillRect(0 + 20 * i, 170, 15, 10);
        }
    }

    public void repeat(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            g.fillOval(i * 100, 130, 20, 20);
            g.fillPolygon(new int[]{i * 100 + 30, i * 100 + 40, i * 100 + 50}, new int[]{130, 150, 130}, 3);
            g.fillRect(i * 100 + 60, 130, 20, 20);
        }
    }

    // defines what we want to happen anytime we draw the graphics
    public void paint(Graphics g) {

        // background color is gray
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // call your methods here
        circles(g);
        increasingCircle(g);
        tenCircles(g);
        rectangleColor(g);
        repeat(g);
    }


    //////////////////////////////////////
    //////////////////////////////////////

    // DON'T TOUCH THE BELOW CODE


    // this method runs the actual program.
    public void run() {

        // while(true) should rarely be used to avoid infinite loops, but here it is ok because
        // closing the graphics window will end the program
        while (true) {

            // draws
            //repaint();

            //rests for a hundredth of a second
            try {
                Thread.sleep(10);
            } catch (Exception ex) {}
        }
    }

    // very simple main method to get the game going
    public static void main(String[] args) {
        new LoopGraphicsFiller();
    }

    // does complicated stuff to initialize the graphics and key listeners
    // DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
    // GRAPHICS!
    public LoopGraphicsFiller() {
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        this.setFocusable(true);

        run();
    }
}