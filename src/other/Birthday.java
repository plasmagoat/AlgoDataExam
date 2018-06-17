package other;

import java.util.Random;

public class Birthday
{
    // instance variables
    Random rand;

    // constructor
    public Birthday()
    {
        System.out.println("Birthday averages");
        System.out.println();
        average(6);
        average(52);
        average(365);
        average(366);
    }

    // experiment
    public void average(int n)
    {
        // 1000 simulations
        int total = 0;
        for(int i = 0; i < 1000; i++)
        {
            boolean running = true;
            int count = 0;
            int[] results = new int[n+1];
            int number;
            rand = new Random();
            for(int j = 0; j < results.length; j++)
            {
                results[j] = 0;
            }

            while(running)
            {
                number = 1 + rand.nextInt(n);
                count++;
                if(results[number] != 0) running = false;
                results[number]++;
            }

            total += count;
        }
        System.out.println("N = " + n + "; avarage until a repeat = " + (total/1000) + ". Sqrt(PI*N/2) = " + (int)(Math.sqrt(Math.PI*n/2)));
    }

    // main
    public static void main(String[] args)
    {
        new Birthday();
    }
}
