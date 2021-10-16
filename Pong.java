package com.example.Pong;
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

public class Pong extends JPanel implements KeyListener {

    /*
    IMPORTANT: Press C for cheat and D to deactivate cheat
    IMPORTANT: Press 3 for Special Mode and 4 to switch back to normal mode
    */

    // constants that are predefined and won't change as the program runs
    private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
    private final int PADDLE_WIDTH = 20, DIAM = 8, PADDLE_HEIGHT = 100;
    private final int PADDLE_SPEED = 4;


    // your instance variables here, I've given you a few
    private boolean up1, down1, up2, down2; // booleans to keep track of paddle movement
    private boolean solo = false; //Solo mode verifier
    public int speed = 4; //Speed of the ball
    public int p1x = 0; //x-coordinate of paddle 1
    public int p1y = HEIGHT / 2 - 60; //y-coordinate of paddle 1
    public int p1yShift = 0; //change of y-coordinate of paddle 1
    public int p2x = WIDTH - 30; //x-coordinate of paddle 2
    public int p2y = HEIGHT / 2 - 60; //y-coordinate of paddle 2
    public int p2yShift; //change of y-coordinate of paddle 2
    public int ballx = 280; //Starting roughly at the middle
    public int bally = 300; //Starting roughly at the middle
    public int ballXshift = speed; //Initializing speed and direction
    public int ballYshift = 0; //Initializing speed and direction
    public int player1score = 0; //Score of player 1
    public int player2score = 0; //Score of player 2
    public int paddleSpeed1 = 4; //Speed of paddle 1
    public int paddleSpeed2 = 4; //Speed of paddle 2
    public int wallWidth = 20; //Width of the wall
    public int wallHeight = 200; //Height of the wall
    public boolean cheat = false; //Cheat mode verifier
    public boolean special = false; //Special mode verifier

    // this method moves the ball at each timestep
    public void move_ball() {
        ballx += ballXshift;
        bally += ballYshift;
        //Moving the x-coordinate and y-coordinate of the ball according to its speed and direction
    }

    // this method moves the paddles at each timestep
    public void move_paddles() {
        //Moving the y-coordinates of paddle 1 and paddle 2 when it is 2 player mode
        if (solo == false) {
            if (up1 == true){
                p1y -= paddleSpeed1; //Move the y-coordinate of paddle 1 up
            }
            if (down1 == true){
                p1y += paddleSpeed1; //Move the y-coordinate of paddle 1 down
            }
            if (up2 == true){
                p2y -= paddleSpeed2; //Move the y-coordinate of paddle 2 up
            }
            if (down2 == true){
                p2y += paddleSpeed2; //Move the y-coordinate of paddle 2 down
            }
        }
        //Moving the y-coordinates of paddle 1 and paddle 2 when it is solo player mode
        else if (solo == true){
            if (up1 == true){
                p1y -= paddleSpeed1; //Move the y-coordinate of paddle 1 up
            }
            if (down1 == true){
                p1y += paddleSpeed1; //Move the y-coordinate of paddle 1 down
            }
            if (p2y + PADDLE_HEIGHT / 2 < bally){
                p2y += paddleSpeed2; //Move the y-coordinate of paddle 2 when it is higher than the ball
            }
            else if (p2y + PADDLE_HEIGHT / 2 > bally){
                p2y-= paddleSpeed2; //Move the y-coordinate of paddle 2 when it is lower than the ball
            }
            else if (p2y + PADDLE_HEIGHT / 2 == bally){
                p2yShift = 0; //Stay in the y-coordinate of paddle 2 when it is same to the ball
            }
        }
    }

