package com.company;

public class BubbleSort {

    public BubbleSort(){

    }

    public static void bubbleSort(Comparable[] a){
        int i,j;
        int n = a.length;
        for (i = 0; i < n-1; i++) {
            for (j = 0; j < n-i-1; j++) {
                if(!less(a[j], a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

    private static void show(Comparable[] a)
    { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
    }
    public static boolean isSorted(Comparable[] a)
    { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }



}
