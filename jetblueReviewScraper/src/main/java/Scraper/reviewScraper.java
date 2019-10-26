/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import org.jsoup.select.Elements;

/**
 *
 * @author drruh
 */
public class reviewScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Document document;
        try {
            
            document = Jsoup.connect("https://www.airlinequality.com/airline-reviews/jetblue-airways/").get();
            
            Elements reviews = document.select(".rating-10 rating-large:contains($)");
            String title = document.title();
            System.out.println(title);
            
            for (int i = 0; i < reviews.size(); i++) {
                System.out.println(reviews.get(i).text());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}