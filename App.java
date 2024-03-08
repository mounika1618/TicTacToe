
import board.Board;
import player.Player;
import game.Game;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception 
    {
      Scanner sc=new Scanner(System.in);

      Board b=new Board(3);

      Player p1=new Player();
      Player p2=new Player();

      System.out.println("Enter player1 name and symbol:");
      String n1=sc.next();
      char c1=sc.next().charAt(0);

      System.out.println("Enter player2 name and symbol:");
      String n2=sc.next();
      char c2=sc.next().charAt(0);

      p1.setdetails(n1,c1);
      p2.setdetails(n2,c2);

      Player p[]=new Player[2];
      p[0]=p1;
      p[1]=p2;

      Game g = new Game(p,b);
       g.play();
    }
}
