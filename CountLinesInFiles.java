import java.io.*;
import java.util.*;

public class CountLinesInFiles {
    public static void main(String[] args) {
        String fileName, line;
        File in;		//File object that represents fileName/path-name.
        Scanner input;	// Object to read from the file/ OPEN THE FILE.
        int num_lines;
        int total_num = 0;
        
        for (int i = 0; i<args.length; i++) {
            try {
				fileName = args[i];
				in = new File(fileName);
				num_lines=0;
                input = new Scanner(in);        //PROBLEMATIC STATEMENT
            
				while(input.hasNextLine()){
                    line = input.nextLine();
                    num_lines++;
                    System.out.println(line);
                }
 
				System.out.println("File " + fileName + "has " + num_lines + " lines in it.\n");
                total_num+=num_lines;
            }
			
            catch (FileNotFoundException e){ 
				System.out.println(e);
			}
            catch (ArrayIndexOutOfBoundsException e) { 
				System.out.println("OOPS NO FILE NAME GIVEN"); 
			}
        }
    }
}