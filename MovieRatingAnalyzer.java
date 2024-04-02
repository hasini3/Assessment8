import java.util.*;
class Movies {
    String title;
    String rating;
    double score;
    public Movies(String title, String rating, double score) {
        this.title = title;
        this.rating = rating;
        this.score = score;
    }
    public String getRating() {
        return rating;
    }
    public double getScore() {
        return score;
    }
}
public class MovieRatings {
    public static void main(String[] args) 
       {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", "PG", 4.5));
        movies.add(new Movie("Movie 2", "PG-13", 3.8));
        movies.add(new Movie("Movie 3", "R", 4.2));
        movies.add(new Movie("Movie 4", "PG", 4.0));
        movies.add(new Movie("Movie 5", "PG-13", 3.9));
        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> averageRatings = new HashMap<>();
        for (Movie movie : movies) {
            String rating = movie.getRating();
            double score = movie.getScore();
            movieCounts.put(rating, movieCounts.getOrDefault(rating, 0) + 1);
            averageRatings.put(rating, averageRatings.getOrDefault(rating, 0.0) + score);
        }
        for (String rating : averageRatings.keySet()) {
            int count = movieCounts.get(rating);
            double totalScore = averageRatings.get(rating);
            double averageRating = totalScore / count;
            averageRatings.put(rating, averageRating);
        }
        System.out.println("Movie Ratings Analysis:");
        for (String rating : movieCounts.keySet()) {
            int count = movieCounts.get(rating);
            double averageRating = averageRatings.get(rating);
            System.out.println("Rating: " + rating + ", Number of Movies: " + count + ", Average Rating: " + averageRating);
        }
    }
}
