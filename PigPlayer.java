/**
 * Preston McIllece's Project
 * 
 * This class creates a general pig player, not necessarily computer nor user.
 * This is the parent class of all of the user and computer players
 */

public abstract class PigPlayer 
{

  protected String playersName;
  protected int currentScore = 0;
  protected int gamesWon = 0;
 
  //constructor initializing name
  public PigPlayer(String name)
  {
    playersName = name;
  }
  
  //sets name to parameter
  public void setName(String name)
  {
    playersName = name;
  }
  
  //returns name
  public String getName()
  {
    return playersName;
  }
  
  //resets the player's score
  public void reset()
  {
    currentScore = 0;
  }
  
  //adds points to the player's score
  public void addPoints(int turnTotal)
  {
    currentScore += turnTotal;
    
    if (currentScore >= PigGame.GOAL)
    {
      gamesWon++;
    }
  }
  
  //determines if the player has enough points to win
  public boolean won()
  {
    if (currentScore >= PigGame.GOAL)
    {
      return true;
    }
    
    else
    {
      return false;
    }
  }
  
  //returns the player's current score
  public int getScore()
  {
    return currentScore;
  }
  
  //returns the number of times a player has won
  public int getWinRecord()
  {
    return gamesWon;
  }
  
  //when you System.out.println() and pass it a PigPlayer as the parameter, it will return the player's name and score.
  public String toString()
  {
    return "Player's name: " + playersName + ". Player's current score: " + currentScore;
  }
  
  
 
 // Returns a boolean value indicating if the player wants to roll the Die again.
 // Returns true to roll again, false to not roll again.
public abstract boolean isRolling(int turnTotal, int opponentScore);
  
  //resets the number of wins a player has back to 0
public void resetWinRecord()
{
  gamesWon = 0;
}


  /*
   public static void main(String[] args) { 
     
     PigPlayer preston = new PigPlayer("Preston");
     System.out.println("Player name is " + preston.getName());
     
    preston.setName("Not Preston lol");
     System.out.println("Player name is " + preston.getName());
     
  
     preston.addPoints(22);
     preston.addPoints(12);
     preston.addPoints(66);
     System.out.println("Current score is " + preston.getScore());
     System.out.println(preston.won());
     
     preston.reset();
     System.out.println("Current score after reset is " + preston.getScore());
     System.out.println(preston.won());
     
     System.out.println("Player has won " + preston.getWinRecord() + " games.");
      
   }
   
   */
}
