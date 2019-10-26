package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class starRating {
	public static int ratingLength = " Rating: ".length() + 1;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\ellix\\Downloads\\Ratings.txt");
		Scanner in = new Scanner(file);
		
		String rating;
		String input; 
		double totalRating = 0; 
		int totReviewers = 0; 
		List <String> list = new ArrayList <String>(); 
		
		while (in.hasNext()) {
			input = in.nextLine(); 
			if (input.contains ("Rating: ") && input.contains("-")) {
				//System.out.println(line.substring(ratingLength));
				rating = input.substring(ratingLength, input.indexOf("-"));
				if (rating.contains("/")){
					int thisReviewers = reviewers (rating, input);
					totReviewers = thisReviewers + totReviewers;
					totalRating = toStar (rating) * thisReviewers + totalRating;
				}
				else if (rating.contains("%")) {
					int thisReviewers = reviewers (rating, input);
					totalRating = Double.parseDouble(rating.substring(0, rating.indexOf("%")))/100 * 5 * thisReviewers + totalRating;
					totReviewers = thisReviewers + totReviewers;
				}
				else {
					int thisReviewers = reviewers (rating, input);
					totalRating = Double.parseDouble(rating) * thisReviewers + totalRating;
					totReviewers = thisReviewers + totReviewers;
				}
			}
			
		}
		in.close(); 
		
		for (int i = 0; i < list.size(); i++) { 
			
		}
		System.out.println("total rating " + totalRating + " total reviewers " + totReviewers);
		double averageRating = (totalRating/totReviewers); 
		System.out.println(String.format("%.2f",averageRating));

	}
	
	public static double toStar(String rating) {
		int slashLoc = rating.indexOf("/");
		double numer = Double.parseDouble(rating.substring(0, slashLoc));
		double denom = Double.parseDouble(rating.substring(slashLoc + 1));
		return numer/denom * 5; 
	}
	
	public static int reviewers(String rating, String line) {
		line = line.substring(rating.length() + 1 + ratingLength); 
		if (line.contains(",")) {
			line = line.substring(0, line.indexOf(",")) + line.substring(line.indexOf(",") + 1);
		}
		
		if (line.contains("reviews")) {
			return Integer.parseInt(line.substring(0, line.indexOf(" reviews")).trim());
		}
		else if (line.contains ("votes")) {
			return Integer.parseInt(line.substring(0, line.indexOf(" votes")).trim());
		}
		else {
			return 1; 
		}
		
	}
}
