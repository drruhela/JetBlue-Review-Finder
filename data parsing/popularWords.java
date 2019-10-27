package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class popularWords {
	public static List <String> common = new ArrayList <String>(); 
	
	public static List <ArrayList <String>> run(File file) throws Exception {
		Scanner input = new Scanner (file);
		List <ArrayList <String>> words = new ArrayList <ArrayList <String>>();
		ArrayList <String> entry = new ArrayList<String>(); 
		commonWords(); 
		
		while (input.hasNext()) {
			String in = input.nextLine().substring(1); 
			StringTokenizer token = new StringTokenizer(in);
			while (token.hasMoreTokens()){
				String word = token.nextToken().trim().toLowerCase(); 
				boolean contains = false; 
				if (!common.contains(word)) {
					for (int i = 0; i < words.size(); i ++) {
						if (words.get(i).contains(word)){
							contains = true; 
							break; 
						}
					}
					if (contains == false) {
						double times = wordRating.wordCount(word); 
						entry = new ArrayList<String>(); 
						entry.add(word); 
						times ++; 
						entry.add(times + ""); 
						words.add(entry); 
						contains = true; 
					}
				}
				
				System.out.print(".");
			}
		}

		input.close(); 
		
		return words;
	}
	
	public static void commonWords () {
		common.add("the");
		common.add("a");
		common.add(","); 
		common.add("for");
		common.add("to");
		common.add(".");
		common.add("'s");
		common.add("i");
		common.add("and");
		common.add("!");
		common.add("all");
		common.add("one");
		common.add("is");
		common.add("that");
		common.add("of");
		common.add("this");
		common.add("have");
		common.add("or");
		common.add("what"); 
		common.add("it");
		common.add("in");
		common.add("but");
		common.add("with");
		common.add("as"); 
		common.add("an");
		common.add("its");
		common.add("you");
		common.add("be");
		common.add("on");
		common.add("...");
		common.add("by");
		common.add("has");
		common.add("have");
		common.add("are");
		common.add("at");
		common.add("from");
		common.add("his");
		common.add("about");
		
	}
}
