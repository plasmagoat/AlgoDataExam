package mergequicksort;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = {2,8,0,1,3,9,3,1,8,0};
        BubbleSort bs = new BubbleSort(arr);

        //2.3.15 Nuts and bolts. (G. J. E. Rawlins) You have a mixed pile of N nuts and N bolts
        //and need to quickly find the corresponding pairs of nuts and bolts. Each nut matches
        //exactly one bolt, and each bolt matches exactly one nut. By fitting a nut and bolt together,
        //you can see which is bigger, but it is not possible to directly compare two nuts or
        //two bolts. Give an efficient method for solving the problem.
        NutsBolts nb = new NutsBolts();

    }
}
