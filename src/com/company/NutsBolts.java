package com.company;

public class NutsBolts {

    private int[] nuts = {2, 6, 1, 7, 10, 9, 5, 8, 3, 4};
    private int[] bolts = {9, 8, 10, 3, 1, 4, 7, 5, 6, 2};
    private int pivotindex;

    public NutsBolts(){
        System.out.println("Nuts and Bolts!");
        System.out.println("Nuts : ");
        printarray(nuts);
        System.out.println("\nBolts : ");
        printarray(bolts);
        findpairs(nuts, bolts, 0, nuts.length-1);
        System.out.println("Sorted");
        System.out.println("Nuts : ");
        printarray(nuts);
        System.out.println("\nBolts : ");
        printarray(bolts);

    }

    public void findpairs(int[] nuts, int[] bolts, int firstindex, int lastindex){
        if (firstindex < lastindex){
            // take first bolt
            // use it to find matching nut and split nuts in smaller and larger
            // use matching nut to split bolts in larger and smaller
            // one pair is then in place and the rest is divided in smaller and larger
            // repeat for two remaining parts.
            pivotindex = split(nuts, firstindex, lastindex, bolts[firstindex]);
            split(bolts, firstindex, lastindex, nuts[pivotindex]);
            findpairs(nuts, bolts, firstindex, pivotindex-1);
            findpairs(nuts, bolts, pivotindex+1, lastindex);
        }
    }

    public int split(int[] a, int firstindex, int lastindex, int pivotvalue){
        int location = firstindex;
        int swap;
        for (int i = firstindex; i < lastindex; i++) {
            if(a[i] < pivotvalue){
                swap = a[i];
                a[i] = a[location];
                a[location] = swap;
                location++;
            } else {
                if(a[i] == pivotvalue){
                    swap = a[i];
                    a[i] = a[lastindex];
                    a[lastindex] = swap;
                    i--;
                }
            }
        }
        swap = a[location];
        a[location] = a[lastindex];
        a[lastindex] = swap;
        return location;
    }

    public  void printarray(int[] x){
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }

}
