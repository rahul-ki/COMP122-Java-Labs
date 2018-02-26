/**         BIRD HANGMAN GAME!
 * Bird is chosen from a list of birds hard-coded!
 * Skeleton code for a class file to implement a semi-"Hangman-style" 
 * game where someone guesses letters and those letters are revealed in 
 * a word (if they are present, of course).  
 *REFER BirdGameUser.java for application file.
**/

import java.util.*;   //java.util.Arrays; java.util.Random

public class BirdGame {

    protected String listType;  //**  What is in the list of words.  
    protected String target;  //**  The "solution" to the game.  
    protected String currentKnowledge; //**  What the game player currently knows.
            // can also do ArrayList<String> currentKnowledge = new ArrayList<>;

 
   //**  A method to return a String that the user will try to guess.  
    public String chooseTarget()  {
      
        String[] list = {  "blackbird", "house sparrow", "tree sparrow", 
         "dunnol", "blue tit", "great tit", "chaffinch", "bullfinch",
         "nuthatch", "pied wagtail", "magpie", "mistle thrush", 
         "song thrush", "greenfinch", "brambling", "linnet", "redpoll",
         "cormorant", "shag", "robin", "mallard", "tufted duck", 
         "pochard", "gadwall", "teal", "wigeon", "coot", "kingfisher",
         "great crested grebe", "lapwing"  };
        Random r = new Random();

        return list[r.nextInt(list.length)];
     
    }

   //*******  Constructor for the game.  
    public BirdGame()  {

        listType = "bird";
        target = chooseTarget();  
        currentKnowledge = "";
        for (int i = 0; i < target.length(); i++)  {
            currentKnowledge = currentKnowledge + "*";
        } //currentKnowledge.add("*");
      
    }

   public String getTarget()  {
      return target;
   }

    public String getCurrentKnowledge(char c)  {
            
            if (makeGuess(c)) {
                // To check all occurences of a particular character!
                for (int i = 0; i <target.length(); i++) {
                    
                    if (target.charAt(i)==c)
                        currentKnowledge = currentKnowledge.substring(0,i) + c + currentKnowledge.substring(i+1,target.length());
                //IF ARRAYLIST currentKnowledge.set(d,String.valueOf(c));
                }
            }
            
            
            return currentKnowledge;
    }
            
   //**  Makes a "guess" by exposing letters in the target word that match the guess just made.  
    public boolean makeGuess(char c)  {
        boolean foundLetter = false;
        if (target.indexOf(c)!=(-1)) 
            foundLetter = true;
        else
            foundLetter = false;
        return foundLetter;
   }      
    
   //**  The method to play the game with the user.  
    public void playGame()  {
        char[] guesses = new char[target.length()];
        char c = ' ';
        
        
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);        // Need another input2 because of buffer reasons. Else cant input guess_word (str) at line 11
        System.out.println("We’re going to play a game.");
        System.out.println("I am thinking of a bird. You are supposed to guess letters and try to figure out what I am thinking of, ok?");
        System.out.println("\n");
        System.out.println("You have at most " + target.length() + " guesses for letters.");
        System.out.println("Note that 'letters' might include a space, but are otherwise lowercase letters.");
        System.out.println("\n");
        System.out.println(currentKnowledge);
        
        
        for (int i = 0; i < target.length(); i++)  {
            
            System.out.println("Letters guessed so far: " + Arrays.toString(guesses));
            System.out.print("Please guess a letter: ");
            c = input.next().charAt(0); //HOW TO INPUT SPACE
            c = Character.toLowerCase(c);
            guesses[i]=c;
            System.out.println("\nYou guessed \"" + c + "\""); 
            if (makeGuess(c)) 
                System.out.println("You guessed right\n");
            else
                System.out.println("You guessed wrong\n");
            System.out.println(getCurrentKnowledge(c));
        }
        
        System.out.println("You are now out of guesses. GUESS THE WORD");
        System.out.println("\nPlease guess the word: ");
        String str = input2.nextLine();  //next() -> only 1 word!
        str= str.toLowerCase();
        
        if (str.equals(target)) {
            System.out.println("You guessed the word correctly.");
        } else {
            System.out.println("Wrong!");
            System.out.println(target);
        }

    }
}

