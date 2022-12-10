public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println("Nth Fibonacci Number using recursion !!");
        int n = 5;
        System.out.println(String.valueOf(n)+"th fibonacci number is  :: "+String.valueOf(nthFiboNumber(n)));
    }

    public static int nthFiboNumber(int n){
        if(n<=0) return 0;
        if(n==1) return 1;

        return nthFiboNumber(n-1) + nthFiboNumber(n-2);
    }
}
