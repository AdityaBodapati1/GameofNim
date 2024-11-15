import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    public Player() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player name: ");
        name = sc.nextLine();
        System.out.println("Welcome to the game of Nim, " + name);
        score = 0;
    }

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public String getName() {
        return this.name;
    }
}