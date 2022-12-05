public class LinearlyPrint {

    public static void main(String[] args) {
        System.out.println("Working with basic recursion programs !!");
        // print name 5 times
        System.out.println("print name 5 times !!");
        printName(0);

        // print linearly from 1 to N
        System.out.println("print linearly from 1 to N !!");
        print1toN(1, 8);

        // print from N to 1
        System.out.println("print from N to 1 !!");
        printNto1(1,8);

        // print linearly from 1 to N but using backtracking
        // print from N to 1 but using backtracking

    }

    public static void printName(int count) {

        //base condition
        if (count > 5) return;

        System.out.println("Ujjwal !!");
        count++;
        printName(count);
    }

    public static void print1toN(int i, int N){

        // base case
        if (i > N) return;

        System.out.println(i);
        i++;
        print1toN(i, N);
    }

    public static void printNto1(int i, int N){

        // base case
        if (i > N) return;

        i++;
        printNto1(i, N);

        System.out.println(i-1);

    }
}
