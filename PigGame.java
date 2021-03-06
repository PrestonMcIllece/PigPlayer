 /**
 * Preston McIllece's Project
 * 
 * This class creates the actually games to be played. This class contains the bulk of
 * the project and this is the class that needs to be run to play.
 */

import java.util.Scanner;

public class PigGame {
  
  public static final int GOAL = 100;
  protected PigPlayer playerA;
  protected PigPlayer playerB;
  static Scanner keyboard = new Scanner(System.in);
  static boolean verbose;
  
  //default constructor initializing players
  public PigGame()
  {
    UserPigPlayer user1 = null;
    UserPigPlayer user2 = null;
    
    playerA = user1;
    playerB = user2;
  }
  
  //constructor passed names to initialize players with
  public PigGame(String name1, String name2)
  {
    UserPigPlayer user1 = new UserPigPlayer(name1);
    UserPigPlayer user2 = new UserPigPlayer(name2);
    playerA = user1;
    playerB = user2;
  }
  
  //constructor passed players, also initializes instance data
  public PigGame(PigPlayer name1, PigPlayer name2)
  {
    playerA = name1;
    playerB = name2;
  }
  
  //This method resets the players back to the original instance data
    public void reset()
  {
    playerA.reset();
    playerB.reset();
  }
    
    //this method creates the ability to play a single turn
  public static int playTurn(PigPlayer player, PigPlayer opponent)
   {
 // if (verbose)
    {
    System.out.println();
    System.out.println("It's " + player.playersName + "'s turn.");
    System.out.println(player);
    System.out.println(opponent);
    }
    int turnTotal = 0;
    int opponentScore = opponent.getScore();
    boolean notOne = true;
    
    //the only reason to not allow the user to roll again is if they roll a 1 or hold
    while (notOne == true && player.isRolling(turnTotal, opponentScore) == true)
    {
     int roll = Die.roll();
     if (roll == 1)
      {
        turnTotal = 0;
        notOne = false;
     // if (verbose)
        System.out.println("Roll: 1");
      }
      
      else
      {
       turnTotal = turnTotal + roll;
     // if (verbose)
       System.out.println("Roll: " + roll);
      }
    }
       player.addPoints(turnTotal);
    // if (verbose)
   System.out.println("Turn total : " + turnTotal);
   return turnTotal;
  }
  
  //this method creates the ability to play a game by alternating playTurn()
  public void playGame()
  {
    reset();
    while (playerA.getScore() < GOAL && playerB.getScore() < GOAL)
    {
      playTurn(playerA, playerB);
      if (playerA.getScore() < GOAL)
      {
        playTurn(playerB, playerA);
        
      }
    }
    if (playerA.getScore() >= GOAL)
    {
     // if (verbose)
     System.out.println(playerA.getName() + " won!");
    }
    else
    {
   //  if (verbose)
    System.out.println(playerB.getName() + " won!");
    }
  }
  
  //this method allows 2 users to play against each other. It randomly decides who goes first
  public static void userVsUser()
  {
    System.out.println("Let's play Pig!");
    System.out.println("Two players race to reach 100 points.");
    System.out.println("Each turn, a player repeatedly rolls a die until either a 1 is rolled or");
    System.out.println("the player holds and scores the sum of the rolls (i.e the turn total).");
    System.out.println();
    System.out.println("When given a choice to roll or hold, please type Enter to roll, anything else to hold.");
    System.out.println();
    
    System.out.println("What's the first player's name?");
    String first = keyboard.nextLine();
    
    System.out.println("What's the second player's name?");
    String second = keyboard.nextLine();
    
    int x = (int)(2 * Math.random());
    String goesFirst = null;
    String goesSecond = null;
    
    if (x >= 1)
    {
       goesFirst = second;
       goesSecond = first;
    }
    else 
    {
       goesFirst = first;
       goesSecond = second;
    }
    
    System.out.println(goesFirst + ", you will go first.");
    PigGame game = new PigGame(goesFirst, goesSecond);
    game.playGame();
  }
  
  //allows a user to play against a computer. Randomly decides who goes first
  public static void userVsComputer()
  {
    System.out.println("What's the player's name?");
    String name = keyboard.nextLine();
    
    PigPlayer player1 = new UserPigPlayer(name);
    PigPlayer player2 = new StrategicPlayer("CPU", 24, 78);
    
    int x = (int)(2 * Math.random());
    
    if (x >= 1)
    {
       PigGame game = new PigGame(player2, player1);
       game.playGame();
    }
    else 
    {
       PigGame game = new PigGame(player1, player2);
       game.playGame();
    } 
  }
  
  //allows 2 computers to play against each other
  public static void computerVsComputer()
  {
    PigPlayer player1 = new SimpleHoldPlayer("Ada");
    PigPlayer player2 = new SimpleHoldPlayer("Charles");
    
    int x = (int)(2 * Math.random());
    
    if (x >= 1)
    {
       PigGame game = new PigGame(player2, player1);
       game.playGame();
    }
    else 
    {
       PigGame game = new PigGame(player1, player2);
       game.playGame();
    } 
  }
  
  //main method to actually output and play the game
  public static void main(String [] args)
  {
    userVsComputer();
    
  }
}
