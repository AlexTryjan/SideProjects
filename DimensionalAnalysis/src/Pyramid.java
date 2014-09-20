import java.lang.Math.*;
public class Pyramid implements ExtraDimAnal
{
    public double base = 1;
    public double height = 1;
    public Pyramid(){}
    public Pyramid(double base, double height)
    {
        this.base = base;
        this.height = height;
    }
    public void output()
    {
        double v = volume();
        double s = surfarea();
        double p = baseperimeter();
        System.out.println("Volume: " + v);
        System.out.println("SurfArea: " + s);
        System.out.println("BasePerimeter: " + p);
    }
    public double volume()
    {
        double v = (1.0/3.0)*(Math.pow(base,2))*(height);
        return v;
    }
    public double surfarea()
    {
        double root = ((1.0/4.0)*(base*base))+(height*height)+(base*base);
        double s = 2*base*(Math.pow(root,.5));
        return s;
    }
    public double baseperimeter()
    {
        double p = 4.0*base;
        return p;
    }
}
