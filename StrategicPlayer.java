/*
 * Preston McIllece's Project
 * 
 * This class creates a computer player who uses strategy. The computer will 
 * be more aggressive if they are losing and more conservative if they are 
 * winning.
 */

public class StrategicPlayer extends PigPlayer
{
  protected int reasonable;
  protected int close;
  
  //constructor initializing name, hold value, and close value
  public StrategicPlayer(String name, int hold, int sketchy)
  {
    super(name);
    reasonable = hold;
    close = sketchy;
  }
  
  //required isRolling method because isRolling is abstract in PigPlayer
  //this method determines whether or not to keep rolling depending on
  //their current score and their opponent's score
   public boolean isRolling(int turnTotal, int opponentScore)
  {
    int holdValue = reasonable + (opponentScore - currentScore)/25;
    
    if (turnTotal < holdValue)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}