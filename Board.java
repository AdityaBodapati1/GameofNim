
public class Board {
    private static int pieces;
    private static int maxGuess;

    //Set up game with pieces
    public static void setUp() {
        pieces = (int) (Math.random() * (51));
        System.out.println("Number of pieces: " + pieces);
    }

    public static int getPieces() {
        return pieces;
    }

    public static int getMaxGuess() {
        return maxGuess;
    }

    //Removes pieces off of the board during the game
    public static void removePieces(int n) {
        pieces -= n;
    }

    //Maximum number of pieces that can be removed each turn
    public static void setMaxGuess() {
        maxGuess = (int) (pieces / 2);
        if (pieces == 1) {
            maxGuess = 1;
        }
    }
}