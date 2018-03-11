/* 
Using the FileReader and  BufferedReader classes 
to read and print contents of a text file.  
 */
 
import java.io.*;

public class ReadFileAndSplit {

	public static void main (String args[]) {

		String fileName = args[0];	//only one file is allowed
		String line;
		FileReader reader;
		BufferedReader breader;
		
      
		try  {
		  
			reader = new FileReader(fileName);
			breader = new BufferedReader(reader);
			while ( (line = breader.readLine()) != null)   {
				String[] words = line.split("\\s");
				for (String w : words) {
					System.out.println(w);
				}
			}

			breader.close();  //  Be certain to close the file when done.  
		}
		catch (FileNotFoundException fnfe)  {
			System.out.println("Unable to open file " + fileName);
		}
		catch (IOException e)  {
			System.out.println("Error reading file " + fileName);
		}

	}     

}

