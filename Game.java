import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver; 
    private int turnOfPlayer;
    private boolean canHelp;


    public Game() {
        player1 = new Player();
        player2 = new Player();
        canHelp = true;
    }

    public void play() {
        // Initialize scanner for user input
        Scanner sc = new Scanner(System.in);

        // Loop for game to repeat several times
        while(!gameOver){
            // Adds pieces onto the board
            Board.setUp();
            // Sets the maximum guess value a player can make
            Board.setMaxGuess();

            // Choose first player
            Random random = new Random();
            turnOfPlayer = random.nextInt(2) + 1;

            // Sets turn to first player
            if (turnOfPlayer == 1) {
                currentPlayer = player1;
                System.out.println(player1.getName() + " will play first!");
            } else {
                currentPlayer = player2;
                System.out.println(player2.getName() + " was chosen to go first!");
            }

            // Game continues until only one piece is left on the board
            while (Board.getPieces() > 1) {
                int pieces = Board.getPieces();
                int maxGuess = Board.getMaxGuess();

                System.out.println("It is " + currentPlayer.getName() + "'s turn.");
                System.out.println("There are currently " + pieces + " pieces remaining.");

                // Checking user input
                if (maxGuess == 1) {
                    System.out.println("You can only remove 1 piece");
                } else {
                    System.out.println("You can only remove a max of " + maxGuess + " pieces.");
                }

                // If it's the computer's turn, make the move automatically
                if (currentPlayer == player2 && player2.getName().equalsIgnoreCase("computer")) {
                    int computerMove = computerWins();
                    Board.removePieces(computerMove);  // Remove pieces from the board
                    Board.setMaxGuess();               // Set the max guess to new value
                    nextMove();                     // Switch players
                } else {
                    // Prompt user for guess
                    System.out.println("How many pieces would you like to remove?");
                    int guess = sc.nextInt();
                    int helping = helpMove();
                    if(guess == 999 && canHelp){
                        System.out.print("The optimal move would be " + helping + " pieces removed.");
                        canHelp = false;
                    }
                    
                    // If the guess is valid
                    while (!isValid(guess)) {
                        System.out.println("Please type a guess up to " + Board.getMaxGuess() + " pieces.");
                        guess = sc.nextInt();
                        
                    }

                    // Remove pieces, set max guess, and move to next player's turn
                    Board.removePieces(guess);
                    Board.setMaxGuess();
                    nextMove();
                }
            }

            // Determine who won the round
            if (turnOfPlayer % 2 == 0) {
                System.out.println(player1.getName() + " won the round!");
            } else {
                System.out.println(player2.getName() + " won the round!");
            }

            // Ask if user wants to play again
            gameOver = gameOver();

        } 

    }

    private boolean gameOver() {
        // User input for restarting the game
        System.out.println("Would you like to play again? (Y/N)");

        // Initialize scanner for user input
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().toUpperCase();

        while (!(userInput.equals("Y") || userInput.equals("N"))) {
            System.out.println("Please enter Y or N. Would you like to play again?");
            userInput = sc.nextLine().toUpperCase();
        }

        return userInput.equals("N");
    }

    private void nextMove() {
        // Move to next player
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } 
        else {
            currentPlayer = player1;
        }
    }

    //Ensures user provides a valid input
    private boolean isValid(int num) {
        return num <= Board.getMaxGuess() && num > 0;  
    }

    //Logic for computer to always win
    public int computerWins() {
        int numPieces = Board.getPieces();
        int maxGuess = Board.getMaxGuess();

        int move;
        if (numPieces % 2 == 0) {
            move = 1;
        } 
        else {
            move = Math.min(numPieces - 1, maxGuess);
        }

        System.out.println("The computer removes " + move + " pieces.");
        return move;
    }

    public int helpMove(){
        int numPieces = Board.getPieces();
        int maxGuess = Board.getMaxGuess();

        int helpingmove;
        if (numPieces % 2 == 0) {
            helpingmove = 1;
        } 
        else {
            helpingmove = Math.min(numPieces - 1, maxGuess);
        }
        return helpingmove;
        
    }
}