    // this method checks if there are any bounces to take care of,
    // and if the ball has reached a left/right wall it adds to
    // the corresponding player's score
    public void check_collisions() {
        //If the ball hits the left side
        if(ballx <= 0){
            player2score ++; //Player 1 scores a point
            ballx = 280; //Reset location to staring position
            bally = 300; //Reset location to staring position
            speed = speed * -1; //Change the direction of the ball when starting the game
            ballXshift = speed; //Reset speed of the ball for x
            ballYshift = 0; //Make sure that the ball does not move its y-coordinates when starting
            p1y = HEIGHT / 2 - 60; //Starting positions
            p2y = HEIGHT / 2 - 60; //Starting positions
        }
        //If the ball hits the right side
        else if(ballx >= WIDTH){
            player1score ++; //Player 2 scores a point
            ballx = 280; //Reset location to staring position
            bally = 300; //Reset location to staring position
            speed = speed * -1; //Change the direction of the ball when starting the game
            ballXshift = speed; //Reset speed of the ball for x
            ballYshift = 0; //Make sure that the ball does not move its y-coordinates when starting
            p1y = HEIGHT / 2 - 60; //Starting positions
            p2y = HEIGHT / 2 - 60; //Starting positions
        }
        //If the ball hits paddle 1 front
        if(p1y + PADDLE_HEIGHT >= bally && p1y <= bally && ballx <= p1x + PADDLE_WIDTH - 10){
            ballXshift = -ballXshift; //Change the direction of the ball on the x-coordinate
            ballYshift = -ballYshift + 2 * p1yShift + (int)(Math.random() * 5); //Change the direction of the ball on the y-coordinate
        }
        //If the ball hits paddle 2 front
        else if(p2y + PADDLE_HEIGHT >= bally && p2y <= bally && ballx >= p2x - PADDLE_WIDTH + 10){
            ballXshift = -ballXshift; //Change the direction of the ball on the x-coordinate
            ballYshift = -ballYshift + 2 * p2yShift + (int)(Math.random() * 5); //Change the direction of the ball on the y-coordinate
        }
        //If the ball hits the top or the bottom wall
        if (bally <= 0 || bally >= HEIGHT){
            ballYshift = -ballYshift; //Change the direction of the ball on the y-coordinate
        }
        //Restricting paddle 2 inside the frame
        if (p2y <= 0){
            p2y = 0;
        }
        //Restricting paddle 2 inside the frame
        if (p2y >= WIDTH - PADDLE_HEIGHT){
            p2y = WIDTH - PADDLE_HEIGHT;
        }
        //Restricting paddle 1 inside the frame
        if (p1y <= 0){
            p1y = 0;
        }
        //Restricting paddle 1 inside the frame
        if (p1y >= WIDTH - PADDLE_HEIGHT){
            p1y = WIDTH - PADDLE_HEIGHT;
        }
        //If Special mode is on
        if (special == true){
            if (ballx >= WIDTH/2 - wallWidth && ballx <= WIDTH/2 - wallWidth + 20 && bally <= wallHeight){
                ballXshift = -ballXshift; //Changing the x-coordinate shift when the ball hits the upper wall
                ballYshift = -ballYshift + 2 * p2yShift + (int)(Math.random() * 5); //Changing the y-coordinate shift when the ball hits the upper wall
            }
            else if (ballx >= WIDTH/2 - wallWidth && ballx <= WIDTH/2 - wallWidth + 20 && bally >= HEIGHT / 2 + (HEIGHT / 2 - wallHeight)){
                ballXshift = -ballXshift; //Changing the x-coordinate shift when the ball hits the lower wall
                ballYshift = -ballYshift + 2 * p2yShift + (int)(Math.random() * 5); //Changing the y-coordinate shift when the ball hits the lower wall
            }
        }
    }


    // defines what we want to happen anytime we draw the game
    // you simply need to fill in a few parameters here
    public void paint(Graphics g) {

        // background color is gray
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // draw your rectangles and circles here
        // .......
        g.setColor(Color.ORANGE); //Color of the paddles
        g.fillRect(p1x,p1y,PADDLE_WIDTH,PADDLE_HEIGHT); //Draw paddle 1
        g.fillRect(p2x,p2y,PADDLE_WIDTH,PADDLE_HEIGHT); //Draw paddle 2

        g.setColor(Color.red); //Color of the ball
        g.fillOval(ballx,bally,15,15); //Draw the ball

        if (special == true){
            g.setColor(Color.BLUE); //Color of the wall
            g.fillRect(WIDTH/2 - wallWidth,0, wallWidth, wallHeight); //Draw the upper wall
            g.fillRect(WIDTH/2 - wallWidth,HEIGHT / 2 + (HEIGHT / 2 - wallHeight), wallWidth, wallHeight); //Draw the lower wall
        }

        // writes the score of the game - you just need to fill the scores in
        Font f = new Font("Arial", Font.BOLD, 14);
        g.setFont(f);
        g.setColor(Color.red); //Color of the scores
        g.drawString("P1 Score: " + player1score, WIDTH/5, 20); //Draw player 1's score
        if (cheat == false) {
            g.drawString("P2 Score: " + player2score, WIDTH * 3 / 5, 20); //Draw player 2's score
        }
        else if (cheat == true) {
            g.drawString("P2 Score: " + player2score / 3, WIDTH * 3 / 5, 20); //Draw player 2's score
        }
    }

