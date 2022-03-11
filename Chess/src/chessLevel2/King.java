package chessLevel2;

import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{

    public King(int turn, Image img) {
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

        for (int i = -1; i <= 1; i++){ //Go through 3 rows
            for (int j = -1; j <= 1; j++){ //Go through 3 columns
                if (r + i < 8 && r + i >= 0 && c + j < 8 && c + j >= 0 && (board.getBoard()[r+i][c+j].getTeam() == -1 || board.getBoard()[r+i][c+j].getTeam() == EneId)){ //If the square is in bound and not occupied by own pieces
                    int[] move = {r + i, c + j}; //Create move
                    moves.add(move); //Add move
                }
            }
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
        return false; //King cannot check a king
    }
}
