package other;

import java.util.Random;

public class Collector
{
    // instance variables
    Random rand;
    int[] id;
    boolean[] results;

    // constructor
    public Collector()
    {
        System.out.println("Collector averages");
        System.out.println();
        average(6);
        average(52);
        average(365);
        average(366);
    }

    // average
    public void average(int n)
    {
        // 1000 simulations
        int total = 0;
        for(int i = 0; i < 1000; i++)
        {
            boolean running = true;
            int count = 0;
            results = new boolean[n+2];
            id = new int[n+2];
            int number;
            rand = new Random();
            for(int j = 0; j < n+2; j++)
            {
                results[j] = false;
                id[j] = j;
            }
            results[0] = true;
            results[n+1] = true;
            while(running)
            {
                number = 1 + rand.nextInt(n);
                count++;
                results[number] = true;
                if(results[number+1]) union(number, number+1);
                if(results[number-1]) union(number, number-1);
                if(gotall()) running = false;
            }
            total += count;
        }
        System.out.println("N = " + n + "; average until all collected = " + (total/1000) + ". N*Hn = " + nhn(n));
    }

    // got all
    public boolean gotall()
    {
        return find(0) == find(id.length-1);
    }

    // find
    public int find(int p)
    {
        return id[p];
    }

    // union
    public void union(int p, int q)
    {
        int pid = find(p);
        int qid = find(q);
        if(pid == qid) return;
        for(int i = 0; i< id.length; i++) if(id[i] == pid) id[i] = qid;
    }

    public int nhn(int n)
    {
        double result = 0.;
        for(int i = 1; i <= n; i++)
        {
            result += 1./i;
        }
        result *= n;
        return (int)result;
    }

    // main
    public static void main(String[] args)
    {
        new Collector();
    }
}
