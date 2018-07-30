/*
 * Preston McIllece's Project
 * 
 * This class creates a computer pig player that only uses
 * four turns to win the game.
 */

public class FourTurnsPlayer extends PigPlayer
{
  int timesHeld = 0;
  String name;

  //constructor passed a name
  public FourTurnsPlayer(String name)
  {   
    super(name);
  }
  
  //mandatory isRolling method because isRolling is abstract in PigPlayer
  //this method determines what the hold value should be to ensure that it 
  //will only take 4 turns to win
   public boolean isRolling(int turnTotal, int opponentScore)
   {
     if (timesHeld == 4)
     {
       timesHeld--;
     }
     
      int holdValue = ((PigGame.GOAL - currentScore) / (4 - timesHeld));
    
    if (turnTotal < holdValue)
    {
      return true;
    }
    else
    {
      timesHeld++;
      return false;
    }
  }
  
}