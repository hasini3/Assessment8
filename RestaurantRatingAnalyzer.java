import java.util.*;
public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of restaurants: ");
        int numRestaurants = sc.nextInt();
        List<RestaurantRating> restaurantRatings = new ArrayList<>();
        System.out.println("Enter the ratings for each restaurant:");
        for (int i = 0; i < numRestaurants; i++)
        {
            System.out.print("Rating for restaurant " + (i + 1) + ": ");
            int rating = scanner.nextInt();
            restaurantRatings.add(new RestaurantRating("Restaurant " + (i + 1), rating));
        }
        sc.close();
        int[][] ratingRanges = {{1, 5}, {6, 10}};
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> totalRatingMap = new HashMap<>();
        for (int[] range : ratingRanges)
        {
            String key = range[0] + "-" + range[1];
            countMap.put(key, 0);
            totalRatingMap.put(key, 0);
        }
        for (RestaurantRating rating : restaurantRatings) {
            for (int[] range : ratingRanges) {
                if (rating.rating >= range[0] && rating.rating <= range[1]) {
                    String key = range[0] + "-" + range[1];
                    countMap.put(key, countMap.get(key) + 1);
                    totalRatingMap.put(key, totalRatingMap.get(key) + rating.rating);
                    break;
                }
            }
        }
        System.out.println("Number of restaurants rated within specific ranges and their average ratings:");
        for (int[] range : ratingRanges) {
            String key = range[0] + "-" + range[1];
            int count = countMap.get(key);
            double averageRating = count == 0 ? 0 : (double) totalRatingMap.get(key) / count;
            System.out.printf("%d-%d: Restaurants %d, Average %.2f%n", range[0], range[1], count, averageRating);
        }
    }
}
class RestaurantRating {
    String name;
    int rating;
    public RestaurantRating(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
}
