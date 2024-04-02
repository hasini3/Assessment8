import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class BookReviews {
    String title;
    int rating;
    public BookReviews(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }
    public int getRating() {
        return rating;
    }
}
public class ReviewsAnalyzer {
    public static void main(String[] args) {
        List<BookReview> bookReviews = new ArrayList<>();
        bookReviews.add(new BookReview("Book 1", 4));
        bookReviews.add(new BookReview("Book 2", 7));
        bookReviews.add(new BookReview("Book 3", 9));
        bookReviews.add(new BookReview("Book 4", 3));
        bookReviews.add(new BookReview("Book 5", 6));
        bookReviews.add(new BookReview("Book 6", 8));
        int[] ratingRanges = {1, 5, 6, 10};
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        Map<String, Integer> sentimentCounts = new HashMap<>();
        sentimentCounts.put("Positive", 0);
        sentimentCounts.put("Neutral", 0);
        sentimentCounts.put("Negative", 0);
        for (BookReview review : bookReviews) {
            int rating = review.getRating();
            boolean isPositive = rating >= 7; 
            boolean isNeutral = rating >= 4 && rating <= 6;
            if (isPositive)
            {
                sentimentCounts.put("Positive", sentimentCounts.get("Positive") + 1);
            }
            else if (isNeutral)
           {
                sentimentCounts.put("Neutral", sentimentCounts.get("Neutral") + 1);
            } 
            else 
           {
                sentimentCounts.put("Negative", sentimentCounts.get("Negative") + 1);
            }
            for (int i = 0; i < ratingRanges.length - 1; i++) {
                int lowerBound = ratingRanges[i];
                int upperBound = ratingRanges[i + 1];
                if (rating >= lowerBound && rating <= upperBound) {
                    String range = lowerBound + "-" + upperBound;
                    ratingRangeCounts.put(range, ratingRangeCounts.getOrDefault(range, 0) + 1);
                    break;
                }
            }
        }
        System.out.println("Number of books reviewed within specified rating ranges:");
        for (Map.Entry<String, Integer> entry : ratingRangeCounts.entrySet()) 
        {
            System.out.println(entry.getKey() + " stars: " + entry.getValue());
        }

        System.out.println("\nCount of books with positive, neutral, and negative reviews:");
        for (Map.Entry<String, Integer> entry : sentimentCounts.entrySet()) 
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
