/** Pancake sorting - 
 *  BASED ON THE ONLY PAPER EVER WRITTEN BY BILL GATES.
 *
 *     This is a program to perform "pancake sorting" (or
 *  sorting by prefix reversal).  The idea is that you have
 *  a stack of pancakes of varying (but integer) diameter.
 *  You want to "sort" the pancakes, i.e. arrange them in
 *  a stack from smallest to largest, with largest on 
 *  the bottom of the stack.  
 *
 *  The only operation that you're permitted to do is
 *  to pick up and flip an entire stack of pancakes.  
 *
 *  Input will be read from standard input, and can consist
 *  of one of more lines of input.  Each line of input represents
 *  a separate stack of pancakes.  It is assumed that the stack
 *  is entered from top-to-bottom order, i.e., the first one
 *  in the list is the one on top of the stack.  Also, we
 *  refer to the pancake on top of the stack as pancake #1,
 *  and the one on the bottom as pancake #k (where k=number
 *  in the stack).   
 *
 *  Output should first consist of echoing the stack of pancakes,
 *  and then should consist of a sequence of numbers, where
 *  an integer i means that the stack including  pancake i 
 *  (so pancakes i, i-1, i-2, ..., 1) are flipped over.  
 *  A "0" indicates that no more flips are necessary.    
 *
 *  Input should be in the following format:
 *    n_1 n_2 .....  n_k
 *    n_1 n_2 .....  n_j
 *    ....
 *    ....
 *
 *  Each list consists of k integers (k can vary from stack to stack, 
 *  but we're going to assume always that k <=100).
 *  
 *  Note:  Integers in each list need *not* be distinct, and this is
 *  something that you should keep in mind.
 *
 *  It's easiest if you redirect input from a file (ask me if you
 *  don't know how to do this).  For example you can try this command:
 *     $ java Pancakes <inputfile
 *
 *  The comments and main method written by my professor - Russell Martin, Feb 2018
 *  
*/
import java.util.*;

public class Pancakes  {

    public static final int MAX_SIZE = 100;

    public static void main (String args[])  {
        Scanner s, ls;
        int pancakes[] = new int[MAX_SIZE];
        int k;

        s = new Scanner(System.in);  // create new input Scanner

        while(s.hasNextLine())    /*  While there's more data to process...  */
           {
              /*  Read the integers  */
              ls = new Scanner(s.nextLine());  //  Want to process the line
                                               //  of input to separate into
                                               //  distinct numbers.  
              k = 0;
              while (ls.hasNextInt())
                  pancakes[k++] = ls.nextInt();
 
              processStack(pancakes, k);
           }

   }  /*  end of "main" procedure  */

   
   public static void processStack(int pancakes[], int k)  { 
        int bottom, max_index, i, j;
		
        /*  First, print out the stack again  */
        for (j = 0; j < k; j++)
            System.out.print(pancakes[j] + " ");
        System.out.println();

        System.out.print("Flip sequence: ");
		
		for(bottom = k-1; bottom > 0; bottom--) {
			
			// First find max from pancakes[0] till pancakes[bottom]			
			max_index = 0        
			for (i=bottom-1; i>=0;i++) {
			if (pancakes[max_index]<pancakes[i])
				max_index=i;
			}
			
			if (index != bottom)  {   
					if (index != 0)  {  /*  If the biggest pancake of the substack
                                           is not on top, move it to the top...  */
						System.out.print( (index+1) + " ");
						flipThem(pancakes, index);
					}
                   /*  ... then we flip to get the (current) biggest one to the bottom.  */
					System.out.print( (bottom+1) + " ");
					flipThem(pancakes, bottom);  
                        
            }  /*  end of constructing the new stack  */

        }  /*  done processing the whole stack  */

	/*  We're done, so print out a "0".  */
        System.out.println("0");
        System.out.println();

	}  /*  end of "processStack" procedure  */
   
	//  A "helper" routine to flip a portion of an array, 
	//  from the index 0 up to (and including) the index "last".  
	public static void flipThem (int pancakes[], int max_index) {
		int[] temp = new int[MAX_SIZE];
		//  Copy out the portion we want (into the order we desire).
		for (int i=0; i<=max_index; i++) {
			temp[i] = pancakes[max_index-i];
		}
		//  Insert the portion back into the original array.  
        for (int i = 0; i <= last; i++)  {
           pancakes[i] = temp[i];
        }
	}
}  /*  end of "Pancakes" program  */

