package spaceInvaders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.imageio.ImageIO;

//Extra feature: Conquer mode and Boss mode
//In conquer mode, you have to arrive at the objective(red flag) faster than the aliens
//Remember, killing the aliens does not win, you only win after arriving at the objective
//Boss Mode: A very powerful boss is added in boss mode. It shoots out more lasers and has 3 lives in total.
//Killing it wins you the game, but remember to be careful, because you lose if you touch the boss

public class SpaceInvaders {

    // constants for various aspects of the game
    // feel free to change them to make the game harder/easier
    private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 20, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
            LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35, PLAYERSIZE = 40, OBJECTIVESIZE = 40, BOSSSIZE = 60;

    // determines the difficulty. The closer to 1.0, the easier the game
    private final double DIFFICULTY = 0.99;

    // our list of aliens
    private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();

    // our list of list of lasers for both the player and the aliens
    private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
    private ArrayList<Laser> playerLasers = new ArrayList<Laser>();

    // the player
    private SpaceThing player;

    // the current speed of the player as well as their remaining lives
    private int lives = 3, playerXspeed = 0, playerYspeed = 0;

    // booleans to keep track of the game's progress
    private boolean lost = false, paused = true;
    private boolean won = false;

    private SpaceThing pause; //The graphics used for the pause function

    private SpaceThing objective; //The objective

    private SpaceThing boss; //The boss

    private boolean Conquer = false; //Conquer mode controller

    private boolean Boss = true; //Boss mode controller

    private boolean BossPhase = false; //The boolean determining if it is boss phase or not

    private int BOSSXSPEED = ALIENSPEED * 2; //The horizontal speed of the boss

    private int BOSSYSPEED = ALIENSPEED * 2; //The vertical speed of the boss

    private int BOSSLIVES = 3; //The life count of the boss

    // move the aliens, the lasers, and the player. Loops aliens when necessary,
    // and randomly shoots lasers from the aliens
    public void move() {
        //moves the player's x coordinate if the player is inside the screen
        if (player.x + PLAYERSIZE + playerXspeed <= WIDTH && player.x + playerXspeed >= 0){
            player.moveX(playerXspeed);
        }

        //moves the player's y coordinate if the player is inside the screen
        if (player.y + PLAYERSIZE + playerYspeed <= HEIGHT && player.y + playerYspeed >= 0){
            player.moveY(playerYspeed);
        }

        //moves the aliens in normal node when it is not boss phase
        if (!BossPhase) {
            for (int i = 0; i <= aliens.size() - 1; i++) {
                aliens.get(i).moveX(ALIENSPEED); //move the aliens
                if (aliens.get(i).x >= WIDTH) {
                    aliens.get(i).moveY(PLAYERENEMYHEIGHT); //change the line if the line is full
                    aliens.get(i).x = 0; //reset x value
                }
            }
        }

        if (BossPhase){ //if it is boss phase
            if (aliens.get(0).x >= WIDTH - BOSSSIZE || aliens.get(0).x <= 0){ //if boss's x coordinate is out of screen
                BOSSXSPEED = -BOSSXSPEED; //change the speed
            }
            if (aliens.get(0).y < 0 || aliens.get(0).y >= HEIGHT / 3 * 2){ //if boss's y coordinate is out of screen
                BOSSYSPEED = - BOSSYSPEED; //change the speed
            }
            aliens.get(0).moveX(BOSSXSPEED); //move the x coordinate
            aliens.get(0).moveY(BOSSYSPEED); //move the y coordinate
        }

        for (int i = 0; i <= playerLasers.size() - 1; i++){
            playerLasers.get(i).moveY(-LASERSPEED); //move all the player lasers
        }

        for (int i = 0; i <= aliens.size() - 1; i++){
            if (Math.random() > DIFFICULTY && !BossPhase){ //if it is not boss phase and the aliens should shoot
                alienLasers.add(new Laser(aliens.get(i).x, aliens.get(i).y, LASERWIDTH, LASERHEIGHT)); //add a new laser to the array list
            }
            else if (Math.random() > DIFFICULTY / 1.1 && BossPhase){ //if it is boss phase and the boss should shoot
                alienLasers.add(new Laser(aliens.get(i).x, aliens.get(i).y, LASERWIDTH, LASERHEIGHT)); //add a new laser to the array list
            }
        }

        for (int i = 0; i <= alienLasers.size() - 1; i++) {
            alienLasers.get(i).moveY(LASERSPEED); //move all the alien lasers
        }
    }

