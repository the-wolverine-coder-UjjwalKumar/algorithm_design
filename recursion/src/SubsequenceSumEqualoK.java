import java.util.ArrayList;
import java.util.Arrays;

public class SubsequenceSumEqualoK {
    public static void main(String[] args) {
        int k = 2;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 1));

        System.out.println("Printing All subsequence whose sum is equal to k");
        printAllSubSequenceSumEqualK(arr, k);
        System.out.println("Printing Any one subsequence whose sum is equal to k");
        printAnyOneSubSequenceSumEqualK(arr, k);
        System.out.println("Total subsequence whose sum is equal to k = "+ countAllSubsequenceSumEqualsK(arr, k));
    }

    private static void printAllSubSequenceSumEqualK(ArrayList<Integer> arr, int k) {
        subsequenceSumKhelper(0, arr, new ArrayList<Integer>(), k);
    }

    private static void subsequenceSumKhelper(int i, ArrayList<Integer> arr, ArrayList<Integer> ans, int k) {

        if (i >= arr.size()) {
            if (k == 0) {
                System.out.println(ans.toString());
            }
            return;
        }

        if (k == 0) {
            System.out.println(ans.toString());
            return;
        }

        // pick
        if (k >= arr.get(i)) {
            ans.add(arr.get(i));
            subsequenceSumKhelper(i + 1, arr, ans, k - arr.get(i));
            ans.remove(arr.get(i));
        }

        // not pick
        subsequenceSumKhelper(i + 1, arr, ans, k);

    }

    private static void printAnyOneSubSequenceSumEqualK(ArrayList<Integer> arr, int k){
        subsequenceAnyOneSubsequenceSumKhelper(0, arr, new ArrayList<Integer>(), k);
    }

    private static boolean subsequenceAnyOneSubsequenceSumKhelper(int i, ArrayList<Integer> arr, ArrayList<Integer> ans, int k) {

        if (i == arr.size()) {
            if (k == 0) {
                System.out.println(ans.toString());
                return true;
            }
            return false;
        }

        // pick
        if(k >= arr.get(i)) {
            ans.add(arr.get(i));
            if (subsequenceAnyOneSubsequenceSumKhelper(i + 1, arr, ans, k - arr.get(i))) return true;
        }

        ans.remove(arr.get(i));

        // not pick
        if (subsequenceAnyOneSubsequenceSumKhelper(i + 1, arr, ans, k)) return true;

        return false;
    }

    private static int countAllSubsequenceSumEqualsK(ArrayList<Integer> arr, int k){
        return countHelper(0, arr, new ArrayList<Integer>(), k);
    }

    private static int countHelper(int i, ArrayList<Integer> arr, ArrayList<Integer> ans, int k) {

        if (i == arr.size()) {
            if (k == 0) {
                return 1;
            }

            return 0;
        }

        ans.add(arr.get(i));
        int left = countHelper(i + 1, arr, ans, k - arr.get(i));
        ans.remove(arr.get(i));
        int right = countHelper(i + 1, arr, ans, k);

        return left + right;
    }

}
