/*
 * Preston McIllece's Project
 * 
 * This class creates a user pig player
 * 
 */

import java.util.Scanner;

public class UserPigPlayer extends PigPlayer
{
  
  Scanner keyboard = new Scanner(System.in);
  
  //constructor initializing the name
  public UserPigPlayer(String name)
  {
    super(name); 
  }
  
  //necessary isRolling method because isRolling is abstract in Pig Player
  //this method decides if the user wants to keep rolling based on
  //what they input through the keyboard
  public boolean isRolling(int turnTotal, int opponentScore)
  {
       
    if (turnTotal + getScore() >= PigGame.GOAL)
    {
      return false;
    }
    
   System.out.println("Turn total so far: " + turnTotal + "    Roll/Hold?");
   String ch = keyboard.nextLine();

    if (ch.length() == 0) 
    {
      return true;
    }
    else 
    {
      return false;
    }
    
  }
}