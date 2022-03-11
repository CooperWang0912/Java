package chessLevel2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Piece{
    public Bishop(int turn, Image img) {
        super(turn, img);
    }

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>();

        int EneId; //Declare enemy id

        if (getTeam() == 0) { //If the team is white
            EneId = 1; //Enemy id is black
        }
        else{
            EneId = 0; //Else the enemy id is white
        }

        int i = 0; //Declare variable
        boolean valid = true; //Declare boolean
        //Bottom right lane
        valid = true; //Set boolean to true
        i = 1; //Set value to 1
        while (valid){
            if (c+i < 8 && c+i >= 0 && r+i < 8 && r+i >= 0 && board.getBoard()[r+i][c+i].getTeam() == -1) { //If the square is within bound and empty
                int[] move = {r + i, c + i}; //Create move
                moves.add(move); //Add move
            }
            else if (c+i < 8 && c+i >= 0 && r+i < 8 && r+i >= 0 &&board.getBoard()[r+i][c+i].getTeam() == EneId) { //If the square is within bound and has enemy
                int[] move = {r + i, c + i}; //Create move
                moves.add(move); //Add move
                valid = false; //Stop the loop because the path is blocked
            }
            else{
                valid = false; //Stop the loop because the path is blocked
            }
            i++; //Change the value
        }
        //Top left lane
        valid = true; //Set boolean to true
        i = -1; //Set value to -1
        while (valid){
            if (c+i < 8 && c+i >= 0 && r+i < 8 && r+i >= 0 && board.getBoard()[r+i][c+i].getTeam() == -1) { //If the square is within bound and empty
                int[] move = {r + i, c + i}; //Create move
                moves.add(move); //Add move
            }
            else if (c+i < 8 && c+i >= 0 && r+i < 8 && r+i >= 0 && board.getBoard()[r+i][c+i].getTeam() == EneId) { //If the square is within bound and has enemy
                int[] move = {r + i, c + i}; //Create move
                moves.add(move); //Add move
                valid = false; //Stop the loop because the path is blocked
            }
            else{
                valid = false; //Stop the loop because the path is blocked
            }
            i--; //Change value
        }
        //Top right lane
        valid = true; //Set boolean to true
        i = 1; //Set value to 1
        while (valid){
            if (c+i < 8 && c+i >= 0 && r-i < 8 && r-i >= 0 && board.getBoard()[r-i][c+i].getTeam() == -1) { //If the square is within bound and empty
                int[] move = {r - i, c + i}; //Create move
                moves.add(move); //Add move
            }
            else if (c+i < 8 && c+i >= 0 && r-i < 8 && r-i >= 0 && board.getBoard()[r-i][c+i].getTeam() == EneId) { //If the square is within bound and has enemy
                int[] move = {r - i, c + i}; //Create move
                moves.add(move); //Add move
                valid = false; //Stop the loop because the path is blocked
            }
            else{
                valid = false; //Stop the loop because the path is blocked
            }
            i++; //Change value
        }
        //Bottom left lane
        valid = true; //Set boolean to true
        i = 1; //Set value to 1
        while (valid){
            if (c-i < 8 && c-i >= 0 && r+i < 8 && r+i >= 0 && board.getBoard()[r+i][c-i].getTeam() == -1) { //If the square is within bound and empty
                int[] move = {r + i, c - i}; //Create move
                moves.add(move); //Add move
            }
            else if (c-i < 8 && c-i >= 0 && r+i < 8 && r+i >= 0 && board.getBoard()[r+i][c-i].getTeam() == EneId) { //If the square is within bound and has enemy
                int[] move = {r + i, c - i}; //Create move
                moves.add(move); //Add move
                valid = false; //Stop the loop because the path is blocked
            }
            else{
                valid = false; //Stop the loop because the path is blocked
            }
            i++; //Change value
        }
        return moves; //return moves
    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean check(int kingr, int kingc, int r, int c, Board board) {
        boolean id = false; //Declare return variable
        for (int i = 0; i <= getMoves(board, r, c).size() - 1; i++){
            if (Arrays.equals(getMoves(board, r, c).get(i), new int[]{kingr, kingc})) { //If the king position is on the possible move list
                id = true; //Return true
            }
        }
        return id; //Else return false
    }
}
