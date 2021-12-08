package com.example.WhackAMoleFillerChallenge;

// Filler code for Whack a Mole by Mr. Friedman
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

//IMPORTANT: Do not click on bombs, they will explode and deduct your HP by ten!
//IMPORTANT: When you are running out of time, click freeze! It restarts the timer!
//IMPORTANT: If your health drops to 0, you lose! Good Luck!

public class WhackAMoleFillerChallenge {
    private Image mole, hole, bg, bomb, over, freeze; //Images

    // size of the display area
    private int windowWidth = 800, windowHeight = 600, textHeight = 35; //Setting values

    private int waitSeconds = 3; //Seconds between each period of time

    private int score = 0; //Score
    private int health = 100; //Health Points

    private int numOfmole = 10; //Number of Moles
    private int numGettingout = 5; //Number of Moles popping out
    private int moleSize = 75; //Size of mole image
    private int holeSize = 75; //Size of hole image
    private int bombSize = 75; //Size of bomb image
    private int freezeSize = 75; //Size of freeze image
    private double adjustValue = 1.2; //Value used to adjust the locations of the images

    private int xPos[] = new int[numOfmole]; //x-position of the images
    private int yPos[] = new int[numOfmole]; //y-position of the images
    private boolean out[] = new boolean[numOfmole]; //array used to test if the mole is popping out
    private boolean boom[] = new boolean[numOfmole]; //array used to test if it is a bomb
    private boolean cold[] = new boolean[numOfmole]; //array used to test if it is a freeze

    private int count = 0; //numbers of moles actually generated
    private int sequence = 0; //the number position in the array
    private boolean justRight = false; //boolean used to test if the number of moles is correct

    private double random = 0; //variable used to generate random numbers

    Timer myTimer; //timer

    public void setUp(){
        bg = Toolkit.getDefaultToolkit().getImage("Background.png"); //Set up background
        mole = Toolkit.getDefaultToolkit().getImage("Mole.png"); //Set up moles
        hole = Toolkit.getDefaultToolkit().getImage("Hole.png"); //Set up holes
        bomb = Toolkit.getDefaultToolkit().getImage("Bomb.png"); //Set up bombs
        over = Toolkit.getDefaultToolkit().getImage("Gameover.png"); //Set up gameover
        freeze = Toolkit.getDefaultToolkit().getImage("Freeze.png"); //Set up freeze
        for (int i = 0; i <= numOfmole - 1; i++){
            xPos[i] = (int)(Math.random() * windowWidth / adjustValue); //generate x-position
            yPos[i] = (int)(Math.random() * windowHeight / adjustValue); //generate y-position
        }
        for (int i = 1; i <= numGettingout; i++){
            out[(int)(Math.random() * numOfmole)] = true; //determine which moles are popping out
        }
        while (count < numGettingout){
            count = 0; //reset the value to zero
            out[(int)(Math.random() * numOfmole)] = true; //set the mole to popping out
            for (int i = 0; i <= numOfmole - 1; i++){
                if (out[i] == true){
                    count++; //recount the number of moles popping out
                }
            }
        }
        count = 0; //reset the value to zero
        for (int i = 0; i <= numOfmole - 1; i++){
            if (out[i] == true){
                count++; //recount the number of moles popping out
            }
        }
        if (count > numGettingout){ //if there are extra moles popping out
            while(count > numGettingout){
                if(out[sequence] == true && sequence < numOfmole){
                    out[sequence] = false; //set the mole to not pop out
                    count--; //decrease the number by one
                }
                sequence++; //position in the array increases
            }
        }
    }

