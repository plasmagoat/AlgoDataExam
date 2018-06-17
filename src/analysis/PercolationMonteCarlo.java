package analysis;

import java.util.concurrent.TimeUnit;

public class PercolationMonteCarlo
{
    // instance variables - for quick-find and for black/white 0 = black and for statistics (0 and 101 not used)
    private int[] id;
    private int[] bw;
    private int[] statistics;

    // constructor
    public PercolationMonteCarlo()
    {
        init();
        montecarlo();
    }

    // init
    public void init()
    {
        id = new int[102];
        bw = new int[102];
        statistics = new int[102];
        for(int i=0; i<102; i++)
        {
            statistics[i] = 0;
        }
    }

    // montecarlo
    public void montecarlo()
    {
        long startTime = System.nanoTime();
        for(int i = 1; i <= 100; i++)
        {
            for(int j = 0; j < 1000; j++)
            {
                for(int k=0; k<102; k++)
                {
                    id[k] = k;
                    bw[k] = 0;
                }
                if(simulate(i)) statistics[i]++;
            }
        }
        System.out.println("Percolation phase transition for 10 x 10 grid");
        System.out.println();
        for(int i = 1; i<= 100; i++)
        {
            String printline = "Number of spaces : ";
            if(i < 100) printline += " ";
            if(i < 10) printline += " ";
            printline += i + "; o/oo percolation : ";
            if(statistics[i] < 1000) printline += " ";
            if(statistics[i] < 100) printline += " ";
            if(statistics[i] < 10) printline += " ";
            printline += statistics[i];
            System.out.println(printline);
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println();
        System.out.println("Expected 500 o/oo from experiments = 0,593");
        System.out.println("Nanoseconds used = " + estimatedTime);
        System.out.println("Microseconds used = " + TimeUnit.NANOSECONDS.toMicros(estimatedTime));
        System.out.println("Milliseconds used = " + TimeUnit.NANOSECONDS.toMillis(estimatedTime));
        System.out.println("Seconds used = " + TimeUnit.NANOSECONDS.toSeconds(estimatedTime));
    }

    // sim; max = maximal number of white
    public boolean simulate(int max)
    {
        int remaining = 101;
        int count;
        int randnum;
        int selected;
        {
            // stop loop when percolated
            while(!check() && remaining > 101 - max)
            {
                // choose next
                remaining--;
                selected = 0;
                count = 0;
                randnum = 1 + (int)(Math.random()*remaining);
                while(selected < randnum)
                {
                    count++;
                    if(bw[count] == 0) selected++;
                }
                // set white
                bw[count] = 1;

                // connect to white neighbours
                // 1-10 og 91-100 are connected to 0 and 101
                if(count%10 != 0)
                {
                    if(bw[count+1] == 1) union(id[count], id[count+1]);
                }
                if(count%10 != 1)
                {
                    if(bw[count-1] == 1) union(id[count], id[count-1]);
                }
                if(count < 91)
                {
                    if(bw[count+10] == 1) union(id[count], id[count+10]);
                }
                if(count > 10)
                {
                    if(bw[count-10] == 1) union(id[count], id[count-10]);
                }
                if(count < 11)
                {
                    union(id[count], id[0]);
                }
                if(count > 90)
                {
                    union(id[count], id[101]);
                }
            }
            return check();
        }
    }

    // check percolation
    public boolean check()
    {
        return find(0) == find(101);
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

    // main
    public static void main(String[] args)
    {
        new PercolationMonteCarlo();
    }
}
