/**
 * Preston McIllece's Project
 * 
 * This class creates a computer pig player that rolls until they reach a specific hold value.
 * This hold value can be given as a parameter or will default to 15
 * 
 */

public class SimpleHoldPlayer extends PigPlayer
{
  
  protected int holdValue;
  
  //default constructor. Hold value 15
  public SimpleHoldPlayer()
  {
    super("SimpleHoldPlayer");
    holdValue = 15;
  }
  
  //constructor initializing a name and hold value of 15
  public SimpleHoldPlayer(String name)
  {
    super(name);
    holdValue = 15;
  }
  
  //constructor initializing a name and a hold value
  public SimpleHoldPlayer(String name, int hv)
  {
    super(name);
    holdValue = hv;
  }
  
  //necessary  isRolling method because PigPlayer has an abstract isRolling. 
  //this method tells the computer to keep rolling if they haven't reached
  //the hold value yet and to stop when they have
  public boolean isRolling(int turnTotal, int opponentScore)
  {
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
