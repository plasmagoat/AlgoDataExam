package recursion;

import analysis.Squareroot;

public class Main {

    public static void main(String[] args) {



        //################1st lesson######################

        Fibonacci fb3 = new Fibonacci(2,20);
        Fibonacci fb = new Fibonacci(1,20);
        Fibonacci fb2 = new Fibonacci(2,20);
        //Fibonacci fb3 = new Fibonacci(3,30);
        Fibonacci fb4 = new Fibonacci(1,40);

        System.out.println(mystery(2,25));
        System.out.println(mystery(3,11));

        System.out.println("GCD: " + gcd(1111111,1234567));

        new Squareroot(2.0,3,1);



    }

    // returns a*b
    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    //Give the sequence of values of p and q that are computed when Euclid’s algorithm
    //is used to compute the greatest common divisor of 105 and 24. Extend the code
    //given on page 4 to develop a program Euclid that takes two integers from the command
    //line and computes their greatest common divisor, printing out the two arguments for
    //each call on the recursive method. Use your program to compute the greatest common
    //divisor or 1111111 and 1234567.
    public static int gcd(int p, int q) {
        System.out.println("p: " + p + ", q: " + q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

}