    // defines what we want to happen if a keyboard button has
    // been pressed - you need to complete this
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        // changes paddle direction based on what button is pressed
        //If the down button is pressed
        if (keyCode == KeyEvent.VK_DOWN){
            down2 = true; //Paddle 2 moves down
        }
        //If the up button is pressed
        if (keyCode == KeyEvent.VK_UP){
            up2 = true; //Paddle 2 moves up
        }
        //If the w key is pressed
        if (e.getKeyChar() == 'w'){
            up1 = true; //Paddle 1 moves up
        }
        //If the s key is pressed
        if (e.getKeyChar() =='s'){
            down1 = true; //Paddle 1 moves down
        }
        // turn 1-player mode on
        if (e.getKeyChar() == '1'){
            solo = true; //Solo mode is on
        }
        // turn 2-player mode on
        if (e.getKeyChar() == '2'){
            solo = false; //Solo mode is off
        }
        //Activate Cheat Code
        if (e.getKeyChar() == 'c'){
            cheat = true; //Cheat mode activated
            paddleSpeed1 = paddleSpeed1 * 2; //Move your paddle twice as fast
        }
        //Deactivate Cheat Code
        if (e.getKeyChar() == 'd' && cheat == true){
            cheat = false;
            paddleSpeed1 = paddleSpeed1 / 2; //Return to normal speed
        }
        //Change Game mode to special
        if (e.getKeyChar() == '3'){
            special = true;
        }
        //Change Game mode to normal
        if (e.getKeyChar() == '4'){
            special = false;
        }
    }

    // defines what we want to happen if a keyboard button
    // has been released - you need to complete this
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();

        // stops paddle motion based on which button is released
        //If the up button is released
        if (keyCode == KeyEvent.VK_UP)
            up2 = false; //Paddle 2 stops moving
        //If the down button is released
            if (keyCode == KeyEvent.VK_DOWN)
                down2 = false; //Paddle 2 stops moving
        //If the w key is released
                if(e.getKeyChar() == 'w')
                    up1 = false; //Paddle 1 stops moving
        //If the s key is released
                    if (e.getKeyChar() == 's'){
                        down1 = false; //Paddle 1 stops moving
                    }
        // fill this in
    }

    // restarts the game, including scores
    public void restart() {
        player1score = 0; //Reset player 1 score
        player2score = 0; //Reset player 2 score
        p1y = HEIGHT / 2 - 60; //Reset player 1 position
        p2y = HEIGHT / 2 - 60; //Reset player 2 position
        ballx = 280; //Reset the ball position on x-coordinate
        bally = 300; //Reset the ball position on y-coordinate
        ballXshift = speed; //Reset the ball speed on x-coordinate
        ballYshift = 0; //Reset the ball speed on y-coordinate
        // your code here
    }

    //////////////////////////////////////
    //////////////////////////////////////

    // DON'T TOUCH THE BELOW CODE


    // this method runs the actual game.
    public void run() {

        // while(true) should rarely be used to avoid infinite loops, but here it is ok because
        // closing the graphics window will end the program
        while (true) {

            // draws the game
            repaint();

            // we move the ball, paddle, and check for collisions
            // every hundredth of a second
            move_ball();
            move_paddles();
            check_collisions();

            //rests for a hundredth of a second
            try {
                Thread.sleep(10);
            } catch (Exception ex) {}
        }
    }

    // very simple main method to get the game going
    public static void main(String[] args) {
        new Pong();
    }

    // does complicated stuff to initialize the graphics and key listeners
    // DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
    // GRAPHICS!
    public Pong() {
        JFrame frame = new JFrame();
        JButton button = new JButton("restart");
        frame.setSize(WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.add(button, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restart();
                Pong.this.requestFocus();
            }
        });
        this.addKeyListener(this);
        this.setFocusable(true);

        run();
    }

    // method does nothing
    public void keyTyped(KeyEvent e) {}
}