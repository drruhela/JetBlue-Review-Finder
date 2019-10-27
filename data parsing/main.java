package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class main {
	public static void main(String[] args) throws Exception {
		File file = new File ("C:\\Users\\ellix\\eclipse-workspace\\jetblue yhack 2019\\TwitterPosts.txt");
		List <ArrayList <String>> list = popularWords.run(file);
		
		System.out.println("finished popularWords.run");
		
		ArrayList <Double> order = new ArrayList <Double>(); 
		String[] top = new String[10]; 
		
				
		for (int i = 0; i < list.size(); i++) {
			order.add(Double.parseDouble(list.get(i).get(1))); 
			
		}
		
		Collections.sort(order);
		
		System.out.println("finished sorting");
		
		int count = 0; 
		for (int i = order.size()- 1; i >= order.size() - 10; i --) {
			for (int j = 0; j < list.size(); j++) {
				if (Double.parseDouble(list.get(j).get(1)) == order.get(i)) {
					System.out.println(list.get(j).get(0));
					top [count] = list.get(j).get(0); 
					count++; 
					j = list.size();
				}
			}
		}
		System.out.println(rate (top)); 
		
		
	}
	
	public static double rate(String [] top ) throws Exception {
		double total = 0; 
		double count = 0; 
		double rating;
		for (int i = 0; i < top.length; i++) {
			rating = wordRating.run(top[i]);
			if (rating != -1) {
				total = total + rating; 
				count ++; 
			}
		}
		total = total / count; 
		return total/4*5; 
	}
}
