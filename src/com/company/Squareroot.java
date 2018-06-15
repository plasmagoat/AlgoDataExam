package com.company;

public class Squareroot {


    //step search
    // O(2^precision) O(x)
    public double root1(double x, double precision){
        boolean running = true;
        double min = 0;
        while (running){
            if(min*min >= x){
                running = false;
            } else {
                min += precision;
            }
        }
        return min;
    }

    //binary search
    // O(log(precision)) O(log(x))
    public double root2(double x, double precision){
        boolean running = true;
        double min = (x<=1) ? 0 : 1;
        double max = (x>=1) ? 1 : x;
        double result = (min + max)/2.;
        while (running){
            if(max - min < precision){
                running = false;
            } else {
                if(result * result > x){
                    max = result;
                } else {
                    min = result;
                }
            }
            result = (min + max)/2.;
        }
        return result;
    }

}
