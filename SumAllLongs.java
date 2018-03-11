/*
A class that demonstrates how to sum all of the
longs from as many text files the user inputs.   

If a line doesn't have a Long, then move to next line!
*/
 
import java.io.*;  //  import Exception error
import java.util.*;

public class SumLongs {

   public static void main (String args[]) {
		long l;  
		long total = 0;  

		for (int i=0; i<args.length; i++){
			try  {
				String fileName = args[i];
				File in = new File(fileName);  //  create File object
				Scanner infile = new Scanner(in);  //  Try to open the file.

				while ( infile.hasNextLine() )  {
					String line = infile.nextLine();
					
					try {
						l = Long.parseLong(line);
						total += l;
					}
					catch (NumberFormatException e) {
						System.out.println("Found something that isn't a long!");
					}
				}

				System.out.println("Sum of all longs found in file = " + total);
			}
			catch (ArrayIndexOutOfBoundsException e)  {
				System.out.println("\n  You need to supply a filename to the program!\n");
			}
			catch (FileNotFoundException e)  {
				System.out.println("\n  The filename you entered wasn't found.\n");  
			}
		}
   }
}				