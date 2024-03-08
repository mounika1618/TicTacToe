package person;

public class Person {
    private String name;
    private char sym;
   public void setdetails(String name,char sym)
   {
     this.name=name;
     this.sym=sym;
   }
    public void print()
    {
       System.out.println(this.name+" "+this.sym); 
    }
  }
  