    // check for collisions between alien lasers and the player
    // and between player lasers and the aliens
    // check if the aliens have reached the ground
    public void checkCollisions() {
        for (int i = 0; i <= playerLasers.size() - 1; i++){ //go through all the player lasers
            for (int j = 0; j <= aliens.size() - 1; j++) { //go through all the aliens
                if (playerLasers.get(i).intersects(aliens.get(j))) { //if the player laser intersects the alien laser
                    if (aliens.get(j) == boss){ //if the boss is hit
                        BOSSLIVES--; //boss lose 1 life
                    }
                    playerLasers.remove(i); //remove the laser that hit
                    aliens.remove(j); //remove the alien hit
                    i--; //go back in the array so that the next laser is not missed
                    j--; //go back in the array so that the next alien is not missed
                    break; //break from the loop
                }
            }
        }

        for (int i = 0; i <= alienLasers.size() - 1; i++){ //go through all the alien lasers
            if (alienLasers.get(i).intersects(player)){ //if the player is hit
                lives--; //lose 1 life
                alienLasers.remove(i); //remove the alien laser that hit the player
            }
        }

        if (aliens.size() == 0 && Boss && BOSSLIVES != 0){ //if game mode is boss and all the other aliens are dead and the boss has lives left
            aliens.add(boss); //add boss to the list of aliens
            BossPhase = true; //boss phase begins
        }

        for (int i = 0; i <=  aliens.size() - 1; i++){ //go through all the aliens
            if (aliens.get(i).y + PLAYERENEMYHEIGHT >= HEIGHT){ //if an alien reached the ground
                lost = true; //the player lost
            }
        }

        if (lives <= 0){ //if the player has no lives left
            lost = true; //the player lost
        }

        if (aliens.size() == 0 && !Conquer && !Boss){ //if all aliens are dead and the game mode is normal mode
            won = true; //the player won
        }

        if (Conquer && player.intersects(objective)){ //if the game mode is conquer and the player reached the objective
            won = true; //the player won
        }

        if (Boss && BOSSLIVES == 0){ //if game mode is boss mode and the boss is dead
            won = true; //the player won
        }

        if (BossPhase && BOSSLIVES != 0){ //if the boss is still alive
            if (player.intersects(aliens.get(0))){ //if the boss touches the player
                lost = true; //the player lost
            }
        }
    }

    // set up your variables, lists, etc here
    public void setup() {
        pause = new SpaceThing(0, 0, WIDTH, HEIGHT, "pause.png"); //the pause image
        int lines = NUMALIENS / (WIDTH / PLAYERENEMYWIDTH); //how many lines of aliens will there be
        //paint the lines that are filled with aliens
        for (int i = 0; i <= lines * (WIDTH / PLAYERENEMYWIDTH) - 1; i++){
            aliens.add(new SpaceThing((i * PLAYERENEMYWIDTH) % WIDTH, i / (WIDTH / PLAYERENEMYWIDTH) * PLAYERENEMYHEIGHT, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "alien.png"));
        }
        //paint the last line that is not filled with aliens and center them
        for (int i = 0; i <= NUMALIENS - lines * (WIDTH / PLAYERENEMYWIDTH) - 1; i++){
            aliens.add(new SpaceThing(i * PLAYERENEMYWIDTH + (WIDTH - (NUMALIENS - lines * (WIDTH / PLAYERENEMYWIDTH)) * PLAYERENEMYWIDTH) / 2, lines * PLAYERENEMYHEIGHT, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "alien.png"));
        }
        //set the player
        player = new SpaceThing(WIDTH / 2, HEIGHT / 3 * 2, PLAYERSIZE, PLAYERSIZE, "playerCannon.jpg");
        if (Conquer){ //if the game mode is conquer mode
            //set objective
            objective = new SpaceThing((int)(Math.random() * WIDTH), 0, OBJECTIVESIZE, OBJECTIVESIZE, "Objective.png");
        }
        if (Boss){ //if the game mode is boss mode
            //set the boss
            boss = new SpaceThing((WIDTH - BOSSSIZE) / 2, 0, BOSSSIZE, BOSSSIZE, "boss.png");
        }
    }

