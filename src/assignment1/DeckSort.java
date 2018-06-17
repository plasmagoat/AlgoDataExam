package com.company;

import java.util.Random;

public class DeckSort {

    //SPADES;HEARTS;CLUBS;DIAMONDS
    //♠♠♠♠♠;♥♥♥♥♥;♣♣♣♣♣;♦♦♦♦♦♦

    DeckSort(){

        Card[] cl = new Card[52];
        cl[0] = new Card(4, Card.SUIT.DIAMOND);
        cl[1] = new Card(1, Card.SUIT.DIAMOND);
        cl[2] = new Card(2, Card.SUIT.DIAMOND);
        cl[3] = new Card(3, Card.SUIT.DIAMOND);
        cl[4] = new Card(5, Card.SUIT.DIAMOND);
        cl[5] = new Card(6, Card.SUIT.DIAMOND);
        cl[6] = new Card(7, Card.SUIT.DIAMOND);
        cl[7] = new Card(8, Card.SUIT.DIAMOND);
        cl[8] = new Card(9, Card.SUIT.DIAMOND);
        cl[9] = new Card(10, Card.SUIT.DIAMOND);
        cl[10] = new Card(11, Card.SUIT.DIAMOND);
        cl[11] = new Card(12, Card.SUIT.DIAMOND);
        cl[12] = new Card(13, Card.SUIT.DIAMOND);


        cl[13] = new Card(4, Card.SUIT.SPADE);
        cl[14] = new Card(1, Card.SUIT.SPADE);
        cl[15] = new Card(2, Card.SUIT.SPADE);
        cl[16] = new Card(3, Card.SUIT.SPADE);
        cl[17] = new Card(5, Card.SUIT.SPADE);
        cl[18] = new Card(6, Card.SUIT.SPADE);
        cl[19] = new Card(7, Card.SUIT.SPADE);
        cl[20] = new Card(8, Card.SUIT.SPADE);
        cl[21] = new Card(9, Card.SUIT.SPADE);
        cl[22] = new Card(10, Card.SUIT.SPADE);
        cl[23] = new Card(11, Card.SUIT.SPADE);
        cl[24] = new Card(12, Card.SUIT.SPADE);
        cl[25] = new Card(13, Card.SUIT.SPADE);

        cl[26] = new Card(4, Card.SUIT.CLUB);
        cl[27] = new Card(1, Card.SUIT.CLUB);
        cl[28] = new Card(2, Card.SUIT.CLUB);
        cl[29] = new Card(3, Card.SUIT.CLUB);
        cl[30] = new Card(5, Card.SUIT.CLUB);
        cl[31] = new Card(6, Card.SUIT.CLUB);
        cl[32] = new Card(7, Card.SUIT.CLUB);
        cl[33] = new Card(8, Card.SUIT.CLUB);
        cl[34] = new Card(9, Card.SUIT.CLUB);
        cl[35] = new Card(10, Card.SUIT.CLUB);
        cl[36] = new Card(11, Card.SUIT.CLUB);
        cl[37] = new Card(12, Card.SUIT.CLUB);
        cl[38] = new Card(13, Card.SUIT.CLUB);

        cl[39] = new Card(4, Card.SUIT.HEART);
        cl[40] = new Card(1, Card.SUIT.HEART);
        cl[41] = new Card(2, Card.SUIT.HEART);
        cl[42] = new Card(3, Card.SUIT.HEART);
        cl[43] = new Card(5, Card.SUIT.HEART);
        cl[44] = new Card(6, Card.SUIT.HEART);
        cl[45] = new Card(7, Card.SUIT.HEART);
        cl[46] = new Card(8, Card.SUIT.HEART);
        cl[47] = new Card(9, Card.SUIT.HEART);
        cl[48] = new Card(10, Card.SUIT.HEART);
        cl[49] = new Card(11, Card.SUIT.HEART);
        cl[50] = new Card(12, Card.SUIT.HEART);
        cl[51] = new Card(13, Card.SUIT.HEART);



        shuffleArray(cl);
        int count = 0;
        for (Card c: cl) {
            System.out.print(c.showCard()+"\t");
            count++;
            if(count == 13){
                count = 0;
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Is sorted: " + isSorted(cl));

        bubbleSort(cl);
        //shellSort(cl);
        //insesrtionSort(cl);
        //selectionSort(cl);
        int count2 = 0;
        for (Card c: cl) {
            System.out.print(c.showCard()+"\t");
            count2++;
            if(count2 == 13){
                count2 = 0;
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Is sorted: " + isSorted(cl));
    }



    public static void shellSort(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        { // h-sort the array.
            for (int i = h; i < N; i++)
            { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
        }
    }

    public static void selectionSort(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++)
        { // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of minimal entr.
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static void insesrtionSort(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length;
        for (int i = 1; i < N; i++)
        { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

    public static void bubbleSort(Comparable[] a){
        int i,j;
        int n = a.length;
        for (i = 0; i < n-1; i++) {
            for (j = 0; j < n-i-1; j++) {
                if(a[j].compareTo(a[j+1]) > 0){
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

    private void shuffleArray(Card[] array)
    {
        int index;
        Card temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

}
