package swarms;

public class Swarm {
    // simulation variables
    // number of bees examples 2 - 50, typical 20
    private final int noofbees = 5;
    // number of iterations examples 200 - 1000, typical 500
    private final int noofiter = 500;
    // inertia examples 0 - 1, typical 0.1
    private final double inertia = 0.1;
    // rhoparticle examples 0 - 1, typical 0.1
    private final double rhoparticle = 0.1;
    // rhoglobal examples 0 - 1, typical 0.8
    private final double rhoglobal = 0.8;
    // vmax examples 0.001 - 0.01 * size of landscape, typical 0.002
    private final double vmax = 0.01;
    // true if bees are fuzzy
    private final boolean fuzzy = false;

    // instance variables
    private KnowledgeExchange know;
    private Bee[] beeswarm;
    private Bee bestbee;
    private double xstart, ystart, vxstart, vystart;
    private double dist, maxdist;
    private int maxdistida, maxdistidb;

    // constructor
    public Swarm()
    {
        init();
        simulate();
    }

    // initialize
    public void init()
    {
        beeswarm = new Bee[noofbees];
        know = new KnowledgeExchange(beeswarm);
        for(int i=0; i<noofbees; i++)
        {
            xstart = Landscape.xmin + (Landscape.xmax - Landscape.xmin) * Math.random();
            ystart = Landscape.ymin + (Landscape.ymax - Landscape.ymin) * Math.random();
            vxstart = (Math.random() - 0.5) * vmax;
            vystart = (Math.random() - 0.5) * vmax;
            beeswarm[i] = new Bee(know, xstart, ystart, vxstart, vystart, vmax, inertia, rhoparticle, rhoglobal, fuzzy);
        }
    }

    // simulate
    public void simulate()
    {
        // print initial situation
        bestbee = know.findBestBee();
        System.out.println("Iteration number 0. Best bee : " + bestbee.getZ() + ". Number " + bestbee.getId() + " at x = " + bestbee.getX() + "; y = " + bestbee.getY());
        for(int i = 0; i < noofiter; i++)
        {
            for(int j = 0; j < noofbees; j++)
            {
                beeswarm[j].fly();
            }
            // print result from every 10th iteration
            if((i + 1) % 10 == 0)
            {
                bestbee = know.findBestBee();
                System.out.println("Iteration number " + (i + 1) + ". Best bee : " + bestbee.getZ() + ". Number " + bestbee.getId() + " at x = " + bestbee.getX() + "; y = " + bestbee.getY());
            }
        }
        // print result from simulation
        findMaxdist();
        System.out.println("Maximum distance between bees : " + maxdist + " (bees " + maxdistida + " and " + maxdistidb + ")");
    }

    // find maximum distance between bees
    private void findMaxdist()
    {
        maxdist = 0;
        maxdistida = 0;
        maxdistidb = 0;
        for(int i = 0; i < beeswarm.length; i++)
        {
            for(int j = i + 1; j < beeswarm.length; j++)
            {
                dist = Math.sqrt((beeswarm[i].getX() - beeswarm[j].getX()) * (beeswarm[i].getX() - beeswarm[j].getX()) + (beeswarm[i].getY() - beeswarm[j].getY()) * (beeswarm[i].getY() - beeswarm[j].getY()));
                if(dist > maxdist)
                {
                    maxdist = dist;
                    maxdistida = i;
                    maxdistidb = j;
                }
            }
        }
    }


    // main
    public static void main(String[] args)
    {
        new Swarm();
    }
}
