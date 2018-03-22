/*
NOTE - Original Question:
Use HashSet collection to find common words of two text files

What I am doing:
Use HashSet collection to find common words of ANY NUMBER OF text files.
TO DO THIS: I create a List containing HashSets.
*/

import java.util.*;
import java.io.*;

public class CommonWordFilesSet {
	
	public static void main(String[] args) {
		String line;
		File in;
		Scanner infile;
		
		
		if (args.length <=1) {
			System.out.println("Please input minimum of two files.");
			System.exit(1);
		} else {
			//Create a List of Sets, 
			//where each set has the list of unique words occurred in a file.
			ArrayList<HashSet<String>> wordList = new ArrayList<HashSet<String>>(args.length);
/* NOTE -
HashSet<String>[] wordList = new HashSet<String>[args.length];
GIVES "Generic Array Creation ERROR"
SO must initialize in a 2 step way-
EXAMPLE:
Set<Integer> numbers[] = new HashSet[3];
for (int i=0; i<numbers.length; i++) {
	numbers[i] = new HashSet<Integer>();
}
*/
			for (int fileCount = 0; fileCount<args.length; fileCount++) {
				//Because the above NOTE way doesn't work correctly, create wordSet. 
				//Add words to Set and at the end, add Set to wordList
				HashSet<String> wordSet = new HashSet<String>();

				//Add file content to the respective index of wordList.
				in = new File(args[fileCount]);
			
				try {
					// Open the file. Can be exception.
					infile = new Scanner(in); 
					
					while (infile.hasNextLine()) {
						line = infile.nextLine();
						// should be able to increase frequency regardless of "the" or "THE"
						line = line.toLowerCase();
						String[] words = line.split("[^\\p{L}0-9]+");
						
						//Add each word to HashSet of the corresponding file
						for (String word : words){
							//if no words in file then don't do anything. ELSE:
							if ( word != null && !word.isEmpty() ) 
								wordSet.add(word);
						}
					}
					wordList.add(wordSet);
				}
			
				catch (FileNotFoundException e) { System.out.println(e); }
			}
		
			// DO INTERSECTION OF ALL THE SETS!
			HashSet<String> commonWords = new HashSet<String>(wordList.get(0));
			for (HashSet<String> s : wordList) { // Use generics
				commonWords.retainAll(s);
			}
			System.out.println(commonWords);
		}
	}
}
