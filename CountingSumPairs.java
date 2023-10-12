import java.util.*;

class CountingSumPairs {
    public static void main(String[] args) {
        List<Integer> sampleList1 = new ArrayList<Integer>();
        sampleList1.add(3);
        sampleList1.add(4);
        sampleList1.add(5);
        sampleList1.add(6);

        List<Integer> sampleList2 = new ArrayList<Integer>();
        sampleList2.add(0);
        sampleList2.add(15);
        sampleList2.add(32);
        sampleList2.add(2000);
        sampleList2.add(15000);

        List<Integer> sampleList3 = new ArrayList<Integer>();
        sampleList3.add(1);
        sampleList3.add(1);
        sampleList3.add(10);
        sampleList3.add(32);
        sampleList3.add(41);


        int sample1Output = twoSumUniquePairs(sampleList1, 1);
        System.out.println(sample1Output);

        int sample2Output = twoSumUniquePairs(sampleList2, 15);
        System.out.println(sample2Output);

        int sample3Output = twoSumUniquePairs(sampleList3, 42);
        System.out.println(sample3Output);
    }

    public static int twoSumUniquePairs(List<Integer> nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> complement = new HashSet<>();
        int ans = 0;
        for (Integer num : nums) {
          // (num, target - num) is a pair that sums to the target
            if (complement.contains(target - num) && !seen.contains(num)) {
                ans++;
              // mark num and target - num as seen so that when we see (target - num, num) it won't be counted again
                seen.add(num);
                seen.add(target - num);
            }
            complement.add(num);
        }
        return ans;
    }
}
