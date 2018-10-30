package Back;

import java.util.Stack;

public class Reversi {
    private int size;
    private Board board;
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private Stack<Board> previousBoards = new Stack<>();

    public Reversi(int size){
        this.size = size;
        board = new Board(size);
        activePlayer = player1;
    }

    private void putDisc(int row, int col) {
        Disc disc = activePlayer.getDisc(row, col);
        //if (!board.validPosition(disc)) throw new InvalidPosition();
        previousBoards.push(board);
        board = board.putDisc(disc);
        //board = new Board(board, activePlayer, row, col); o este?
        changePlayer();
    }
    
    public void undo() {
        board = previousBoards.pop();
        changePlayer();
    }

    private void changePlayer() {
        if(activePlayer == player1) activePlayer = player2;
        else activePlayer = player1;
    }

    /*
    private void moveAI(){
        Board newBoard = minimax();
        previousBoards.push(board);
        board = newBoard;
    }*/
}
