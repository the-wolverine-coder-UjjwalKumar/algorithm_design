import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumLeetcode39 {
    public static void main(String[] args) {
        int k = 2;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 1));

        System.out.println("Printing All subsequence whose sum is equal to k");

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // here ds is passed by reference and changes
                // will affect the original one hence make new one and add to ans
                //ans.add(ds); not this.
            }
            return;
        }

        //when picked
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }

        // when not picked
        findCombinations(ind + 1, arr, target, ans, ds);
        return;
    }

}
