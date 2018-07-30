/*
 * Preston McIllece's Project
 * 
 * This class runs simulations to determine the optimal hold value for SimpleHoldPlayer
 * and the optimal combination of hold value and close value for StrategicPlayer
 */

public class Simulations
{
  //runs simulations to see how much of an advantage the player who goes first has
  public static void firstAdvantage(long simulations)
  {
   PigPlayer user1 = new SimpleHoldPlayer("Ada");
   PigPlayer user2 = new SimpleHoldPlayer("Charles");
   double count1 = 0;
   long numberOfGames = simulations;
   
   
   for (int i = 0; i < numberOfGames; i++)
   {
     PigGame game = new PigGame(user1, user2);
     game.playGame();
     
     if (user1.won() == true)
     {
       count1++;
     }
   }
    double firstsAdvantage = 100 * (count1 / numberOfGames);
    System.out.println("Player who goes first has an advantage of " + firstsAdvantage + "%.");
  }
  
  //runs simulations to find the optimal hold value
   public static void findBestHoldValue(long simulations)
   {
     double best = 0;
     int report = 0;
     
     for (int holdValue = 1; holdValue <= 50; holdValue++)
     {
     PigPlayer user1 = new SimpleHoldPlayer("Ada", holdValue);
     PigPlayer user2 = new SimpleHoldPlayer("Charles");
     double count1 = 0;
     long numberOfGames = simulations;
   
   
       for (int i = 0; i < numberOfGames; i++)
        {
          PigGame game = new PigGame(user1, user2);
          game.playGame();
     
           if (user1.won() == true)
          {
              count1++;
            }
       }
    double firstsAdvantage = 100 * (count1 / numberOfGames);
    System.out.println("Player who goes first has an advantage of " + firstsAdvantage + "% holding at " + holdValue);
    
    if (firstsAdvantage > best)
    {
      best = firstsAdvantage;
      report = holdValue;
    }
  }
    System.out.println("The best hold value is at " + report); 
 }
   
   
   /**
   * Returns the winning percentage of the first player
   */
  public static double comparePlayers(long simulations, PigPlayer first, PigPlayer second) {
    long half = simulations/2;
    
    for (long i=0; i<half; i++) {
      PigGame pig = new PigGame(first, second);
      pig.playGame();
    }
    
    for (long i=half; i<simulations; i++) {
      PigGame pig = new PigGame(second, first);
      pig.playGame();
    }
    
    return (double)first.getWinRecord()/simulations;
  }
  
  //this method tests 2 different computer strategies to see which is better
   public static void test(int simulations)
   {
     PigPlayer hold = new SimpleHoldPlayer("Ada", 19);
     PigPlayer strategic = new StrategicPlayer("Charles", 24, 78);
     System.out.println(comparePlayers(simulations, hold, strategic));
   }
   
   //runs simulations to find the best combination of hold value and close value for StrategicPlayer
   public static void findBestCombo(long simulations)
   {
     double best = 0;
     int report = 0;
     int other = 0;
     double strategicAdvantage = 0;
     int close = 1;
     
     for (int holdValue = 1; holdValue <= 100; holdValue++)
     {
       for (close = 1; close <= 100; close++)
        {
         PigPlayer user1 = new StrategicPlayer("Ada", holdValue, close);
         PigPlayer user2 = new SimpleHoldPlayer("Charles", 19);
         double compare = comparePlayers(simulations, user1, user2);
         strategicAdvantage = 100 * (compare / simulations);
        // System.out.println("Playing with a hold value of " + holdValue + " and a close value of " + close + 
        //" has an advantage of " + firstsAdvantage);
    if (strategicAdvantage > best)
    {
      best = strategicAdvantage;
      report = holdValue;
      other = close;
    }
       }

  }
    System.out.println("The best hold value is at " + report + " and the best close to 100 value is " + other); 
 }  
   
   
}
       