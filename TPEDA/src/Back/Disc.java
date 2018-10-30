package Back;

public class Disc {
    protected int colour;
    protected int row;
    protected int col;

    Disc(int colour, int row, int col) {
        this.colour = colour;
        this.row = row;
        this.col = col;
    }

    protected void swap(int colour) {
        this.colour = colour;
    }
}
