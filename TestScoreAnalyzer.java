import java.util.*;
public class TestScoreAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStud = sc.nextInt();
        List<Integer> testScores = new ArrayList<>();
        System.out.println("Enter the test scores for each student:");
        for (int i = 0; i < numStud; i++) {
            System.out.print("Score for student " + (i + 1) + ": ");
            int score = sc.nextInt();
            testScores.add(score);
        }
        sc.close();
        double averageScore = calculateAverage(testScores);
        double medianScore = calculateMedian(testScores);   
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;
        for (int score : testScores)
        {
            if (score > averageScore)
            {
                aboveAverageCount++;
            } 
            else if (score == averageScore)
            {
                atAverageCount++;
            }
            else
            {
                belowAverageCount++;
            }
        }
        System.out.println("Number of students who scored:");
        System.out.println("Above the average: " + aboveAverageCount + ", Median score: " + medianScore);
        System.out.println("At the average: " + atAverageCount + ", Median score: " + medianScore);
        System.out.println("Below the average: " + belowAverageCount + ", Median score: " + medianScore);
    }
    private static double calculateAverage(List<Integer> scores) {
        int sum = 0;
        for (int score : scores)
        {
            sum += score;
        }
        return (double) sum / scores.size();
    }
    private static double calculateMedian(List<Integer> scores) {
        Collections.sort(scores);
        int size = scores.size();
        if (size % 2 == 0) {
            return (double) (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2;
        } else {
            return scores.get(size / 2);
        }
    }
}
