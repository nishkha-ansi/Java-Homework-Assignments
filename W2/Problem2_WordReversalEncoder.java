public class Problem2_WordReversalEncoder {

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word);
            result.append(reversed.reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String sentence = "hello club";

        System.out.println(reverseEachWord(sentence));
    }
}