    public void draw(Graphics g) {
        g.drawImage(bg, 0, 0, windowWidth, windowHeight, null); //draw the background
        for (int i = 0; i <= numOfmole - 1; i++){
            if (out[i] == true) {
                g.drawImage(mole, xPos[i], yPos[i], moleSize, moleSize, null); //draw the moles
            }
            else if (boom[i] == true){
                g.drawImage(bomb, xPos[i], yPos[i], bombSize, bombSize, null); //draw the bomb
            }
            else if (cold[i] == true){
                g.drawImage(freeze, xPos[i], yPos[i], freezeSize, freezeSize, null); //draw the freeze
            }
            else {
                g.drawImage(hole, xPos[i], yPos[i], holeSize, holeSize, null); //draw the holes
            }
        }
        if (health <= 0){
            g.drawImage(over, 0, 0, windowWidth, windowHeight, null); //draw gameover if health is 0 or less
        }
    }

    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
        if (health > 0) {
            for (int i = 0; i <= numOfmole - 1; i++) {
                if (Math.pow(mouseX - xPos[i] - moleSize / 2, 2) + Math.pow(mouseY - yPos[i] - moleSize / 2, 2) <= Math.pow(moleSize / 2, 2) && out[i] == true) { //pythagorean theorem/circle
                    out[i] = false; //set the mole to underground
                    score++; //add the score
                }
                if (Math.pow(mouseX - xPos[i] - bombSize / 2, 2) + Math.pow(mouseY - yPos[i] - bombSize / 2, 2) <= Math.pow(bombSize / 2, 2) && boom[i] == true) { //pythagorean theorem/circle
                    boom[i] = false; //set the bomb to underground
                    health -= 10; //decrease the health by ten
                }
                if (Math.pow(mouseX - xPos[i] - freezeSize / 2, 2) + Math.pow(mouseY - yPos[i] - freezeSize / 2, 2) <= Math.pow(freezeSize / 2, 2) && cold[i] == true) { //pythagorean theorem/circle
                    cold[i] = false; //set the freeze to underground
                    myTimer.stop(); //stop/reset the timer
                    myTimer.start(); //start the timer
                }
            }
        }
    }

    public void getOut(){
        if (health > 0) { //works only if health is above 0
            count = 0; //reset the count
            sequence = 0; //reset the position in array
            justRight = false; //reset the boolean
            for (int i = 0; i <= numOfmole - 1; i++) {
                out[i] = false; //set the moles underground
                boom[i] = false; //set the bomb underground
                cold[i] = false; //set the freeze underground
            }
            for (int i = 1; i <= numGettingout; i++) {
                out[(int) (Math.random() * numOfmole)] = true; //set the moles popping out
            }
            while (justRight == false) { //if the number of moles is not enough
                count = 0; //reset the value to zero
                out[(int) (Math.random() * numOfmole)] = true; //set the moles to pop out
                for (int i = 0; i <= numOfmole - 1; i++) {
                    if (out[i] == true) {
                        count++; //recount the number of moles popping out
                    }
                    if (count == numGettingout) {
                        justRight = true; //set the boolean to true if the number is correct
                    }
                }
            }
            if (count > numGettingout) { //if there are extra moles popping out
                while (count > numGettingout) {
                    if (out[sequence] == true && sequence > 0) {
                        out[sequence] = false; //set the mole underground
                        count--; //decrease the number by one
                    }
                    sequence++; //increase the position in the array
                }
            }
            for (int i = numOfmole - 1; i >= 0; i--) {
                random = Math.random() * numOfmole; //generate random number
                if (out[(int) (random)] != true) { //determine if the mole is popping out
                    boom[(int) (random)] = true; //set the bomb to pop out
                    break;
                }
            }
            for (int i = 0; i <= numOfmole - 1; i++) {
                random = Math.random() * numOfmole; //generate random number
                if (out[(int) (random)] != true && boom[(int) (random)] != true) { //determine if the mole is popping out or if it is a bomb
                    cold[(int) (random)] = true; //set the freeze to pop out
                    break;
                }
            }
        }
    }

    // reset the game
    public void reset() {
        myTimer.stop(); //stop/reset timer
        myTimer.start(); //start the timer
        sequence = 0; //reset number position in array
        score = 0; //reset score
        count = 0; //reset number
        health = 100; //reset health
        justRight = false; //reset boolean
        for (int i = 0; i <= numOfmole - 1; i++){
            xPos[i] = (int)(Math.random() * windowWidth / adjustValue); //reset x-position
            yPos[i] = (int)(Math.random() * windowHeight / adjustValue); //reset y-position
        }
        for (int i = 0; i <= numOfmole - 1; i++){
            out[i] = false; //set the moles underground
            boom[i] = false; //set the bomb underground
            cold[i] = false; //set the freeze underground
        }
        for (int i = 0; i <= numGettingout - 1; i++){
            out[(int)(Math.random() * numOfmole)] = true; //set the moles to pop out
        }
        while (justRight == false){ //while number is incorrect
            count = 0; //reset the count number
            out[(int)(Math.random() * numOfmole)] = true; //set the mole to pop out
            for (int i = 0; i <= numOfmole - 1; i++){
                if (out[i] == true){
                    count++; //recount the number of moles popping out
                }
                if (count == numGettingout){
                    justRight = true; //determine if the number is correct
                }
            }
        }
        if (count > numGettingout){ //if there are extra moles popping out
            while(count > numGettingout){
                if(out[sequence] == true && sequence < numOfmole){
                    out[sequence] = false; //set the mole underground
                    count--; //decrease the number by one
                }
                sequence++; //increase the position in the array
            }
        }
    }
    
    // MAYBE TOUCH THE BELOW CODE? //
    public WhackAMoleFillerChallenge() {
        setUp();
        JFrame window = new JFrame();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                scoreDisplay.setText("\t\tScore: 0");
                window.getContentPane().repaint();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());

        topPanel.add(scoreDisplay);

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                scoreDisplay.setText("\t\tScore:" + " " + score + "      " + "Health: " + health);
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

        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            }
        });
        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        window.getContentPane().repaint();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        canvas.repaint();
        myTimer = new Timer(waitSeconds * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getOut();
                window.getContentPane().repaint();
            }
        });
        myTimer.start();
    }

    public static void main(String[] args) {
        new WhackAMoleFillerChallenge();
    }
}
