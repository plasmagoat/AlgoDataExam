package com.company;

import java.util.ArrayList;
import java.util.Random;

public class CouponCollector {

    private int n;
    private ArrayList<Integer> list;
    private Random r;
    private int tries;
    private int total;
    private int runs;

    public CouponCollector(int n, int runs) {
        this.n = n;
        this.r = new Random();
        this.list = new ArrayList<>();
        this.tries = 0;
        this.total = 0;
        this.runs = runs;

        for (int i = 0; i < runs; i++) {
            generateRandom();
            this.total += this.tries;
            this.tries = 0;
            this.list = new ArrayList<>();
        }
        double approx = n * harmoicNumber(n);
        //System.out.println(approx);
        double actual = (this.total / this.runs);
        double diff = Math.abs(actual - approx)/((actual+approx)/2)*100;
        System.out.println("Runs: " + this.runs + ", Actual: " + Math.floor(actual) + ", Approximation: " + Math.floor(approx) + ", Difference: " + Math.floor(diff) + "&");
    }

    private double harmoicNumber(int x){
        if(x == 1){
            return 1.0;
        } else {
            return ( 1.0 / x ) + harmoicNumber(x - 1);
        }
    }

    private void generateRandom(){
        int rand = this.r.nextInt(n);
        //System.out.println(rand);
        while(this.list.size() < n){
            if(this.list.indexOf(rand) == -1){
                this.list.add(rand);
            }
            this.tries++;
            rand = this.r.nextInt(n);
            //System.out.println(rand);
        }
    }
}
