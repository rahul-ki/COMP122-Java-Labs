/*
Lexical Diversity of a portion of text T:
	lex(T) = (number of distinct words in T)/(total number of words in T)
	
CALCULATE LEX(T) for input file or files.

Just to practise, I am working with SETS collection
*/
import java.io.*;
import java.util.*;

public class LexicalDiversity {
	
	protected String fileName;
	protected HashMap<String,Integer> wordCount;  //  list of (word, count) pairs
	
	public static void main (String args[]) {

		//  Check if the user has supplied a filename.
		if (args.length == 0) {
			System.out.println("Oops! Please supply a filename to the program!");
			System.exit(1);
		} else {
			for (int i =0; i<args.length; i++){
				System.out.println(lex(args[i]));
			}
		}
	}
	public static double lex(String fileName) {
		Set<String> s = new HashSet<String>();
		String line;
		File in = new File(fileName);	// Store file object
		Scanner infile;
		double total_count=0;	//total word count
		double distinct_count=0; // distinct words in a file
		
		try {
			infile = new Scanner(in); 	// open file
			
			while(infile.hasNextLine()){
				line = infile.nextLine();
				// should be able to increase frequency regardless of "the" or "THE"
				line = line.toLowerCase();	
				String[] wordList = line.split("\\s");
				total_count+=(double)wordList.length;
				for(String word : wordList){
					//if no words in file:
						s.add(word);
				}
			}
			distinct_count = s.size();
		}
		catch (FileNotFoundException e) { System.out.println(e); }
		
		if (total_count==0 || distinct_count==0)
			return 0;
		else
			return (distinct_count/total_count);
	}
}
