import java.util.HashMap;

public class Problem4_SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            if (prefixSum.containsKey(currentSum - k)) {
                count += prefixSum.get(currentSum - k);
            }

            prefixSum.put(
                currentSum,
                prefixSum.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }
}