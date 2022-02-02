package com.example.Photoshop;

// Photoshop program that can run several manipulations on
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

//Important: Extra features: Monochrome and Synthwave
//Monochrome: Changes the picture into a black and white picture
//Synthwave: Generates a poster with a synthwave style

public class Photoshop extends Component {

    // the name of the output file. will be determined by which methods are called
    private String outputName; //The name used to name the output

    // the 2d array of colors representing the image
    private Color[][] pixels; //The main array carrying the picture

    private Color[][] text; //The secondary array used to carry the texts in the Synthwave function

    // the width and height of the image
    private int w,h; //Width and height of the main image

    private int width, height; //Width and height used to generate array for the texts in the Synthwave function

    private int textWidth = 900; //Width and height of the text n the Synthwave function


    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName; //Output name
        for (int i = 0; i <= pixels.length-1; i++){ //Loop through the array
            for (int j = 0; j <= pixels[i].length-1; j++){ //Loop through the array
                int r  = pixels[i][j].getRed() + amount; //Add the amount of brightness to the red value
                int g  = pixels[i][j].getGreen() + amount;//Add the amount of brightness to the green value
                int b  = pixels[i][j].getBlue() + amount; //Add the amount of brightness to the blue value
                if (r > 255){ //Prevents the red value from going out of bound
                    r = 255;
                }
                else if (r < 0){ //Prevents the red value from going out of bound
                    r = 0;
                }
                if (g > 255){ //Prevents the green value from going out of bound
                    g = 255;
                }
                else if (g < 0){ //Prevents the green value from going out of bound
                    g = 0;
                }
                if (b > 255){ //Prevents the blue value from going out of bound
                    b = 255;
                }
                else if (b < 0){ //Prevents the blue value from going out of bound
                    b = 0;
                }
                pixels[i][j] = new Color(r, g, b); //Make changes to the original array
            }
        }
    }

    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName; //Output name
        if (horizontally == true) { //Flipping horizontally
            for (int i = 0; i <= pixels.length - 1; i++) { //Move through the array
                for (int j = 0; j <= (pixels[i].length - 1) / 2; j++) { //Move through the array
                    int r1 = pixels[i][j].getRed(); //Get red value of one side
                    int g1 = pixels[i][j].getGreen(); //Get green value of one side
                    int b1 = pixels[i][j].getBlue(); //Get blue value of one side
                    int r2 = pixels[i][pixels[i].length - 1 - j].getRed(); //Get red value of the other side
                    int g2 = pixels[i][pixels[i].length - 1 - j].getGreen(); //Get green value of the other side
                    int b2 = pixels[i][pixels[i].length - 1 - j].getBlue(); //Get blue value of the other side
                    pixels[i][j] = new Color(r2, g2, b2); //replace value
                    pixels[i][pixels[i].length - 1 - j] = new Color(r1, g1, b1); //replace value
                }
            }
        }
        else{ //Flipping vertically
            for (int i = 0; i <= (pixels.length - 1) / 2; i++) { //Move through the array
                for (int j = 0; j <= pixels[i].length - 1; j++) { //Move through the array
                    int r1 = pixels[i][j].getRed(); //Get the upper red value
                    int g1 = pixels[i][j].getGreen(); //Get the upper green value
                    int b1 = pixels[i][j].getBlue(); //Get the upper blue value
                    int r2 = pixels[pixels.length-1-i][j].getRed(); //Get the lower red value
                    int g2 = pixels[pixels.length-1-i][j].getGreen(); //Get the lower green value
                    int b2 = pixels[pixels.length-1-i][j].getBlue(); //Get the lower blue value
                    pixels[i][j] = new Color(r2, g2, b2); //Replace the value
                    pixels[pixels.length-1-i][j] = new Color(r1, g1, b1); //Replace the value
                }
            }
        }
    }

    // negates an image
    // to do this: subtract each pixel's rgb value from 255
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName; //Output name
        for (int i = 0; i <= pixels.length-1; i++){ //Go through the array
            for (int j = 0; j <= pixels[i].length-1; j++){ //Go through the array
                int r  = 255 - pixels[i][j].getRed(); //Get the opposite value of red
                int g  = 255 - pixels[i][j].getGreen(); //Get the opposite value of green
                int b  = 255 - pixels[i][j].getBlue(); //Get the opposite value of blue
                pixels[i][j] = new Color(r, g, b); //Make changes to the original array
            }
        }
    }

    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value.
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
        // the list of colors to compare to. Feel free to change/add colors
        Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN}; //The list of colors to choose from
        outputName = "simplified_" + outputName; //Output name
        double difference[] = new double[colorList.length]; //Create new array for the difference values
        for (int i = 0; i <= pixels.length-1; i++){ //Go through the original array
            for (int j = 0; j <= pixels[i].length-1; j++){ //Go through the original array
                for (int k = 0; k <= colorList.length-1; k++){ //Go through the difference array
                    difference[k] = distance(pixels[i][j], colorList[k]); //using the difference method to calculate the difference
                }
                double min = difference[0]; //creating a int container to hold the smallest value
                int pos = 0; //the position of the smallest value
                for (int l = 0; l <= difference.length-1; l++){ //going through the difference array
                    if (difference[l] < min){ //if the difference value is smaller than the smallest value
                        min = difference[l]; //replace the value
                        pos = l; //renew the position
                    }
                }
                pixels[i][j] = colorList[pos]; //make changes to the original array
            }
        }
    }

    // optional helper method (recommended) that finds the 'distance'
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
        double result = Math.sqrt(Math.pow(c1.getRed() - c2.getRed(), 2) + Math.pow(c1.getGreen() - c2.getGreen(), 2) + Math.pow(c1.getBlue() - c2.getBlue(), 2)); //Calculating the closest color
        return result;	// fix this
    }

    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values
    // with the current pixel's own rgb value.
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() {
        outputName = "blurred_" + outputName; //output name
        Color[][] afterb = new Color[pixels.length][pixels[0].length]; //the temporary array used to store the blurred values
        int r = 0; //reset red value
        int g = 0; //reset green value
        int b = 0; //reset blue value
        for (int i = 1; i + 1 <= pixels.length-1; i++){ //move through the loop
            for (int j = 1; j + 1 <= pixels[i].length-1; j++){ //move through the loop
                r = 0; //reset red value
                g = 0; //reset green value
                b = 0; //reset blue value
                for (int l = i - 1; l <= i + 1; l++){ //going through 3 rows
                    for (int k = j - 1; k <= j + 1; k++){ //going through 3 columns
                        r  += pixels[l][k].getRed(); //add red value
                        g  += pixels[l][k].getGreen(); //add green value
                        b  += pixels[l][k].getBlue(); //add blue value
                    }
                }
                r = r / 9; //average red value
                g = g / 9; //average green value
                b = b / 9; //average blue value
                afterb[i][j] = new Color(r, g, b); //make changes to the temp array
            }
        }
        for (int i = 1; i <= pixels.length-2; i++){ //left column
            r = 0; //reset red value
            g = 0; //reset green value
            b = 0; //reset blue value
            for (int l = i - 1; l <= i + 1; l++){ //Go through  3 rows
                for (int k = 0; k <= 1; k++){ //Go through 2 columns
                    r += pixels[l][k].getRed(); //add red value
                    g += pixels[l][k].getGreen(); //add green value
                    b += pixels[l][k].getBlue(); //add blue value
                }
            }
            r = r / 6; //average red value
            g = g / 6; //average green value
            b = b / 6; //average blue value
            afterb[i][0] = new Color(r, g, b); //make changes to the temp array
        }
        for (int i = 1; i <= pixels[0].length-2; i++){ //top row
            r = 0; //reset red value
            g = 0; //reset green value
            b = 0; //reset blue value
            for (int l = 0; l <= 1; l++){ //go through 2 rows
                for (int k = i - 1; k <= i + 1; k++){ //go through 3 columns
                    r += pixels[l][k].getRed(); //add red value
                    g += pixels[l][k].getGreen(); //add green value
                    b += pixels[l][k].getBlue(); //add blue value
                }
            }
            r = r / 6; //average red value
            g = g / 6; //average green value
            b = b / 6; //average blue value
            afterb[0][i] = new Color(r, g, b); //make changes to the temp array
        }
        for (int i = 1; i <= pixels[0].length-2; i++){ //right column
            r = 0; //reset red value
            g = 0; //reset green value
            b = 0; //reset blue value
            for (int l = i - 1; l <= i + 1; l++){ //go through 3 rows
                for (int k = pixels[0].length-2; k <= pixels[0].length-1; k++){ //go through 2 columns
                    r += pixels[l][k].getRed(); //add red value
                    g += pixels[l][k].getGreen(); //add green value
                    b += pixels[l][k].getBlue(); //add blue value
                }
            }
            r = r / 6; //average red value
            g = g / 6; //average green value
            b = b / 6; //average blue value
            afterb[0][i] = new Color(r, g, b); //make changes to the temp array
        }
        for (int i = 1; i <= pixels[0].length-2; i++){ //bottom row
            r = 0; //reset red value
            g = 0; //reset green value
            b = 0; //reset blue value
            for (int l = pixels.length-1; l >= pixels.length-2; l--){ //go through the array
                for (int k = i - 1; k <= i + 1; k++){ //go through the array
                    r += pixels[l][k].getRed(); //add red value
                    g += pixels[l][k].getGreen(); //add green value
                    b += pixels[l][k].getBlue(); //add blue value
                }
            }
            r = r / 6; //average red value
            g = g / 6; //average green value
            b = b / 6; //average blue value
            afterb[pixels.length-1][i] = new Color(r, g, b); //make changes to the temp array
        }
        //top left corner
        r = 0; //reset red value
        b = 0; //reset blue value
        g = 0; //reset green value
        r += pixels[0][0].getRed() + pixels[0][1].getRed() + pixels[1][0].getRed() + pixels[1][1].getRed(); //red value of 4 top left squares
        g += pixels[0][0].getGreen() + pixels[0][1].getGreen() + pixels[1][0].getGreen() + pixels[1][1].getGreen(); //green value of 4 top left squares
        b += pixels[0][0].getBlue() + pixels[0][1].getBlue() + pixels[1][0].getBlue() + pixels[1][1].getBlue(); //blue value of 4 top left squares
        r = r / 4; //average red value
        g = g / 4; //average green value
        b = b / 4; //average blue value
        afterb[0][0] = new Color(r, g, b); //make changes to the temp array
        //top right corner
        r = 0; //reset red value
        b = 0; //reset blue value
        g = 0; //reset green value
        r += pixels[0][pixels[0].length-1].getRed() + pixels[0][pixels[0].length-2].getRed() + pixels[1][pixels[0].length-1].getRed() + pixels[1][pixels[0].length-2].getRed(); //red value of 4 top right squares
        g += pixels[0][pixels[0].length-1].getGreen() + pixels[0][pixels[0].length-2].getGreen() + pixels[1][pixels[0].length-1].getGreen() + pixels[1][pixels[0].length-2].getGreen(); //green value of 4 top right squares
        b += pixels[0][pixels[0].length-1].getBlue() + pixels[0][pixels[0].length-2].getBlue() + pixels[1][pixels[0].length-1].getBlue() + pixels[1][pixels[0].length-2].getBlue(); //blue value of 4 top right squares
        r = r / 4; //reset red value
        g = g / 4; //reset green value
        b = b / 4; //reset blue value
        afterb[0][pixels[0].length-1] = new Color(r, g, b); //make changes to the temp array
        //bottom left corner
        r = 0; //reset red value
        b = 0; //reset blue value
        g = 0; //reset green value
        r += pixels[pixels.length-1][0].getRed() + pixels[pixels.length-1][1].getRed() + pixels[pixels.length-2][0].getRed() + pixels[pixels.length-2][1].getRed(); //red value of 4 bottom left squares
        g += pixels[pixels.length-1][0].getGreen() + pixels[pixels.length-1][1].getGreen() + pixels[pixels.length-2][0].getGreen() + pixels[pixels.length-2][1].getGreen(); //green value of 4 bottom left squares
        b += pixels[pixels.length-1][0].getBlue() + pixels[pixels.length-1][1].getBlue() + pixels[pixels.length-2][0].getBlue() + pixels[pixels.length-2][1].getBlue(); //blue value of 4 bottom left squares
        r = r / 4; //average red value
        g = g / 4; //average green value
        b = b / 4; //average blue value
        afterb[pixels.length-1][0] = new Color(r, g, b); //make changes to the temp array
        //bottom right corner
        r = 0; //reset red value
        b = 0; //reset blue value
        g = 0; //reset green value
        r += pixels[pixels.length-1][pixels[0].length-1].getRed() + pixels[pixels.length-1][pixels[0].length-2].getRed() + pixels[pixels.length-2][pixels[0].length-1].getRed() + pixels[pixels.length-2][pixels[0].length-2].getRed(); //red value of 4 bottom right squares
        g += pixels[pixels.length-1][pixels[0].length-1].getGreen() + pixels[pixels.length-1][pixels[0].length-2].getGreen() + pixels[pixels.length-2][pixels[0].length-1].getGreen() + pixels[pixels.length-2][pixels[0].length-2].getGreen(); //green value of 4 bottom right squares
        b += pixels[pixels.length-1][pixels[0].length-1].getBlue() + pixels[pixels.length-1][pixels[0].length-2].getBlue() + pixels[pixels.length-2][pixels[0].length-1].getBlue() + pixels[pixels.length-2][pixels[0].length-2].getBlue(); //blue value of 4 bottom right squares
        r = r / 4; //average red value
        g = g / 4; //average green value
        b = b / 4; //average blue value
        afterb[0][pixels[0].length-1] = new Color(r, g, b); //make changes to the temp array
        for (int i = 1; i + 1 <= pixels.length-1; i++) { //go through both arrays
            for (int j = 1; j + 1 <= pixels[i].length - 1; j++) { //go through both arrays
                pixels[i][j] = afterb[i][j]; //change the values in the original array into values in the temp array
            }
        }
    }

    // this highlights the edges in the image, turning everything else black.
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values.
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName; //output name
        Color[][] aftere = new Color[pixels.length][pixels[0].length];//create temp array
        int r = 0; //red value
        int g = 0; //green value
        int b = 0; //blue value
        for (int i = 1; i + 1 <= pixels.length-1; i++){ //go through the array
            for (int j = 1; j + 1 <= pixels[i].length-1; j++){ //go through the array
                r = 0; //reset red value
                g = 0; //reset green value
                b = 0; //reset blue value
                for (int l = i - 1; l <= i + 1; l++){ //loop through 3 rows
                    for (int k = j - 1; k <= j + 1; k++){ ///loop through 3 columns
                        r  += pixels[l][k].getRed(); //add red value
                        g  += pixels[l][k].getGreen(); //add green value
                        b  += pixels[l][k].getBlue(); //add blue value
                    }
                }
                r -= pixels[i][j].getRed(); //calculate red edge value
                g -= pixels[i][j].getGreen(); //calculate green edge value
                b -= pixels[i][j].getBlue(); //calculate blue edge value
                r = pixels[i][j].getRed() * 8 - r; //calculate red edge value
                g = pixels[i][j].getGreen() * 8 - g; //calculate green edge value
                b = pixels[i][j].getBlue() * 8 - b; //calculate blue edge value
                if (r < 0){ //prevent red going out of bound
                    r = 0;
                }
                else if(r > 255){ //prevent red going out of bound
                    r = 255;
                }
                if (g < 0){ //prevent green going out of bound
                    g = 0;
                }
                else if(g > 255){ //prevent green going out of bound
                    g = 255;
                }
                if (b < 0){ //prevent blue going out of bound
                    b = 0;
                }
                else if(b > 255){ //prevent blue going out of bound
                    b = 255;
                }
                aftere[i][j] = new Color(r, g, b); //make changes to the temp array
            }
        }
        for (int i = 1; i + 1 <= pixels.length-1; i++) { //go through both arrays
            for (int j = 1; j + 1 <= pixels[i].length - 1; j++) { //go through both arrays
                pixels[i][j] = aftere[i][j]; //change the values in the original array into values in the temp array
            }
        }
        for (int i = 0; i <= pixels.length - 1; i++){ //filling the rest of the array with black
            pixels[i][0] = Color.black; //left column
            pixels[i][pixels[0].length-1] = Color.black; //right column
        }
        for (int j = 1; j <= pixels[0].length-2; j++){ //filling the rest of the array with black
            pixels[0][j] = Color.black; //top row
            pixels[pixels.length-1][j] = Color.black; //bottom row
        }
        // your code here
    }

    public void monochrome(){
        outputName = "monochrome_" + outputName; //output name
        for (int i = 0; i <= pixels.length-1; i++){ //go through the array
            for (int j = 0; j <= pixels[i].length-1; j++){ //go through the array
                int r  = pixels[i][j].getRed(); //get red value
                int g  = pixels[i][j].getGreen(); //get green value
                int b  = pixels[i][j].getBlue(); //get blue value
                int grey = r + g + b; //average the three values to get grey
                grey /= 3; //average the three values to get grey
                pixels[i][j] = new Color(grey, grey, grey); //replace the original values with grey
            }
        }
    }

    public void synthwave(){
        outputName = "synthwave_" + outputName; //output name
        for (int i = 0; i <= pixels.length-1; i++){ //go through the array
            for (int j = 0; j <= pixels[i].length-1; j++){ //go through the array
                int r  = pixels[i][j].getRed() + 60; //increase red value
                int g  = pixels[i][j].getGreen() - 90; //decrease green value
                int b  = pixels[i][j].getBlue() + 120; //increase blue value
                //These are the values I chose to achieve the best visual outcome, so they are not magical numbers
                if (r > 255){ //prevent red from going out of bound
                    r = 255;
                }
                else if (r < 0){ //prevent red from going out of bound
                    r = 0;
                }
                if (g > 255){ //prevent green from going out of bound
                    g = 255;
                }
                else if (g < 0){ //prevent green from going out of bound
                    g = 0;
                }
                if (b > 255){ //prevent blue from going out of bound
                    b = 255;
                }
                else if (b < 0){ //prevent blue from going out of bound
                    b = 0;
                }
                pixels[i][j] = new Color(r, g, b); //make changes to the original array
            }
        }
        int iPos= 0; //the row position
        int jPos = 0; //the column position
        if (pixels.length < textWidth || pixels[0].length < textWidth){ //if the main picture is too small
            System.out.println("Picture is too small, please choose a picture with higher resolution"); //do not execute the program
        }
        else{ //if the picture is big enough
            for (int i = (pixels.length-textWidth-1)/2; i <= (pixels.length-textWidth-1)/2 + textWidth - 1; i++){ //in the middle of the picture
                for (int j = (pixels[0].length-textWidth-1)/2; j <= (pixels[0].length-textWidth-1)/2 + textWidth - 1; j++){ //in the middle of the picture
                    if (text[iPos][jPos].getRed() != 0 && text[iPos][jPos].getGreen() != 0 && text[iPos][jPos].getBlue() != 0) { //if the color is not null/black
                        pixels[i][j] = text[iPos][jPos]; //replace the original value in the array
                    }
                    jPos++; //add column position
                }
                iPos++; //add row position
                jPos = 0; //reset column position
            }
        }
    }


    // *************** DON'T MESS WITH THE BELOW CODE **************** //

    // feel free to check it out, but don't change it unless you've consulted
    // with Mr. David and understand what the code's doing



    public void run() {
        JFileChooser fc = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
        fc.setCurrentDirectory(workingDirectory);
        fc.showOpenDialog(null);
        File my_file = fc.getSelectedFile();
        File text = new File("Images/text.jpg");
        if (my_file == null)
            System.exit(-1);

        // reads the image file and creates our 2d array
        BufferedImage image;
        BufferedImage synth;
        try {
            image = ImageIO.read(my_file);
            BufferedImage new_image = new BufferedImage(image.getWidth(),
                    image.getHeight(), BufferedImage.TYPE_INT_ARGB);
            create_pixel_array(image);
            outputName = my_file.getName();

            synth = ImageIO.read(text);
            create_text_array(synth);

            // runs the manipulations determined by the user
            System.out.println("Enter the manipulations you would like to run on the image.\nYour "
                    + "choices are: brighten, flip, negate, blur, edge, simplify, monochrome or synthwave.\nEnter each "
                    + "manipulation you'd like to run, then type in 'done'.");
            Scanner in = new Scanner(System.in);
            String action = in.next().toLowerCase();
            while (!action.equals("done")) {
                try {
                    if (action.equals("brighten")) {
                        System.out.println("enter an amount to increase the brightness by");
                        int brightness = in.nextInt();
                        Method m = getClass().getDeclaredMethod(action, int.class);
                        m.invoke(this, brightness);
                    }
                    else if (action.equals("flip")) {
                        System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
                        Method m = getClass().getDeclaredMethod(action, boolean.class);
                        m.invoke(this, in.next().equals("h"));
                    }
                    else {
                        Method m = getClass().getDeclaredMethod(action);
                        m.invoke(this, new Object[0]);
                    }
                    System.out.println("done. enter another action, or type 'done'");
                }
                catch (NoSuchMethodException e) {
                    System.out.println("not a valid action, try again");
                } catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);}
                catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
                catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}

                action = in.next().toLowerCase();
            }
            in.close();

            // turns our 2d array of colors into a new png file
            create_new_image(new_image);
            File output_file = new File("Images/" + outputName);
            ImageIO.write(new_image, "png", output_file);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_text_array(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        text = new Color[height][];
        for (int i = 0; i < height; i++) {
            text[i] = new Color[width];
            for (int j = 0; j < width; j++) {
                text[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
        new Photoshop();
    }

    public Photoshop() {
        run();
    }
}