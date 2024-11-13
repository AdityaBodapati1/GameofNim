public class Board{
   
    public void setPieces(){
        int piece = (int) (Math.random() * 51);     
        int totalPieces = piece;
        System.out.print("The total pieces in the game wil be " + totalPieces);
    }

}