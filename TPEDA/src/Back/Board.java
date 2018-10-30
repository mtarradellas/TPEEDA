package Back;

public class Board {
    private Disc[][] matrix;
    int size;

    Board(int size) {
        this.size = size;
        matrix = new Disc[size][size];
    }

    protected Board putDisc(Disc disc) {
        Board newBoard = new Board(size);
        cloneBoard(newBoard);
        flipDirections(disc);
        return newBoard;
    }

    private void cloneBoard(Board newBoard) {
        newBoard.matrix = new Disc[size][size];
        for(int i = 0; i < size; i++) {
            System.arraycopy(newBoard.matrix[i], 0, matrix[i], 0, size);
        }
    }

    private void flipDirections(Disc disc) {
        for (int i = disc.row - 1; i < disc.row + 2; i++) {
            for (int j = disc.col - 1; i < disc.col + 2; j++) {
                search(disc, i - disc.row, j - disc.col);
            }
        }
    }

    private void search(Disc disc, int x, int y) {
        int i = disc.row + x;
        int j = disc.col + y;
        for ( ; i < size && j < size && i > 0 && j > 0; i += x, j += y){
            if (matrix[i][j] == null) return;
            if (matrix[i][j].colour == disc.colour) {
                flip(disc, matrix[i][j]);
                return;
            }
        }
    }

    private void flip(Disc from, Disc to) {
        int x = Integer.compare(to.row, from.row);
        int y = Integer.compare(to.col, from.col);
        int i = from.row + x;
        int j = from.col + y;
        for ( ; i != to.row && j != to.col; i += x, j+= y) {
            matrix[i][j].swap(from.colour);
        }
    }

}
