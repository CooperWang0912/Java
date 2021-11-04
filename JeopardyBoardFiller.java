package com.example.Jeopardy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JeopardyBoardFiller {

    private int gridWidth = 800, gridHeight = 600, textHeight = 50; //Height and Width of the window

    private final int NUMQUESTIONS = 5, NUMCATEGORIES = 6; //Number of questions and number of categories

    private int score = 0; //The score that would be displayed

    private int scoreDisplay = 100; //The constant used to find out the score added

    public int xOfstring = -1; //The x-value of the string that would change color
    public int yOfstring = -1; //The y-value of the string that would change color
    // instance variables...?

    public void draw(Graphics g) {
        g.setColor(Color.black); //Set the color to be black
        for (int i = 1; i <= NUMQUESTIONS; i++) {
            g.drawLine(0, gridHeight / NUMQUESTIONS * i, gridWidth, gridHeight / NUMQUESTIONS * i); //Drawing the horizontal lines
        }
        for (int j = 1; j <= NUMCATEGORIES; j++){
            g.drawLine(gridWidth / NUMCATEGORIES * j, 0, gridWidth / NUMCATEGORIES * j, gridHeight); //Drawing the vertical lines
        }
        for (int i = 0; i < NUMQUESTIONS; i++) {
            for (int j = 0; j < NUMCATEGORIES; j++) {
                if (j == xOfstring && i == yOfstring){ //If the number is the number clicked
                    g.setColor(Color.red); //Changing the color of the number clicked
                    g.drawString(scoreDisplay * (i + 1) + "", gridWidth / NUMCATEGORIES / 2 + j * gridWidth / NUMCATEGORIES, gridHeight / NUMQUESTIONS / 2 + i * gridHeight / NUMQUESTIONS); //Reprinting the number clicked by using the x and y value of the number clicked
                }
                else { //If the number is not clicked
                    g.setColor(Color.black); //Setting the normal color of the number
                    g.drawString(scoreDisplay * (i + 1) + "", gridWidth / NUMCATEGORIES / 2 + j * gridWidth / NUMCATEGORIES, gridHeight / NUMQUESTIONS / 2 + i * gridHeight / NUMQUESTIONS); //Printing out all the numbers
                }
            }
        }
    }

    public void click(int mouseX, int mouseY) {
        score += (mouseY / (gridHeight / NUMQUESTIONS) + 1) * scoreDisplay; //Adding the number clicked to the score
        for (int i = 0; i <= NUMCATEGORIES; i++){
            if (mouseX >= i  * gridWidth / NUMCATEGORIES && mouseX <= (i + 1) * gridWidth / NUMCATEGORIES){
                xOfstring = i; //Determining the x-value of the number clicked (Which section on the horizontal line is the number on)
            }
        }
        for (int i = 0; i <= NUMQUESTIONS; i++){
            if (mouseY >= i  * gridHeight / NUMQUESTIONS && mouseY <= (i + 1) * gridHeight / NUMQUESTIONS){
                yOfstring = i; //Determining the y-value of the number clicked (Which section on the vertical line is the number on)
            }
        }
    }


    // DO NOT TOUCH BELOW CODE //

    public JeopardyBoardFiller() {

        JFrame window = new JFrame();
        window.setTitle("Jeopardy!");
        window.setSize(gridWidth, gridHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                gridWidth = window.getWidth();
                gridHeight = window.getHeight() - textHeight;
                draw(g);
            }
        };
        canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                scoreDisplay.setText("\t\tScore: " + score);
                window.getContentPane().repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        container.add(canvas);
        container.add(scoreDisplay);
        window.add(container);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new JeopardyBoardFiller();
    }

}

