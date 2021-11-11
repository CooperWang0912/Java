package com.example.FallingBlocksFiller;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {

    private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;

    // instance variables (what kind of data structure should we use?)
    public int xPos[];
    public int yPos[];

    public int square = 20;

    public int speed = 5;

    public Color squarecolor[] = new Color[NUMBLOCKS];

    // your code here

    // fills in your arrays with random x and y values
    public void initializeArrays() {
        xPos = new int[NUMBLOCKS];
        yPos = new int[NUMBLOCKS];
        for (int i = 0; i <= NUMBLOCKS-1; i++){
            xPos[i] = (int)(Math.random() * WIDTH);
        }
        for (int i = 0; i <= NUMBLOCKS-1; i++){
            yPos[i] = (int)(Math.random() * HEIGHT);
        }
        for(int i = 0; i <= NUMBLOCKS-1; i++){
            squarecolor[i] = new Color((int)(Math.random() * 256),(int)(Math.random() * 256), (int)(Math.random() * 256));
        }
    }

    // change your arrays here to make the blocks move
    public void moveblocks() {
        for (int i = 0; i <= NUMBLOCKS-1; i++){
            yPos[i] += speed;
            if (yPos[i] > HEIGHT){
                xPos[i] = (int)(Math.random() * WIDTH);
                yPos[i] = 0;
            }
        }
    }

    // change the last part of this method!
    public void paint(Graphics g) {
        // give a white background
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // color the rectangles blue - you can change this
        //g.setColor(Color.blue);

        // draw your rectangles here!
        for (int i = 0; i <= NUMBLOCKS-1; i++){
            g.setColor(squarecolor[i]);
            g.fillRect(xPos[i], yPos[i], square, square);
        }

    }

    // ******** DON'T TOUCH BELOW CODE ***************

    // don't touch this method!
    public FallingBlocksFiller() {
        initializeArrays();
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);

        while (true) {
            moveblocks();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WIDTH = frame.getSize().width;
            HEIGHT = frame.getSize().height;
        }
    }

    // don't touch this method!
    public static void main(String[] args) {
        new FallingBlocksFiller();
    }

}