package swarms;

public class Landscape {
    // class variables
    public static final double xmin = -2.5;
    public static final double xmax = 2.5;
    public static final double ymin = -2.5;
    public static final double ymax = 2.5;

    // constructor

    // get z
    public static double getZ(double x, double y)
    {
        return x * Math.exp(- x * x - y * y);
    }

    // dz/dx = x*(-2*x)*exp(-x*x-y*y) + exp(-x*x-y*y) = (1-2*x*x)*exp(-x*x-y*y)
    // dz/dy = x*(-2*y)*exp(-x*x-y*y)
    // Both = 0 for
    // 1-2*x*x = 0
    // -2*x*y = 0
    // Two solutions :
    // x = 1/sqrt(2) = 0.70710678 and y = 0 gives maximum z = 1/sqrt(2*e)= 0.42888194
    // x = 1/sqrt(2) = -0.70710678 and y = 0 gives minimum = -1/sqrt(2*e)= -0.42888194
}
