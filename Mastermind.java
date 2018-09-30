import java.util.Scanner;
import java.util.Random;

/** Allow the user to play a version of the game Mastermind.
    A four-digit integer containing no zeroes is selected
    at random by the program, and the user attempts
    to guess it, receiving hints along the way.
 */
public class Mastermind {

   /** The main method.
       @param args Command-line arguments, ignored
    */
   public static void main(String[] args) {

      Scanner kb = new Scanner(System.in);

      //Generate a random String of length 4 made up of digits 1-9
      String target = genTargetWithNoZeroes();

      //The statement below can be uncommented for testing purposes
      //It should be commented out when file is handed in!
      System.out.println("TARGET = " + target);

      //Display the game instructions for the user
      outputDirections();

      //Collect user's first guess
      System.out.print("Your guess: ");
      String guess = kb.next();
      int guessCount = 1;

      //Repeat as long as guess is incorrect
      while (!guess.equals(target)) {

         //Give clue based on previous guess
         String clue = getClue(target, guess);
         System.out.println(clue);

         //Collect next guess and update counter
         System.out.print("Your guess: ");
         guess = kb.next();
         guessCount++;
      }

      //Output ending message
      System.out.println("You got it right in " + guessCount + " guesses.");
   }


   /**
      Given a particular target String, returns the appropriate clue to
      output after the given guess. In the return string, all R’s appear
      before all W’s, and each R and each W are followed by a single space.
      If neither R’s nor W’s are warranted, returns the String "none".
      @param target The target string which user is trying to guess
      @param guess  The user's guess
      @return  A string giving feedback on the user's guess
    */
   public static String getClue(String target, String guess) {
      int i;
      boolean any = false;
      final int limit = 4;


      for (i = 0; i < limit; i++) {
         //System.out.print("cycle");
         if (target.charAt(i) == guess.charAt(i)) {
            System.out.print("R ");
            any = true;
         } //records first position of non R as t

         for (int b = 1; b < limit; b++) {
            for (i = 0; i < limit; i++) {
               if (target.charAt(i) == guess.charAt(b)) {
                  System.out.print("W ");
                  any = true;
               }
            }
         }
         if (!any) {
            System.out.print("none");
         }
      } //System.out.print("here");
      return " ";
   }

   /**
      Returns a randomly-selected String containing exactly four
      digits from the range 1-9 inclusive.
      @return the randomly-generated 4-digit String
    */
   public static String genTargetWithNoZeroes() {

      final int numPlaces = 4;
      final int topOfDigitRange = 9;

      //generator to allow us to generate random digits
      Random gen = new Random();

      //"adding" digits to a String will result in a String
      String target = "";

      //repeatedly generate a non-zero digit
      for (int i = 0; i < numPlaces; i++) {
         target = target + (gen.nextInt(topOfDigitRange) + 1);
      }
      return target;
   }


   /**
      Outputs game instructions on the screen.
      This exists as a separate method only to de-clutter main method.
    */
   public static void outputDirections() {
      System.out.println("I’m thinking of a 4-digit number.  "
         + "Each digit is between 1 and 9. Try to ");
      System.out.println("guess my number, and I’ll say "
         + "R for each digit you get in the right place, ");
      System.out.println("and W for each correct digit "
         + "you get in the wrong place.  If you don’t ");
      System.out.println("use any of the correct digits "
         + "in your guess, I’ll say none.");
      System.out.println();
   }

}
