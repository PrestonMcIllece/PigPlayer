/**
 *Preston McIllece's Project
 * 
 * This program creates methods that represent a dice game
 */
public class Die {
  
  protected int sides = 6;
  
  //Roll a 6 sided die
  public static int roll()
  {
    int roll;
    roll = (int)(Math.random()* 6) + 1;
   return roll;
    }
  
  //Set the number of sides on the die
  public void setSides(int numberOfSides)
  {
    sides = numberOfSides;
  }
  
   
  //returns the number of sides on the die
  public int getSides()
         {
    return sides;
         }
         
  //Rolls a die of any number of sides
  public int rollDie()
         {
     int roll = (int)(Math.random()* sides) + 1;
    return roll;
         }

//tests the methods
  public static void main(String[] args) { 
    
    Die d1 = new Die();
   
    for (int i = 0; i < 600; i++)
    {
    System.out.println(d1.roll());
    }

  }
  
}
