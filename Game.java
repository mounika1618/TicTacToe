package game;

import board.Board;
import player.Player;
import java.util.Scanner;

public class Game {
Player players[];
 Board board;
 int turn;
 int moves;
 String cross_pattern;
 String zero_pattern;
boolean Gameover;
int size;
 public Game(Player ia[],Board i)
 {
    this.players=ia;
    this.board=i;
    this.turn=0;
    this.moves=0;    
    this.Gameover=false;
    this.size=i.size;
StringBuilder z=new StringBuilder();
StringBuilder c=new StringBuilder();
for(int j=0;j<board.size;j++)
{
    z.append("0");
    c.append("x");
}
  this.cross_pattern=c.toString();
  this.zero_pattern=z.toString();
 }


 

public int getIndex()
{
  Scanner sc=new Scanner(System.in);
  while(true)
  {
    System.out.println(players[turn].getname()+" enter one position");
    int pos=sc.nextInt()-1;
    int row=pos/size;
    int col=pos%size;

    if(row<0 || row>=size || col<0 || col>=size)
      {
        System.out.println("invalid position");
        continue;
      }
    if(board.matrix[row][col]!='#')
    {
        System.out.println(players[turn].getname()+" Position was already filled");
        continue;
    }
    return pos;
  }
}

public boolean checkboard()
{
    for(int i=0;i<size;i++)
    {
      StringBuilder sb=new StringBuilder();
      for(int j=0;j<size;j++)
      {
        sb.append(board.matrix[i][j]);
      }
      String st=sb.toString();
       if(st.equals(cross_pattern)||st.equals(zero_pattern))
         return true;
    }
    for(int i=0;i<size;i++)
    {
      StringBuilder sb=new StringBuilder();
      for(int j=0;j<size;j++)
      {
        sb.append(board.matrix[j][i]);
      }
      String st=sb.toString();
       if(st.equals(cross_pattern)||st.equals(zero_pattern))
        return true;
    }
    int i=0,j=0;
    StringBuilder sb=new StringBuilder();
    while(i<size && j<size)
    {
        sb.append(board.matrix[i][j]);
        i++; j++;
    }
    String st=sb.toString();
    if(st.equals(cross_pattern)||st.equals(zero_pattern))
     return true;
    
     i=0; j=size-1;
     sb=new StringBuilder();
     while(i<size && j>=0)
     {
      sb.append(board.matrix[i][j]);
       i++; j--;
     }
     st=sb.toString();
    if(st.equals(cross_pattern)||st.equals(zero_pattern))
      return true;

    return false;
}

public void play()
{
   while(!Gameover)
   {
     board.PrintBoard();
    int i=getIndex();
    int row=i/size;
    int col=i%size;

    board.matrix[row][col]=players[turn].getsymbol();
    moves++;
    if(moves>=2*size-1)
   { 
      boolean winner=checkboard();
     if(winner==true)
     {
      System.out.println(players[turn].getname()+" is the winner");
      Gameover=true;
     }
   }
    turn=1-turn;
   }
}
}
