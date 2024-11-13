import java.util.Scanner;

public class Player {
   private String name;
   private int pieces;
   
   public void setPlayerName()
  {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter Player Name:");
    String newName = sc.nextLine();
   
    name = newName;
    System.out.println("Hello and welcome to the game, " + getName());
    pieces = 0;
  }

  public Player(String inputName)
  {
    name = inputName;
    System.out.println("Hello and welcome to the game, " + name);
    pieces = 0;
  }
    
  public String getName()
  {
    return name;
  }
  
  public void setName(String inputName)
  {
    name = inputName;
  }

  public void addToPoints(int value)
  {
    pieces += value;
  }
   
}
