package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	public static int ratingLength = " Rating: ".length() + 1;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\ellix\\Downloads\\Ratings.txt");
		Scanner input = new Scanner(file);
		
		String rating;
		double totalRating = 0; 
		int totReviewers = 0; 
		List <String> list = new ArrayList <String>(); 
		
		while (input.hasNext()) {
			list.add(input.nextLine());
		}
		for (int i = 0; i < list.size(); i++) { 
			if (list.get(i).contains ("Rating: ") && list.get(i).contains("-")) {
				//System.out.println(line.substring(ratingLength));
				rating = list.get(i).substring(ratingLength, list.get(i).indexOf("-"));
				if (rating.contains("/")){
					int thisReviewers = reviewers (rating, list.get(i));
					totReviewers = thisReviewers + totReviewers;
					totalRating = toStar (rating) * thisReviewers + totalRating;
				}
				else if (rating.contains("%")) {
					int thisReviewers = reviewers (rating, list.get(i));
					totalRating = Double.parseDouble(rating.substring(0, rating.indexOf("%")))/100 * 5 * thisReviewers + totalRating;
					totReviewers = thisReviewers + totReviewers;
				}
				else {
					int thisReviewers = reviewers (rating, list.get(i));
					totalRating = Double.parseDouble(rating) * thisReviewers + totalRating;
					totReviewers = thisReviewers + totReviewers;
				}
			}
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
