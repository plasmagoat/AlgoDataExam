package datastructure;

public class Main {

    public static void main(String[] args) {
        FlagBuckets fb = new FlagBuckets(20);
        System.out.println("Unsorted");
        fb.print();
        fb.sort();
        System.out.println("\nSorted");
        fb.print();
    }
}
