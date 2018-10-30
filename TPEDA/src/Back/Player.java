package Back;

public class Player {
    private int cantDisc = 2;
    int colour;
    boolean human;

    Player(int colour){
        this.colour = colour;
    }

    protected Disc getDisc(int row, int col) {
        return new Disc(colour, row, col);
    }
}
