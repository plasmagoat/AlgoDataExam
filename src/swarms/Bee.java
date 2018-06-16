package swarms;

public class Bee {
    // class variables
    private static int beenumber = 0;

    // instance variables
    private int beeid;
    private double x, y;
    private double xparticlemax, yparticlemax, zparticlemax, xglobalmax, yglobalmax;
    private double vx, vy, v, vmax;
    private double inertia, rhoparticle, rhoglobal;
    private boolean fuzzy;
    private Bee bestbee;
    private KnowledgeExchange know;

    // constructor
    public Bee(KnowledgeExchange know, double x, double y, double vx, double vy, double vmax, double inertia, double rhoparticle, double rhoglobal, boolean fuzzy)
    {
        beenumber++;
        beeid = beenumber;
        this.know = know;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.vmax = vmax;
        this.inertia = inertia;
        this.rhoparticle = rhoparticle;
        this.rhoglobal = rhoglobal;
        this.fuzzy = fuzzy;
        xparticlemax = x;
        yparticlemax = y;
        zparticlemax = getZ();
    }

    // get x
    public double getX()
    {
        return x;
    }

    // get y
    public double getY()
    {
        return y;
    }

    // get z
    public double getZ()
    {
        return Landscape.getZ(x, y);
    }

    // get id
    public int getId()
    {
        return beeid;
    }

    // fly
    public void fly()
    {
        // bees are individual, everyone looks at everyone
        // get best bee
        bestbee = know.findBestBee();
        xglobalmax = bestbee.getX();
        yglobalmax = bestbee.getY();

        vx = inertia * vx + rhoparticle * (xparticlemax - x) + rhoglobal * (xglobalmax - x);
        vy = inertia * vy + rhoparticle * (yparticlemax - y) + rhoglobal * (yglobalmax - y);
        if(fuzzy)
        {
            vx = vx * Math.random();
            vy = vy * Math.random();
        }
        v = Math.sqrt(vx * vx + vy * vy);
        if(v > vmax)
        {
            vx = vx * vmax / v;
            vy = vy * vmax / v;
        }

        x += vx;
        y += vy;

        if(x > Landscape.xmax) x = Landscape.xmax;
        if(x < Landscape.xmin) x = Landscape.xmin;
        if(y > Landscape.ymax) y = Landscape.ymax;
        if(y < Landscape.ymin) y = Landscape.ymin;

        if(getZ() > zparticlemax)
        {
            xparticlemax = x;
            yparticlemax = y;
            zparticlemax = getZ();
        }
    }
}
