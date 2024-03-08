package board;

public class Board {
   public int size;
   public char matrix[][];

  public Board(int sz){
    this.size=sz;
    matrix=new char[size][size];
    for(int i=0;i<size;i++)
     for(int j=0;j<size;j++)
       matrix[i][j]='#';
   }

    public void PrintBoard()
    {
        for(int i=0;i<size;i++)
        {
          for(int j=0;j<size;j++)
          {
            System.out.print(matrix[i][j]+" ");
          }
         System.out.println();
        }
    }
}
