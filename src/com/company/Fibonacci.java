package com.company;

/**
 * Created by David on 31 Jan 2018.
 */
public class Fibonacci {

    public Fibonacci(int selection, int limit){


        long time = System.currentTimeMillis();
        System.out.println(time);

        if(selection == 1){
            System.out.println("Fibonacci number " + limit + " = " + fibo1(limit));
            System.out.println("Time: " + (System.currentTimeMillis() - time));
            System.out.println();
        }
        if(selection == 2){
            System.out.println("Fibonacci number " + limit + " = " + fibo2(limit));
            System.out.println("Time: " + (System.currentTimeMillis() - time));
        }
        if(selection == 3){
            System.out.println("Fibonacci number " + limit + " = " + fibo3(limit));
            System.out.println("Time: " + (System.currentTimeMillis() - time));
        }


    }

    //recursive
    public int fibo1(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        else {
            return fibo1(n-1) + fibo1(n-2);
        }

    }

    //array
    public int fibo2(int n){
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n-1];
    }

    //single numbers
    public int fibo3(int n){
        int f = -1;
        int old = 1;
        int oldold = 1;
        for (int i = 2; i < n; i++) {
            f = old + oldold;
            oldold = old;
            old = f;
        }
        return  f;
    }
}
