package swarms;

public class KnowledgeExchange {
    // instance variables
    private Bee[] beeswarm;
    private Bee bestbee;
    private double zbest;

    // constructor
    public KnowledgeExchange(Bee[] beeswarm)
    {
        this.beeswarm = beeswarm;
    }

    // find best bee
    public Bee findBestBee()
    {
        bestbee = beeswarm[0];
        zbest = bestbee.getZ();
        for(int i = 1; i < beeswarm.length; i++)
        {
            if(beeswarm[i].getZ() > zbest)
            {
                bestbee = beeswarm[i];
                zbest = bestbee.getZ();
            }
        }
        return bestbee;
    }
}
