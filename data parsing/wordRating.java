package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class wordRating {
	public static File reviews = new File ("C:\\Users\\ellix\\eclipse-workspace\\jetblue yhack 2019\\MovieReviews.txt");
	public static double run(String word) throws Exception {
		double time = wordCount(word);
		double count2 = wordTotalScore(word);
        double average = -1;
        if (time != 0) {
            average = (count2 / time);
            //System.out.println(word.trim() + "'s average rating is " + average + "\n");
        }
        return average; 
	}
	
	public static int wordCount(String word) throws Exception {
        String[] rate = readFile();
        int count = 0, time = 0;

        //counts the accumulated ratings of a word and the number of times it appears. 
        word = " " + word + " ";
        for (int i = 0; i < rate.length; i++) {
            if (rate[i] != null && rate[i].contains(word)) {
                StringTokenizer token = new StringTokenizer(rate[i], "***");
                while (token.hasMoreTokens()) {
                    if (token.nextToken().toLowerCase().contains(word)) {
                        count++;
                    }
                }
                time = count + time;
            }
            count = 0;
        }

        //System.out.println("the word " + word.trim() + " appears for " + time + " times");
        return time;
    }
	
	public static String[] readFile() throws Exception {
        //sorts all reviews by rating
        String[] sentence = readTxt();
        String[] rate = new String[5];
        int rateSub;
        for (int i = 0; i < sentence.length; i++) {
            rateSub = Integer.parseInt(Character.toString(sentence[i].charAt(0)));
            rate[rateSub] = sentence[i].toLowerCase() + "***" + rate[rateSub];
        }
        return rate;
    }
	
	public static String[] readTxt() throws Exception {
        //transfering data from txt file to array
        Scanner lines = new Scanner(reviews);
        int lineCount = 0;
        String[] sentence;

        while (lines.hasNext()) {
            lineCount++;
            lines.nextLine();
        }
        
        lines = new Scanner(reviews);

        sentence = new String[lineCount];
        lineCount = 0;
        while (lines.hasNext()) {
            sentence[lineCount] = (lines.nextLine()).toLowerCase().trim(); //added .trim()
            lineCount++;
        }
      
        lines.close(); 
        return sentence;
    }

	public static int wordTotalScore(String word) throws Exception {
        String[] rate = readFile();
        int count = 0, time = 0, count2 = 0;
        
    //counts the accumulated ratings of a word and the number of times it appears. 
        word = " " + word + " ";
        for (int i = 0; i < rate.length; i++) {
            if (rate[i] != null && rate[i].contains(word)) {
                StringTokenizer token = new StringTokenizer(rate[i], "***");
                while (token.hasMoreTokens()) {
                    if (token.nextToken().toLowerCase().contains(word)) {
                        count++;
                    }
                }
                time = count + time;
                count2 = i * count + count2;
            }
            count = 0;
        }
        //System.out.println("count2: " + count2);
        return count2;
    }
}
