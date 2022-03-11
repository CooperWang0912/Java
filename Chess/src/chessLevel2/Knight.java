package chessLevel2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Piece{
    public Knight(int turn, Image img) {
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

        //Right 2 down 1 square
        if (c + 2 < 8 && c + 2 >= 0 && r + 1 < 8 && r + 1 >= 0 && (board.getBoard()[r+1][c+2].getTeam() == -1 || board.getBoard()[r+1][c+2].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r + 1, c + 2}; //Create move
            moves.add(move); //Add move
        }
        //Left 2 down 1 square
        if (c - 2 < 8 && c - 2 >= 0 && r + 1 < 8 && r + 1 >= 0 && (board.getBoard()[r+1][c-2].getTeam() == -1 || board.getBoard()[r+1][c-2].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r + 1, c - 2}; //Create move
            moves.add(move); //Add move
        }
        //Right 2 up 1 square
        if (c + 2 < 8 && c + 2 >= 0 && r - 1 < 8 && r - 1 >= 0 && (board.getBoard()[r-1][c+2].getTeam() == -1 || board.getBoard()[r-1][c+2].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r - 1, c + 2}; //Create move
            moves.add(move); //Add move
        }
        //Left 2 up 1 square
        if (c - 2 < 8 && c - 2 >= 0 && r - 1 < 8 && r - 1 >= 0 && (board.getBoard()[r-1][c-2].getTeam() == -1 || board.getBoard()[r-1][c-2].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r - 1, c - 2}; //Create move
            moves.add(move); //Add move
        }
        //Right 1 down 2 square
        if (c + 1 < 8 && c + 1 >= 0 && r + 2 < 8 && r + 2 >= 0 && (board.getBoard()[r+2][c+1].getTeam() == -1 || board.getBoard()[r+2][c+1].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r + 2, c + 1}; //Create move
            moves.add(move); //Add move
        }
        //Left 1 down 2 square
        if (c - 1 < 8 && c - 1 >= 0 && r + 2 < 8 && r + 2 >= 0 && (board.getBoard()[r+2][c-1].getTeam() == -1 || board.getBoard()[r+2][c-1].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r + 2, c - 1}; //Create move
            moves.add(move); //Add move
        }
        //Right 1 up 2 square
        if (c + 1 < 8 && c + 1 >= 0 && r - 2 < 8 && r - 2 >= 0 && (board.getBoard()[r-2][c+1].getTeam() == -1 || board.getBoard()[r-2][c+1].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r - 2, c + 1}; //Create move
            moves.add(move); //Add move
        }
        //Left 1 up 2 square
        if (c - 1 < 8 && c - 1 >= 0 && r - 2 < 8 && r - 2 >= 0 && (board.getBoard()[r-2][c-1].getTeam() == -1 || board.getBoard()[r-2][c-1].getTeam() == EneId)){ //Check if the square is in bound and could be moved to
            int[] move = {r - 2, c - 1}; //Create move
            moves.add(move); //Add move
        }
        return moves; //Return list of moves
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