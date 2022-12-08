import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        reverseArray(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
        reverseArray2(0, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int i, int j, int[] arr){
        //base condition
        if(i>=j) return;

        swap(i, j, arr);
        reverseArray(i+1, j-1, arr);
    }

    public static void reverseArray2(int i, int[] arr){
        if(i > arr.length / 2) return;

        swap(i, arr.length-i-1, arr);
        reverseArray2(i+1, arr);
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
}
