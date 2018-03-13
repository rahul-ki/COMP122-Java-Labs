//  SHOW the frequency of each word in the input file or files
// (USING collections)

import java.util.*;
import java.io.*;

public class FileWordCount{
	public static void main (String args[]) {

		//  Check if the user has supplied a filename.
		if (args.length == 0) {
			System.out.println("Oops! Please supply a filename to the program!");
			System.exit(1);
		} else {
			for (int i =0; i<args.length; i++){
				System.out.println(printWordsFrequency(args[i]));
			}
		}
	}
	
	public static String printWordsFrequency(String fileName) {
		HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
		String line;
		File in = new File(fileName);	// Store file object
		Scanner infile;
		
		try {
			infile = new Scanner(in); 	// open file
			
			while(infile.hasNextLine()){
				line = infile.nextLine();
				// should be able to increase frequency regardless of "the" or "THE"
				line = line.toLowerCase();	
				String[] wordList = line.split("\\s");
				for(String w : wordList){
					//if no words in file:
					if ( w != null && !w.isEmpty() )  {
						//if w already occurred
						if(wordCount.containsKey(w))
							wordCount.put(w,(wordCount.get(w)+1));
						//if not
						else
							wordCount.put(w,1);
					}
				}
			}
		}
		catch (FileNotFoundException e) { System.out.println(e); }
		
		return wordCount.toString();
	}
}
