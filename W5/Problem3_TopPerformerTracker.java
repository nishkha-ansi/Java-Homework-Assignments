public class Problem3_TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {

        int min = scores[0];
        int max = scores[0];

        for (int score : scores) {

            if (score < min) {
                min = score;
            }

            if (score > max) {
                max = score;
            }
        }

        int spread = max - min;

        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {

        int[] scores = {45, 82, 79, 90, 33, 60, 91};

        System.out.println(findMinMaxSpread(scores));
    }
}