    // fires a player laser. if there are currently less than 4 lasers on the screen,
    // adds to the list. if there are 4 lasers on the screen, removes a laser and
    // replaces it with this new one
    public void fireLaser() {
        if (paused != true) { //if the game is not paused
            if (playerLasers.size() < 4) { //if the player has less than 4 lasers
                playerLasers.add(new Laser(player.x, player.y, LASERWIDTH, LASERHEIGHT)); //add a new laser
            }
            if (playerLasers.size() == 4) { //if the player has 4 lasers
                playerLasers.remove(0); //remove the first laser
                playerLasers.add(new Laser(player.x, player.y, LASERWIDTH, LASERHEIGHT)); //add a new laser
            }
        }
    }

    // draw a black background along with your lasers, aliens, and player here
    public void draw(Graphics g) {
        g.setColor(Color.BLACK); //set the color to black
        g.fillRect(0, 0, WIDTH, HEIGHT); //fill the background

        player.draw(g); //draw the player

        for (int i = 0; i <= aliens.size() - 1; i++){ //go through all the aliens
            aliens.get(i).draw(g); //draw the aliens
        }

        for (int i = 0; i <= playerLasers.size() - 1; i++){ //go through all the player lasers
            playerLasers.get(i).draw(g); //draw the lasers
        }

        for (int i = 0; i <= alienLasers.size() - 1; i++){ //go through all the alien lasers
            alienLasers.get(i).draw(g); //draw the lasers
        }

        if (Conquer){ //if game mode is conquer
            objective.draw(g); //draw the objective
        }

        g.setColor(Color.red); //set the color to red
        g.drawString("Lives: "+lives, 15, 15); //display lives left

        if (BossPhase){ //if it is the boss phase
            g.drawString("Boss Lives: " + BOSSLIVES, 15, 30); //display the boss health
        }

        if (paused == true){ //if the game is paused
            pause.draw(g); //draw the pause symbol
        }

        if (lost) //if the player lost
            g.drawString("You lost!", WIDTH/2-25, HEIGHT/2); //display you lost
        if (won) //if the player won
            g.drawString("You won!", WIDTH/2-25, HEIGHT/2); //display you won
    }

    // ******* DON'T TOUCH BELOW CODE ************//

    public SpaceInvaders() {
        setup();
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {draw(g);}
        };
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
        canvas.getActionMap().put("Left", new LeftAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
        canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
        canvas.getActionMap().put(" ", new SpaceAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
        canvas.getActionMap().put("Right", new RightAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
        canvas.getActionMap().put("RightRelease", new RightReleaseAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Up"); //if up is clicked
        canvas.getActionMap().put("Up", new UpAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UpRelease"); //if up is released
        canvas.getActionMap().put("UpRelease", new UpReleaseAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Down"); //if down is clicked
        canvas.getActionMap().put("Down", new DownAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DownRelease"); //if down is released
        canvas.getActionMap().put("DownRelease", new DownReleaseAction());
        canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
        canvas.getActionMap().put("Pause", new PauseAction());
        frame.add(canvas);
        frame.setVisible(true);

        while (true) {
            if (!paused && !lost && !won) { //if the game is not over or paused
                move();
                checkCollisions();
                frame.getContentPane().repaint();
            }
            if (paused){ //if the game is paused
                frame.getContentPane().repaint(); //repaint
            }
            try {Thread.sleep(20);}
            catch (InterruptedException e) {}
        }
    }

    private class RightAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            playerXspeed = PLAYERSPEED;
        }
    }
    private class LeftAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            playerXspeed = -PLAYERSPEED;
        }
    }
    private class LeftReleaseAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            playerXspeed = 0;
        }
    }
    private class RightReleaseAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            playerXspeed = 0;
        }
    }
    private class UpAction extends AbstractAction{
        public void actionPerformed(ActionEvent e) {playerYspeed = -PLAYERSPEED;} //if up key is pressed, change the y speed
    }
    private class UpReleaseAction extends AbstractAction{
        public void actionPerformed(ActionEvent e) {
            playerYspeed = 0;
        } //if up key is released, set y speed to 0
    }
    private class DownAction extends AbstractAction{
        public void actionPerformed(ActionEvent e) {playerYspeed = PLAYERSPEED;} //if down key is pressed, change the y speed
    }
    private class DownReleaseAction extends AbstractAction{
        public void actionPerformed(ActionEvent e) {
            playerYspeed = 0;
        } //if down key is released, set y speed to 0
    }
    private class SpaceAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            fireLaser();
        }
    }
    private class PauseAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {if (!lost && !won)paused = !paused;} //if game is not over, change the pause status
    }

    public static void main(String[] args) {
        new SpaceInvaders();
    }
}
